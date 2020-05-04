package com.springboot.example.hotelreservation.springboothotelreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.example.hotelreservation.springboothotelreservation.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	Reservation getReservationDetailsByReserveId(Long id);
}
