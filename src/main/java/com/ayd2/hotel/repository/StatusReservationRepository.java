package com.ayd2.hotel.repository;

import com.ayd2.hotel.model.StatusReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusReservationRepository extends JpaRepository<StatusReservation,Long> {
}
