package com.ayd2.hotel.repository.reception;

import com.ayd2.hotel.model.reception.PaymentReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentReservationRepository extends JpaRepository<PaymentReservation,Long> {
}
