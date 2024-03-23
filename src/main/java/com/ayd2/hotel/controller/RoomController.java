package com.ayd2.hotel.controller;

import com.ayd2.hotel.dto.RoomResponse;
import com.ayd2.hotel.exception.HtlException;
import com.ayd2.hotel.model.Room;
import com.ayd2.hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public ResponseEntity<List<RoomResponse>> findAllRooms() {
        return ResponseEntity.ok(roomService.findAll());
    }

    @GetMapping("{roomId}")
    public ResponseEntity<Room> findById(@PathVariable("roomId") Long roomId) {
        return roomService.findById(roomId)
                .map(room -> new ResponseEntity<>(room, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    @RequestMapping("available")
    public ResponseEntity<List<RoomResponse>> findAllAvailable(@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return ResponseEntity.ok(roomService.findAllAvailable(startDate, endDate));
    }

    @PostMapping
    public ResponseEntity<Room> create(@RequestBody Room entity) throws HtlException {
        var room = roomService.createRoom(entity);
        return new ResponseEntity<>(room, HttpStatus.CREATED);
    }

    @PutMapping("{roomId}")
    public ResponseEntity<Room> update(@PathVariable("roomId") Long roomId, @RequestBody Room entity) throws HtlException {
        var updatedRoom = roomService.updateRoom(roomId, entity);
        return new ResponseEntity<>(updatedRoom, HttpStatus.OK);
    }
}
