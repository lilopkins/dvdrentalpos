package uk.hpkns.dvdrentalpos.api.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class TokenUsedFromWrongAddressException extends RuntimeException {

    public TokenUsedFromWrongAddressException() {
        super("This token is bound to a different address from the one this request was made from.");
    }
}
