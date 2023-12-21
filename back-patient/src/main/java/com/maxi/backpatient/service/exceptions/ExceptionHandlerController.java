package com.maxi.backpatient.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFoundException(EntityNotFoundException e) {
        StandardError err = new StandardError(e.getMessage(), HttpStatus.NOT_FOUND.value(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<StandardError> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        StandardError err = new StandardError("The informate ID format is not matches, it may be a Long file type!",
                HttpStatus.BAD_REQUEST.value(),
                System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandardError> httpMessageNotReadableException(HttpMessageNotReadableException e) {
        StandardError err = new StandardError(
                "The Gender type you have informated is incompartible. We accept: MALE, FEMALE or OTHER like valid type!",
                HttpStatus.BAD_REQUEST.value(),
                System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(ConflictCreattigException.class)
    public ResponseEntity<StandardError> conflictCreattigException(ConflictCreattigException e) {
        StandardError err = new StandardError(e.getMessage(), HttpStatus.CONFLICT.value(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
    }

    /**/ @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> DataIntegrityViolationException(DataIntegrityViolationException e) {
        StandardError err = new StandardError(
                "The type you have informated is incompartible. We accept: MALE, FEMALE or OTHER like valid type!",
                HttpStatus.BAD_REQUEST.value(),
                System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
}
