package com.ayd2.hotel.service.reception;

import com.ayd2.hotel.dto.reception.RoomResponse;
import com.ayd2.hotel.dto.reception.RoomTypeResponse;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface RoomService {
    List<RoomResponse> findAll();

    List<RoomTypeResponse> findAllTypes();

    List<RoomResponse> findAllAvailable(Date startDate, Date endDate);
}
