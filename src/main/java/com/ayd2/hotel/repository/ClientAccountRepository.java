package com.ayd2.hotel.repository;

import com.ayd2.hotel.model.ClientAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientAccountRepository extends JpaRepository<ClientAccount, Long> {

    ClientAccount findByClientIdAndActive(Long client_id, boolean isActive);
}
