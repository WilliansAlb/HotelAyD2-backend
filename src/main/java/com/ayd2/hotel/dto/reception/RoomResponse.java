package com.ayd2.hotel.dto.reception;

import com.ayd2.hotel.model.reception.Room;
import lombok.Value;

@Value
public class RoomResponse {
    Long room_id;
    Long room_type_id;
    String room_code;
    int htl_level;

    public RoomResponse(Room room){
        this.room_id = room.getRoomId();
        this.room_type_id = room.getRoomTypeId();
        this.room_code = room.getRoomCode();
        this.htl_level = room.getHtlLevel();
    }
}
