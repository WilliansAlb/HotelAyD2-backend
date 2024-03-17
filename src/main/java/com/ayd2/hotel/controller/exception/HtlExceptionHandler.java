package com.ayd2.hotel.controller.exception;

import com.ayd2.hotel.exception.HtlException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HtlExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HtlException.class)
    public ResponseEntity<String> handleHtlException(HtlException ex) {
        return new ResponseEntity<>(ex.getMessage(), ex.getStatus());
    }
}
