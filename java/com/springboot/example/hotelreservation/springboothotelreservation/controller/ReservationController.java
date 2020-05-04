package com.springboot.example.hotelreservation.springboothotelreservation.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.example.hotelreservation.springboothotelreservation.model.Reservation;
import com.springboot.example.hotelreservation.springboothotelreservation.model.Room;
import com.springboot.example.hotelreservation.springboothotelreservation.service.ReservationService;
import com.springboot.example.hotelreservation.springboothotelreservation.service.RoomTypeService;

@RestController
//@RequestMapping(value="/api")
public class ReservationController {
	@Autowired
    private ReservationService reservationService;
	
	@Autowired
	private RoomTypeService roomTypeService;
	
	

	/*@PostMapping
    public ResponseEntity<Reservation> create(@Validated @RequestBody ReservationRequest request) {
        return new ResponseEntity<>(reservationService.create(request), HttpStatus.CREATED);
    }*/
	
	/*@GetMapping("/roomtype/available/{id}")
    public List<Room> findAvailableRoomTypes(@PathVariable Long id) {
		List<Room> roomvalue=roomTypeService.findAllRoomTypes(id);
		System.out.println(roomvalue);
		//roomvalue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return roomvalue;
}*/
	
	@GetMapping("/ReserveStatus/{id}")
	public Reservation getStatusByReserveId(@PathVariable Long id) {
		Reservation status= reservationService.getStatusByReserveId(id);
		return status;
	}
	
	@RequestMapping(value = "/reservations", method = RequestMethod.GET)
	public List<Reservation> getAllReservations() {
		
		return reservationService.getAllReservations();
		
	}
	
	@PostMapping(value = "/reservations",consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) {
		reservationService.addReservation(reservation);
		return new ResponseEntity<Reservation>(HttpStatus.CREATED);
		
	}
	
	// ------------ Update a reservation ------------
		@RequestMapping(value = "/reservations/{id}", method = RequestMethod.POST)
		public void updateReservation(@RequestBody Reservation reservation,@PathVariable Long id) {
			 reservationService.updateReservation(id, reservation);
			 //return new ResponseEntity<Reservation>(HttpStatus.)
		}
		
		// ------------ Delete a reservation ------------
		@RequestMapping(value = "/reservations/{id}", method = RequestMethod.DELETE)
		public void deleteReservation(@PathVariable Long id) {
			reservationService.deleteReservation(id);
		}

}
