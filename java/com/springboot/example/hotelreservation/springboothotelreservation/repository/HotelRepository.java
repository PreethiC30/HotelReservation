package com.springboot.example.hotelreservation.springboothotelreservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.example.hotelreservation.springboothotelreservation.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel,Long> {

	List<Hotel> getHotelByCity(String city);
}
