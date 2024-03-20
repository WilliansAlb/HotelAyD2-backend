package com.ayd2.hotel.repository.reception;

import com.ayd2.hotel.model.reception.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface RoomRepository extends CrudRepository<Room,Long>, JpaRepository<Room, Long> {

    @Override
    List<Room> findAll();

    @Query(value = "SELECT * FROM check_room_availability_v2(:start_date,:end_date);", nativeQuery = true)
    List<Room> findAllAvailable(@Param("start_date") Date start_date, @Param("end_date") Date end_date);
}
