package com.ayd2.hotel.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class HtlException extends Exception {

    private HttpStatus status;

    private HtlException() {
        this.status = HttpStatus.BAD_REQUEST;
    }

    public HtlException(String message) {
        super(message);
        this.status = HttpStatus.BAD_REQUEST;
    }

    public HtlException status(HttpStatus status) {
        this.status = status;
        return this;
    }
}
