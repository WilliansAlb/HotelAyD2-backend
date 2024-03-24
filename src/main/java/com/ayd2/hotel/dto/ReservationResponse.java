package com.ayd2.hotel.dto;

import com.ayd2.hotel.model.Reservation;
import lombok.Value;

import java.time.LocalDate;

@Value
public class ReservationResponse {

    Long reservationId;
    Long clientId;
    Long roomId;
    LocalDate entryDate;
    LocalDate reservationFrom;
    LocalDate reservationUntil;
    LocalDate checkInDate;
    LocalDate checkOutDate;
    Long creatorUserId;
    int status;
    Double priceReservation;

    public ReservationResponse(Reservation reservation){
        this.reservationId = reservation.getReservationId();
        this.clientId = reservation.getClientId();
        this.roomId = reservation.getRoomId();
        this.entryDate = reservation.getEntryDate();
        this.reservationFrom = reservation.getReservationFrom();
        this.reservationUntil = reservation.getReservationUntil();
        this.checkInDate = reservation.getCheckInDate();
        this.checkOutDate = reservation.getCheckOutDate();
        this.creatorUserId = reservation.getCreatorUserId();
        this.status = reservation.getStatus();
        this.priceReservation = reservation.getPriceReservation();
    }
}
