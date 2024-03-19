package com.ayd2.hotel.repository;

import com.ayd2.hotel.model.AdmUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdmUserRepository extends JpaRepository<AdmUser, Long> {

    Optional<AdmUser> findByEmail(String email);
}
