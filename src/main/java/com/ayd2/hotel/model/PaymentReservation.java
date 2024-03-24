package com.ayd2.hotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payment_reservation")
@Getter
@Setter
public class PaymentReservation extends Payment{
    @Column(name = "reservation_id")
    private Long reservationId;
}
