package com.ayd2.hotel.exception;

import org.springframework.http.HttpStatus;

public class HtlClient extends Exception{
    private HttpStatus status;

    private HtlClient() {
        this.status = HttpStatus.BAD_REQUEST;
    }

    public HtlClient(String message) {
        super(message);
        this.status = HttpStatus.BAD_REQUEST;
    }

    public HtlClient duplicated() {
        this.status = HttpStatus.CONFLICT;
        return this;
    }
}
