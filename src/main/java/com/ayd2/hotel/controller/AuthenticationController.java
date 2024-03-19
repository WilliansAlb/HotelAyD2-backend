package com.ayd2.hotel.controller;

import com.ayd2.hotel.dto.AuthReqDto;
import com.ayd2.hotel.dto.JwtResDto;
import com.ayd2.hotel.exception.HtlException;
import com.ayd2.hotel.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<JwtResDto> createToken(@RequestBody AuthReqDto reqDto) throws HtlException {
        var token = authenticationService.createToken(reqDto);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
