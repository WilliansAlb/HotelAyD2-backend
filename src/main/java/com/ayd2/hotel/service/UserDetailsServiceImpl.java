package com.ayd2.hotel.service;

import com.ayd2.hotel.exception.HtlException;
import com.ayd2.hotel.repository.AdmUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AdmUserRepository userRepository;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userOpt = userRepository.findByEmail(username);
        if (userOpt.isEmpty()) throw new HtlException("user_by_email_not_found").status(HttpStatus.NOT_FOUND);

        var user = userOpt.get();
        return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}
