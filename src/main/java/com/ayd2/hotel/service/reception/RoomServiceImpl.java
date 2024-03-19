package com.ayd2.hotel.service.reception;

import com.ayd2.hotel.dto.reception.RoomResponse;
import com.ayd2.hotel.dto.reception.RoomTypeResponse;
import com.ayd2.hotel.repository.reception.RoomRepository;
import com.ayd2.hotel.repository.reception.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService{
    private RoomRepository roomRepository;
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository, RoomTypeRepository roomTypeRepository) {
        this.roomRepository = roomRepository;
        this.roomTypeRepository = roomTypeRepository;
    }

    @Override
    public List<RoomResponse> findAll() {
        return roomRepository.findAll()
                .stream()
                .map(RoomResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<RoomTypeResponse> findAllTypes() {
        return roomTypeRepository.findAll()
                .stream()
                .map(RoomTypeResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<RoomResponse> findAllAvailable(Date startDate, Date endDate) {
        return roomRepository.findAllAvailable(startDate, endDate)
                .stream()
                .map(RoomResponse::new)
                .collect(Collectors.toList());
    }
}
