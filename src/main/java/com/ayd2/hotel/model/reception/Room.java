package com.ayd2.hotel.model.reception;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "htl_room")
@Getter
@Setter
public class Room {
    @Id
    @Column(name = "room_id")
    private Long roomId;

    @Column(name = "room_type_id")
    private Long roomTypeId;

    @Column(name = "room_code")
    private String roomCode;

    @Column(name = "htl_level")
    private int htlLevel;
}
