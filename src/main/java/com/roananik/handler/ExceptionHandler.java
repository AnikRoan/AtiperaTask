package com.roananik.handler;
import org.kohsuke.github.GHFileNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(GHFileNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleValidationErrors(GHFileNotFoundException ex) {
       ErrorDetails errorDetails = ErrorDetails.builder()
               .status(HttpStatus.NOT_FOUND.value())
               .message(ex.getMessage()
                       .trim())
               .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }
}
