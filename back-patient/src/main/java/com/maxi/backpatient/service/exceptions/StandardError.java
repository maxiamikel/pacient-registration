package com.maxi.backpatient.service.exceptions;

public class StandardError {

    private String message;
    private Integer status;
    private Long instant;

    public StandardError() {
    }

    public StandardError(String message, Integer status, Long instant) {
        this.message = message;
        this.status = status;
        this.instant = instant;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getInstant() {
        return instant;
    }

    public void setInstant(Long instant) {
        this.instant = instant;
    }

}
