package com.ayd2.hotel.service;

import com.ayd2.hotel.dto.AuthReqDto;
import com.ayd2.hotel.dto.JwtResDto;
import com.ayd2.hotel.exception.HtlException;
import com.ayd2.hotel.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public JwtResDto createToken(AuthReqDto reqDto) throws HtlException {
        var authData = new UsernamePasswordAuthenticationToken(reqDto.username(), reqDto.password());

        try {
            var authentication = authenticationManager.authenticate(authData);
            if (authentication.isAuthenticated()) {
                var token = jwtService.generateToken(reqDto.username());
                return new JwtResDto(token);
            }
        } catch (IOException e) {
            log.error("Error:", e);
        }

        throw new HtlException("invalid_user");
    }
}
