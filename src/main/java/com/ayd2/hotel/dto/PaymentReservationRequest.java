package com.ayd2.hotel.dto;

import lombok.Value;

import java.time.LocalDate;

@Value
public class PaymentReservationRequest {
    Long account_id;
    LocalDate date;
    double total;
    String description;
    Long reservation_id;
}
