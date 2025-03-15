package huynhlq.dev.udemy.firstproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/// Create a new Exception for duplicate identifier handler
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IdException extends RuntimeException {
    public IdException(String message) {
        super(message);
    }
}
