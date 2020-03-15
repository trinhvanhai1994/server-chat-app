package com.omi.chat.controller;

import com.omi.chat.model.entity.Room;
import com.omi.chat.service.RoomService;
import com.omi.chat.service.impl.RoomServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class RoomController {
	private final RoomService service;

	public RoomController(RoomServiceImpl service) {
		this.service = service;
	}

	@GetMapping("/rooms")
	public List<Room> getAll() {
		return service.findAll();
	}

	@GetMapping("/rooms/{id}")
	public Room getById(@PathVariable long id) {
		return service.findById(id);
	}

	@DeleteMapping("/rooms/{id}")
	public void deleteById(@PathVariable long id) {
		service.deleteById(id);
	}

	@PutMapping("/rooms/{id}")
	public ResponseEntity<Room> updateRoom(@PathVariable long id, @RequestBody Room room) {
		room = service.update(id, room);
		return new ResponseEntity<>(room, HttpStatus.OK);
	}

	@PostMapping("/rooms")
	public Room createRoom(@RequestBody Room room) {
		return service.save(room);
	}
}