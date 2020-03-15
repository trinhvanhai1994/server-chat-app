package com.omi.chat.service.impl;

import com.omi.chat.repository.RoomRepository;
import com.omi.chat.model.entity.Room;
import com.omi.chat.service.RoomService;
import com.omi.chat.transformer.RoomTransformer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
	private final RoomRepository repository;
	private final RoomTransformer transformer;

	public RoomServiceImpl(RoomRepository repository, RoomTransformer transformer) {
		this.repository = repository;
		this.transformer = transformer;
	}

	public List<Room> findAll() {
		return repository.findAll();
	}

	public Room save(Room room) {
		room.setStatus(true);
		return repository.save(room);
	}

	public Room findById(long id) {
		return repository.findById(id).orElse(null);
	}

	public Room update(Long id, Room room) {
		Room roomLocal = findById(id);
		transformer.updateEntity(roomLocal, room);
		return repository.save(roomLocal);
	}

	public void deleteById(long id) {
		repository.deleteById(id);
	}
}