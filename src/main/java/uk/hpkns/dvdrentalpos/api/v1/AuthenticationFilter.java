package uk.hpkns.dvdrentalpos.api.v1;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.hpkns.dvdrentalpos.data.models.auth.StaffToken;
import uk.hpkns.dvdrentalpos.data.repositories.auth.StaffTokensRepository;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class AuthenticationFilter implements Filter {

    public static final String ATTRIBUTE = "authentication-result";

    @Autowired
    private StaffTokensRepository tokensRepository;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader("x-token");

        if (token == null) {
            request.setAttribute(ATTRIBUTE, AuthenticationResult.NO_TOKEN);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        Optional<StaffToken> staffToken = tokensRepository.findByToken(token);
        if (staffToken.isEmpty()) {
            request.setAttribute(ATTRIBUTE, AuthenticationResult.INVALID_TOKEN);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        StaffToken st = staffToken.get();
        if (st.getValidUntil().isBefore(LocalDateTime.now())) {
            tokensRepository.delete(st);
            request.setAttribute(ATTRIBUTE, AuthenticationResult.EXPIRED_TOKEN);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        if (!st.getValidFromIp().equals(request.getRemoteAddr())) {
            request.setAttribute(ATTRIBUTE, AuthenticationResult.TOKEN_USED_FROM_WRONG_ADDRESS);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        request.setAttribute(ATTRIBUTE, AuthenticationResult.AUTHENTICATED);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public enum AuthenticationResult {
        NO_TOKEN,
        INVALID_TOKEN,
        EXPIRED_TOKEN,
        TOKEN_USED_FROM_WRONG_ADDRESS,
        AUTHENTICATED;

        /**
         * Throw an exception of the correct kind if the user is not authenticated fully.
         */
        public void intoException() {
            switch (this) {
                case NO_TOKEN -> throw new NoTokenGivenException();
                case INVALID_TOKEN -> throw new InvalidTokenException();
                case EXPIRED_TOKEN -> throw new ExpiredTokenException();
                case TOKEN_USED_FROM_WRONG_ADDRESS -> throw new TokenUsedFromWrongAddressException();
            }
        }
    }
}
