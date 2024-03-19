package com.ayd2.hotel.service;

import com.ayd2.hotel.dto.CollectionPage;
import com.ayd2.hotel.exception.HtlException;
import com.ayd2.hotel.model.AdmUser;
import com.ayd2.hotel.repository.AdmUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdmUserService {

    private final AdmUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Optional<AdmUser> findById(Long userId) {
        return userRepository.findById(userId);
    }

    public CollectionPage<List<AdmUser>, Long> findAll(Pageable pageable) {
        var users = userRepository.findAll(pageable);
        return CollectionPage.of(users.toList(), users.getTotalElements());
    }

    public AdmUser create(AdmUser entity) throws HtlException {
        var userByEmail = userRepository.findByEmail(entity.getEmail());
        if (userByEmail.isPresent()) throw new HtlException("email_already_exists");
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return userRepository.save(entity);
    }
}
