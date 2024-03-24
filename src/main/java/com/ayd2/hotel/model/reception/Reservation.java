package com.ayd2.hotel.model.reception;

import com.ayd2.hotel.util.HtlConstant;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "htl_reservation")
@Getter
@Setter
public class Reservation {
    @Id
    @Column(name = "reservation_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservationIdGenerator")
    @SequenceGenerator(name = "reservationIdGenerator", sequenceName = "SEQ_HTL_RESERVATION", initialValue = 15000, allocationSize = 1)
    Long reservationId;

    @Column(name = "client_id")
    Long clientId;

    @Column(name = "room_id")
    Long roomId;

    @JsonFormat(pattern = HtlConstant.DATE_FORMAT, shape = JsonFormat.Shape.STRING)
    @Column(name = "entry_date")
    LocalDate entryDate;

    @JsonFormat(pattern = HtlConstant.DATE_FORMAT, shape = JsonFormat.Shape.STRING)
    @Column(name = "reservation_from")
    LocalDate reservationFrom;

    @JsonFormat(pattern = HtlConstant.DATE_FORMAT, shape = JsonFormat.Shape.STRING)
    @Column(name = "reservation_until")
    LocalDate reservationUntil;

    @JsonFormat(pattern = HtlConstant.DATE_FORMAT, shape = JsonFormat.Shape.STRING)
    @Column(name = "check_in_date")
    LocalDate checkInDate;

    @JsonFormat(pattern = HtlConstant.DATE_FORMAT, shape = JsonFormat.Shape.STRING)
    @Column(name = "check_out_date")
    LocalDate checkOutDate;

    @Column(name = "creator_user_id")
    Long creatorUserId;

    @Column(name = "status")
    int status;

    @Column(name = "price_reservation")
    Double priceReservation;
}
