package com.example.roomreservationapp.service;

import com.example.roomreservationapp.model.Room;
import com.example.roomreservationapp.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room salvarRoom(Room room) {
        return roomRepository.save(room);
    }

    public void excluirRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
