package com.ayd2.hotel.repository;

import com.ayd2.hotel.model.PaymentReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentReservationRepository extends JpaRepository<PaymentReservation,Long> {
}
