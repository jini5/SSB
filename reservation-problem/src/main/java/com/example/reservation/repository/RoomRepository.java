package com.example.reservation.repository;

import com.example.reservation.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {

    public List<Room> findByGrId(Long grId);
}
