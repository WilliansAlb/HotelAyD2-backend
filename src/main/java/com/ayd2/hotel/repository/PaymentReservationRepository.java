package com.ayd2.hotel.repository;

import com.ayd2.hotel.model.PaymentReservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentReservationRepository extends JpaRepository<PaymentReservation,Long> {

    List<PaymentReservation> findAllByReservationId(Long reservationId);
}
