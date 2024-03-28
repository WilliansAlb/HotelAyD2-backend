package com.ayd2.hotel.dto;

import com.ayd2.hotel.model.PaymentReservation;
import lombok.Value;

import java.time.LocalDate;

@Value
public class PaymentReservationResponse {
    Long payment_id;
    Long account_id;
    LocalDate date;
    double total;
    String description;
    Long reservation_id;

    public PaymentReservationResponse(PaymentReservation paymentReservation){
        this.payment_id = paymentReservation.getPaymentId();
        this.account_id = paymentReservation.getAccountId();
        this.date = paymentReservation.getDate();
        this.total = paymentReservation.getTotal();
        this.description = paymentReservation.getDescription();
        this.reservation_id = paymentReservation.getReservationId();
    }
}
