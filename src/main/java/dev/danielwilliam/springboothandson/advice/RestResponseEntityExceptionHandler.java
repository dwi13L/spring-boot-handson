package dev.danielwilliam.springboothandson.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import dev.danielwilliam.springboothandson.exception.ContactNotFoundException;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handling Specific Exceptions
     */
    @ExceptionHandler(ContactNotFoundException.class)
    public ResponseEntity<String> contactNotFoundExceptionHandler(ContactNotFoundException ex) {

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Handling all excepions that do not have a specific handler
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> globalExceptionHandler(Exception ex) {

        return new ResponseEntity<>("Please check your input", HttpStatus.BAD_REQUEST);
    }

}
