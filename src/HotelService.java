package com.springboot.example.hotelreservation.springboothotelreservation.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.example.hotelreservation.springboothotelreservation.model.Hotel;
import com.springboot.example.hotelreservation.springboothotelreservation.repository.HotelRepository;

@Service
public class HotelService {

	@Autowired
	HotelRepository hotelrepo;
	
	
public List<Hotel> getAllHotelsByCity(String city) {
		
		List<Hotel> hotels = new ArrayList<>();
		hotelrepo.getHotelByCity(city).forEach(hotels::add);
		
		return hotels;
	}

public List<Hotel> getAllHotels() {
	
	List<Hotel> hotels = new ArrayList<>();
	hotelrepo.findAll().forEach(hotels::add);
	
	return hotels;
}

public void addHotel(Hotel hotel) {
	hotelrepo.save(hotel);
}

// Updates row in table
@Transactional
public void updateHotel(Long id, Hotel hotel) {
	hotel.setHotelid(id);
	hotelrepo.save(hotel);
}

// Removes row from table
public void deleteHotel(Long id) {
	hotelrepo.deleteById(id);
}
}
