package com.ayd2.hotel.security;

import com.ayd2.hotel.dto.RoomTypeResponse;
import com.ayd2.hotel.exception.HtlException;
import com.ayd2.hotel.model.RoomType;
import com.ayd2.hotel.repository.RoomTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomTypeService {

    private final RoomTypeRepository roomTypeRepository;

    public Optional<RoomType> findById(Long roomTypeId) {
        return roomTypeRepository.findById(roomTypeId);
    }

    public RoomType update(Long roomTypeId, RoomType roomType) throws HtlException {
        var entity = roomTypeRepository.findById(roomTypeId);
        if (entity.isEmpty()) throw new HtlException("room_type_not_found")
                .status(HttpStatus.NOT_FOUND);

        if (!roomTypeId.equals(roomType.getRoomTypeId())) throw new HtlException("invalid_update");

        return roomTypeRepository.save(roomType);
    }

    public List<RoomTypeResponse> findAll() {
        return roomTypeRepository.findAll()
                .stream()
                .map(RoomTypeResponse::new)
                .toList();
    }
}
