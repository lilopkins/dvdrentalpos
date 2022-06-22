package uk.hpkns.dvdrentalpos.api.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class ExpiredTokenException extends RuntimeException {

    public ExpiredTokenException() {
        super("Expired token.");
    }
}
