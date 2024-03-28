package com.ayd2.hotel.controller;

import com.ayd2.hotel.dto.PaymentReservationRequest;
import com.ayd2.hotel.dto.PaymentReservationResponse;
import com.ayd2.hotel.dto.ReservationResponse;
import com.ayd2.hotel.exception.HtlException;
import com.ayd2.hotel.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("payments")
@Slf4j
public class PaymentController {
    private PaymentService paymentService;

    @Autowired

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/reservation/{reservationId}")
    public ResponseEntity<List<PaymentReservationResponse>> getPaymentsOfReservation(@PathVariable("reservationId") Long reservationId) {
        return ResponseEntity.ok(paymentService.getPaymentsOfReservation(reservationId));
    }

    @PostMapping("/reservation")
    public ResponseEntity<PaymentReservationResponse> checkIn (@RequestBody PaymentReservationRequest paymentReservationRequest) throws HtlException {
        return ResponseEntity.ok(paymentService.checkIn(paymentReservationRequest));
    }

}
