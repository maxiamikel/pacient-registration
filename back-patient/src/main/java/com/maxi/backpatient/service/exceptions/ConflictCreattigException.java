package com.maxi.backpatient.service.exceptions;

public class ConflictCreattigException extends RuntimeException {

    public ConflictCreattigException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConflictCreattigException(String message) {
        super(message);
    }

}
