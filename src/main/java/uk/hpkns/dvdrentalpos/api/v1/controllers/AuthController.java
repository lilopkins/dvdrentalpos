package uk.hpkns.dvdrentalpos.api.v1.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import uk.hpkns.dvdrentalpos.api.v1.AuthenticationFilter;
import uk.hpkns.dvdrentalpos.api.v1.InvalidTokenException;
import uk.hpkns.dvdrentalpos.api.v1.NoTokenGivenException;
import uk.hpkns.dvdrentalpos.data.models.Staff;
import uk.hpkns.dvdrentalpos.data.models.auth.CustomerLogin;
import uk.hpkns.dvdrentalpos.data.models.auth.CustomerToken;
import uk.hpkns.dvdrentalpos.data.models.auth.StaffToken;
import uk.hpkns.dvdrentalpos.data.repositories.StaffRepository;
import uk.hpkns.dvdrentalpos.data.repositories.auth.CustomerLoginsRepository;
import uk.hpkns.dvdrentalpos.data.repositories.auth.CustomerTokensRepository;
import uk.hpkns.dvdrentalpos.data.repositories.auth.StaffTokensRepository;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final CustomerLoginsRepository customerLoginsRepository;
    private final CustomerTokensRepository customerTokensRepository;
    private final StaffRepository staffRepository;
    private final StaffTokensRepository staffTokensRepository;

    private static final String INVALID_CREDENTIALS = "Invalid username/password";
    private static final Random RANDOM = new Random();

    public AuthController(CustomerLoginsRepository customerLoginsRepository, CustomerTokensRepository customerTokensRepository, StaffRepository staffRepository, StaffTokensRepository staffTokensRepository) {
        this.customerLoginsRepository = customerLoginsRepository;
        this.customerTokensRepository = customerTokensRepository;
        this.staffRepository = staffRepository;
        this.staffTokensRepository = staffTokensRepository;
    }

    @GetMapping("/status")
    public @ResponseBody AuthenticationFilter.AuthenticationResult getStatus(HttpServletRequest request) {
        return (AuthenticationFilter.AuthenticationResult) request.getAttribute(AuthenticationFilter.ATTRIBUTE);
    }

    @GetMapping("/profile")
    public @ResponseBody Object getProfile(HttpServletRequest request) {
        String token = request.getHeader("x-token");
        if (token == null) throw new NoTokenGivenException();

        Optional<StaffToken> staffToken = staffTokensRepository.findByToken(token);
        Optional<CustomerToken> customerToken = customerTokensRepository.findByToken(token);
        if (staffToken.isPresent()) {
            return staffToken.get().getStaff();
        } else if (customerToken.isPresent()) {
            return customerToken.get().getCustomer();
        } else {
            throw new InvalidTokenException();
        }
    }

    @PostMapping("/signin")
    public @ResponseBody TokenPayload signin(@RequestBody AuthPayload payload, HttpServletRequest request) {
        String passwordHash = getSha1Hash(payload.password);
        // Check for staff first
        Optional<Staff> staff = staffRepository.findByUsername(payload.username);
        if (staff.isPresent()) {
            // Check staff details
            if (Objects.equals(staff.get().getPassword(), passwordHash)) {
                // Generate and return token
                StaffToken token = new StaffToken(staff.get().getId(),
                        generateToken(request.getRemoteAddr()),
                        request.getRemoteAddr(),
                        LocalDateTime.now().plusDays(1));
                staffTokensRepository.save(token);
                return new TokenPayload(staff.get().getUsername(), "staff", token.getToken());
            }
            return new TokenPayload(INVALID_CREDENTIALS);
        }

        // Check for customer
        Optional<CustomerLogin> customer =  customerLoginsRepository.findByUsername(payload.username);
        if (customer.isPresent()) {
            if (Objects.equals(customer.get().getPasswordHash(), passwordHash)) {
                // Generate and return token
                CustomerToken token = new CustomerToken(customer.get().getCustomerId(),
                        generateToken(request.getRemoteAddr()),
                        request.getRemoteAddr(),
                        LocalDateTime.now().plusDays(1));
                customerTokensRepository.save(token);
                return new TokenPayload(customer.get().getUsername(), "cust", token.getToken());
            }
            return new TokenPayload(INVALID_CREDENTIALS);
        }

        return new TokenPayload(INVALID_CREDENTIALS);
    }

    private static String generateToken(String ip) {
        String tokenBasis = ip + ":" + RANDOM.nextInt(100000);
        return getSha1Hash(tokenBasis);
    }

    protected static String getSha1Hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            StringBuilder hash = new StringBuilder(no.toString(16));
            while (hash.length() < 32) {
                hash.insert(0, "0");
            }
            return hash.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("unreachable");
        }
    }

    protected static class AuthPayload {
        String username;
        String password;

        public void setUsername(String username) {
            this.username = username;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    protected static class TokenPayload {
        boolean success;
        String message;
        String username;
        String scope;
        String token;

        public TokenPayload(String message) {
            this.success = false;
            this.message = message;
        }

        public TokenPayload(String username, String scope, String token) {
            this.success = true;
            this.message = null;
            this.username = username;
            this.scope = scope;
            this.token = token;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }

        public String getUsername() {
            return username;
        }

        public String getScope() {
            return scope;
        }

        public String getToken() {
            return token;
        }
    }
}
