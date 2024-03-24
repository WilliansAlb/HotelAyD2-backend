package com.ayd2.hotel.dto.reception;
import lombok.Value;

import java.time.LocalDate;

@Value
public class NewReservationRequest {
    Long client_id;
    Long room_id;
    LocalDate reservation_from;
    LocalDate reservation_until;
    Double payment;
    Double price;
    LocalDate entry_date;
}
