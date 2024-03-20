package com.ayd2.hotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "htl_room_type")
@Getter
@Setter
public class RoomType {

    @Id
    @Column(name = "room_type_id")
    private Long roomTypeId;

    @Column(name = "room_type_name")
    private String roomTypeName;

    @Column(name = "number_of_beds")
    private Integer numberOfBeds;

    @Column(name = "price")
    private BigDecimal price;
}
