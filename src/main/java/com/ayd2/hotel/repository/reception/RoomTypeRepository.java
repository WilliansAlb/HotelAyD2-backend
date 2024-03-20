package com.ayd2.hotel.repository.reception;

import com.ayd2.hotel.model.reception.RoomType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomTypeRepository extends CrudRepository<RoomType,Long> {

    @Override
    List<RoomType> findAll();
}
