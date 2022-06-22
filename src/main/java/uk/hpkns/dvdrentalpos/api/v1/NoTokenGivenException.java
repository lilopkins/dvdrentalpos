package uk.hpkns.dvdrentalpos.api.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NoTokenGivenException extends RuntimeException {

    public NoTokenGivenException() {
        super("No token given, but one is required.");
    }
}
