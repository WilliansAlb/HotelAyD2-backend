package com.ayd2.hotel.repository.reception;

import com.ayd2.hotel.dto.reception.ClientResponse;
import com.ayd2.hotel.model.reception.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client,Long>, JpaRepository<Client, Long> {

    public List<Client> findByIdentificationNo(String identificationNo);
}
