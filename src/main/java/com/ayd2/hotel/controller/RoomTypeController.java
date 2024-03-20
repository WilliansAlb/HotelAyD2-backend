package com.ayd2.hotel.controller;

import com.ayd2.hotel.dto.RoomTypeResponse;
import com.ayd2.hotel.exception.HtlException;
import com.ayd2.hotel.model.RoomType;
import com.ayd2.hotel.security.RoomTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("room-types")
@RequiredArgsConstructor
public class RoomTypeController {

    private final RoomTypeService roomTypeService;

    @GetMapping("{roomTypeId}")
    public ResponseEntity<RoomType> findById(@PathVariable("roomTypeId") Long roomTypeId) {
        return roomTypeService.findById(roomTypeId)
                .map(roomType -> new ResponseEntity<>(roomType, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<RoomTypeResponse>> findAll() {
        var roomTypes = roomTypeService.findAll();
        return new ResponseEntity<>(roomTypes, HttpStatus.OK);
    }

    @PutMapping("{roomTypeId}")
    public ResponseEntity<RoomType> update(@PathVariable("roomTypeId") Long roomTypeId, @RequestBody RoomType entity) throws HtlException {
        var updatedRoomType = roomTypeService.update(roomTypeId, entity);
        return new ResponseEntity<>(updatedRoomType, HttpStatus.OK);
    }
}
