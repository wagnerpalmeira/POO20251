package com.example.roomreservationapp.repository;

import com.example.roomreservationapp.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
