package com.ayd2.hotel.repository;

import com.ayd2.hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query(value = "SELECT * FROM check_room_availability_v2(:start_date,:end_date);", nativeQuery = true)
    List<Room> findAllAvailable(@Param("start_date") Date start_date, @Param("end_date") Date end_date);

    Optional<Room> findByRoomCode(String code);

    Optional<Room> findByRoomCodeAndRoomIdNot(String code, Long roomId);
}
