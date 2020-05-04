package com.springboot.example.hotelreservation.springboothotelreservation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.example.hotelreservation.springboothotelreservation.model.Reservation;
import com.springboot.example.hotelreservation.springboothotelreservation.repository.ReservationRepository;


@Service
public class ReservationService {

	@Autowired
	ReservationRepository reserverepo;
	
	public Reservation getStatusByReserveId(Long reserveId){
		return reserverepo.getReservationDetailsByReserveId(reserveId);
	}
	
public List<Reservation> getAllReservations() {
		
		List<Reservation> reservations = new ArrayList<>();
		reserverepo.findAll().forEach(reservations::add);
		
		return reservations;
	}

public void addReservation(Reservation reservation) {
	reserverepo.save(reservation);
}

// Updates row in table
@Transactional
public void updateReservation(Long id, Reservation reservation) {
	reservation.setReserveId(id);
	reserverepo.save(reservation);
}

// Removes row from table
public void deleteReservation(Long id) {
	reserverepo.deleteById(id);
}
	
}
