package com.ayd2.hotel.dto;

import com.ayd2.hotel.model.RoomType;
import lombok.Value;

@Value
public class RoomTypeResponse {
    Long room_type_id;
    String room_type_name;
    int number_of_beds;
    Double price;

    public RoomTypeResponse(RoomType roomType) {
        this.room_type_id = roomType.getRoomTypeId();
        this.room_type_name = roomType.getRoomTypeName();
        this.number_of_beds = roomType.getNumberOfBeds();
        this.price = roomType.getPrice().doubleValue();
    }
}
