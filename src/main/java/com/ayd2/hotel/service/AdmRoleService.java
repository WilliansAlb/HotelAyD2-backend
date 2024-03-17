package com.ayd2.hotel.service;

import com.ayd2.hotel.dto.CollectionPage;
import com.ayd2.hotel.model.AdmRole;
import com.ayd2.hotel.repository.AdmRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdmRoleService {

    private final AdmRoleRepository roleRepository;

    public Optional<AdmRole> findById(Long roleId) {
        return roleRepository.findById(roleId);
    }

    public CollectionPage<List<AdmRole>, Long> findAll(Pageable pageable) {
        log.info("Page: {}, size: {}", pageable.getPageNumber(), pageable.getPageSize());

        var roles = roleRepository.findAll(pageable);
        return CollectionPage.of(roles.toList(), roles.getTotalElements());
    }
}
