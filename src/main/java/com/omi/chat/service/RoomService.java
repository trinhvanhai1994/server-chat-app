package com.omi.chat.service;

import com.omi.chat.model.entity.Room;

import java.util.List;

public interface RoomService {
    List<Room> findAll();
    Room save(Room room);
    Room findById(long id);
    Room update(Long id, Room room);
    void deleteById(long id);
}
