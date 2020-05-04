package com.springboot.example.hotelreservation.springboothotelreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.example.hotelreservation.springboothotelreservation.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User getByemail(String email);
	
}
