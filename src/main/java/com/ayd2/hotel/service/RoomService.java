package com.ayd2.hotel.service;

import com.ayd2.hotel.dto.RoomResponse;
import com.ayd2.hotel.dto.RoomTypeResponse;
import com.ayd2.hotel.exception.HtlException;
import com.ayd2.hotel.model.Room;
import com.ayd2.hotel.repository.RoomRepository;
import com.ayd2.hotel.repository.RoomTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomTypeRepository roomTypeRepository;

    public Room createRoom(Room entity) throws HtlException {
        var roomOpt = roomRepository.findByRoomCode(entity.getRoomCode());
        if (roomOpt.isPresent()) throw new HtlException("code_already_exists")
                .status(HttpStatus.BAD_REQUEST);

        return roomRepository.save(entity);
    }

    public Room updateRoom(Long roomId, Room entity) throws HtlException {
        if (!roomId.equals(entity.getRoomId())) throw new HtlException("invalid_update");

        var roomOpt = roomRepository.findByRoomCodeAndRoomIdNot(entity.getRoomCode(), roomId);
        if (roomOpt.isPresent()) throw new HtlException("code_already_exists");

        return roomRepository.save(entity);
    }

    public List<RoomResponse> findAll() {
        return roomRepository.findAll()
                .stream()
                .map(RoomResponse::new)
                .collect(Collectors.toList());
    }

    public List<RoomTypeResponse> findAllTypes() {
        return roomTypeRepository.findAll()
                .stream()
                .map(RoomTypeResponse::new)
                .collect(Collectors.toList());
    }

    public List<RoomResponse> findAllAvailable(Date startDate, Date endDate) {
        return roomRepository.findAllAvailable(startDate, endDate)
                .stream()
                .map(RoomResponse::new)
                .collect(Collectors.toList());
    }
}
