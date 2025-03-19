package huynhlq.dev.udemy.firstproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/// Create a new Exception for duplicate identifier handler
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomErrorException extends RuntimeException {
    public CustomErrorException(String message) {
        super(message);
    }
}
