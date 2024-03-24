package com.ayd2.hotel.repository;


import com.ayd2.hotel.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
