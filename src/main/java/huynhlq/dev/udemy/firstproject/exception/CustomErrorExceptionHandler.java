package huynhlq.dev.udemy.firstproject.exception;

import huynhlq.dev.udemy.firstproject.model.response.CustomErrorExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomErrorExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<?> handleProjectIdException(CustomErrorException ex, WebRequest request) {
        return new ResponseEntity<>(new CustomErrorExceptionResponse(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
