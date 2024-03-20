package com.ayd2.hotel.controller.reception;

import com.ayd2.hotel.dto.reception.RoomResponse;
import com.ayd2.hotel.dto.reception.RoomTypeResponse;
import com.ayd2.hotel.service.reception.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("rooms")
@Slf4j
public class RoomController {
    private RoomService roomService;

    public RoomController(RoomService roomService){
        this.roomService = roomService;
    }

    @GetMapping
    public ResponseEntity<List<RoomResponse>> findAllRooms(){
        return ResponseEntity.ok(roomService.findAll());
    }

    @GetMapping
    @RequestMapping("types")
    public ResponseEntity<List<RoomTypeResponse>> findAllTypes(){
        return ResponseEntity.ok(roomService.findAllTypes());
    }

    @GetMapping
    @RequestMapping("available")
    public ResponseEntity<List<RoomResponse>> findAllAvailable(@RequestParam("startDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate, @RequestParam("endDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate){
        return ResponseEntity.ok(roomService.findAllAvailable(startDate,endDate));
    }
}
