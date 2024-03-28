package com.ayd2.hotel.repository;

import com.ayd2.hotel.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    Optional<Reservation> findByReservationIdAndStatusGreaterThanAndStatusLessThan(Long reservationId, int greater, int less);

}
