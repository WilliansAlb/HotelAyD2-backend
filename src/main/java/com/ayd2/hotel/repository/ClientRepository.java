package com.ayd2.hotel.repository;

import com.ayd2.hotel.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    public List<Client> findByIdentificationNo(String identificationNo);
}
