package com.ayd2.hotel.repository.reception;

import com.ayd2.hotel.model.reception.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
