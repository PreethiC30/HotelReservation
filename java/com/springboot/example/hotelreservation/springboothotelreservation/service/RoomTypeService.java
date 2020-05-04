package com.springboot.example.hotelreservation.springboothotelreservation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.example.hotelreservation.springboothotelreservation.model.Hotel;
import com.springboot.example.hotelreservation.springboothotelreservation.model.Room;
import com.springboot.example.hotelreservation.springboothotelreservation.repository.RoomRepository;
@Service
public class RoomTypeService {
	@Autowired
	RoomRepository roomtyperepo;

	public List<Room> findRoomByType(String roomtype){
		List<Room> rooms=new ArrayList<>();
	    roomtyperepo.getByRoomType(roomtype).forEach(rooms::add);
		return rooms;
	}
	
	public List<Room> getAllRooms(){
		List<Room> rooms=new ArrayList<>();
	    roomtyperepo.findAll().forEach(rooms::add);
		return rooms;
	}
	public void addRoom(Room room) {
		roomtyperepo.save(room);
	}

	// Updates row in table
	@Transactional
	public void updateRoom(Long hotelid,int roomno, Room room) {
		room.setHotelId(hotelid);
		room.setRoomno(roomno);
		roomtyperepo.save(room);
	}

	// Removes row from table
	public void deleteRoom(Long hotelid,int roomno, Room room) {
		room.setHotelId(hotelid);
		room.setRoomno(roomno);
		roomtyperepo.delete(room);
	}
}
