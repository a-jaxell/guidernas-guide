package org.guidernas.guideapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalRestExceptionHandler {

    @ExceptionHandler(ActivityNotFoundException.class)
    public ResponseEntity<String> handleActivityNotFound(ActivityNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
