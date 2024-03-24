package com.ayd2.hotel.controller.reception;

import com.ayd2.hotel.dto.reception.ClientRequest;
import com.ayd2.hotel.dto.reception.ClientResponse;
import com.ayd2.hotel.dto.reception.NewReservationRequest;
import com.ayd2.hotel.dto.reception.ReservationResponse;
import com.ayd2.hotel.exception.HtlClient;
import com.ayd2.hotel.service.reception.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reservations")
@Slf4j
public class ReservationController {
    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) { this.reservationService = reservationService; }

    @PostMapping("/new")
    public ResponseEntity<ReservationResponse> newReservation(@RequestBody NewReservationRequest newReservationRequest) {
        return ResponseEntity.ok(reservationService.createNewReservation(newReservationRequest));
    }

    @GetMapping
    public ResponseEntity<List<ReservationResponse>> getReservations() {
        return ResponseEntity.ok(reservationService.getReservations());
    }
}
