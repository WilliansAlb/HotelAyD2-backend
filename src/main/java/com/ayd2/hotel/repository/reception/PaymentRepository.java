package com.ayd2.hotel.repository.reception;

import com.ayd2.hotel.model.reception.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
