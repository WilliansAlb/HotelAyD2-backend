package com.ayd2.hotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "htl_room")
@Getter
@Setter
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roomIdGenerator")
    @SequenceGenerator(name = "roomIdGenerator", sequenceName = "SEQ_HTL_ROOM", initialValue = 15000, allocationSize = 1)
    @Column(name = "room_id")
    private Long roomId;

    @JoinColumn(name = "room_type_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private RoomType roomType;

    @Column(name = "room_code")
    private String roomCode;

    @Column(name = "htl_level")
    private Integer htlLevel;
}
