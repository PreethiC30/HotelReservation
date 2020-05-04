package com.springboot.example.hotelreservation.springboothotelreservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.example.hotelreservation.springboothotelreservation.model.Hotel;
import com.springboot.example.hotelreservation.springboothotelreservation.model.Room;
import com.springboot.example.hotelreservation.springboothotelreservation.model.Search;

@Repository
public interface SearchRepository{
	
//	@Query("SELECT new com.springboot.example.hotelreservation.springboothotelreservation.model.Search(d.hotel_name, d.city, d.rating, d.Total_rooms,r.room_type,r.room_no) "
//			+ "FROM Hotel d LEFT JOIN Room r ON d.hotel_id=r.hotel_id")
	//public List<Search> fetchSearch();
	
	public List<Search> searchhotel(List<Hotel> hotellist,List<Room> roomlist);

}
