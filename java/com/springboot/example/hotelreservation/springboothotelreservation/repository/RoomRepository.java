package com.springboot.example.hotelreservation.springboothotelreservation.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springboot.example.hotelreservation.springboothotelreservation.model.Room;

public interface RoomRepository extends CrudRepository<Room, Long> {
	List<Room> getByRoomType(String rtype);
}
