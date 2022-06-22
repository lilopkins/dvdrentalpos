package uk.hpkns.dvdrentalpos.api.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class InvalidTokenException extends RuntimeException {

    public InvalidTokenException() {
        super("Invalid token.");
    }
}
