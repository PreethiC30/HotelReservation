package com.springboot.example.hotelreservation.springboothotelreservation.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.example.hotelreservation.springboothotelreservation.model.Hotel;
import com.springboot.example.hotelreservation.springboothotelreservation.model.Room;
import com.springboot.example.hotelreservation.springboothotelreservation.model.Search;
import com.springboot.example.hotelreservation.springboothotelreservation.model.User;
import com.springboot.example.hotelreservation.springboothotelreservation.model.UserLogin;
import com.springboot.example.hotelreservation.springboothotelreservation.repository.SearchRepository;
import com.springboot.example.hotelreservation.springboothotelreservation.service.HotelService;
import com.springboot.example.hotelreservation.springboothotelreservation.service.RoomTypeService;
import com.springboot.example.hotelreservation.springboothotelreservation.service.SearchHotelsService;
import com.springboot.example.hotelreservation.springboothotelreservation.service.UserService;

@CrossOrigin(origins = "*")
@RestController
public class HotelController {

	@Autowired
	public HotelService hotelService;
	
	@Autowired
	public RoomTypeService roomService;
	
	@Autowired
	public SearchRepository searchhotel;
	
	@Autowired
	public UserService userService;
	
	@Autowired
	public UserLogin seeker;
	
	@RequestMapping(value = "/register", method=RequestMethod.POST ,consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addUser(@RequestBody User user){
		System.out.println("incontroller"+user.getPassword());
		userService.addUser(user);
		return new ResponseEntity<User>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/validateuserexists/{email}", method = RequestMethod.GET)
	public boolean validateuserexists(@PathVariable String email) {
		System.out.println(email);
		return userService.validateemailexists(email);
	}
	
	
	@RequestMapping(value = "/hotelsbycity/{city}/{roomtype}", method = RequestMethod.GET)
	public List<Search> getAllHotelsByCity(@PathVariable String city,@PathVariable String roomtype) {
		List<Room> roomtypelist= roomService.findRoomByType(roomtype);
		List <Hotel> hotellist= hotelService.getAllHotelsByCity(city);
		return searchhotel.searchhotel(hotellist, roomtypelist);
		//return searchhotelservice.fetchSearch();
	}
	
	@RequestMapping(value = "/hotelsbycity/{city}", method = RequestMethod.GET)
	public List<Hotel> getAllHotelsByCity(@PathVariable String city) {
		List <Hotel> hotellist= hotelService.getAllHotelsByCity(city);
		return hotellist;
	}
	
	@RequestMapping(value = "/hotels", method = RequestMethod.GET)
	public List<Hotel> getAllHotels() {
		return hotelService.getAllHotels();
	}
	
	@RequestMapping(value = "/rooms", method = RequestMethod.GET)
	public List<Room> getAllRoomsByType() {
		return roomService.getAllRooms();
	}
	
	@RequestMapping(value = "/rooms/{roomtype}", method = RequestMethod.GET)
	public List<Room> getAllRoomsByType(@PathVariable String roomtype) {
		return roomService.findRoomByType(roomtype);
	}
	
	@PostMapping(value = "/hotels",consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Hotel> addReservation(@RequestBody Hotel hotel) {
		hotelService.addHotel(hotel);
		return new ResponseEntity<Hotel>(HttpStatus.CREATED);
		
	}
	
	@PostMapping(value = "/rooms",consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Hotel> addRooms(@RequestBody Room room) {
		roomService.addRoom(room);
		return new ResponseEntity<Hotel>(HttpStatus.CREATED);
		
	}
	
	// ------------ Update a hotel ------------
			@RequestMapping(value = "/hotels/{id}", method = RequestMethod.POST)
			public void updateHotel(@RequestBody Hotel hotel,@PathVariable Long id) {
				 hotelService.updateHotel(id, hotel);
			}
			
   // ------------ Delete a hotel ------------
			@RequestMapping(value = "/hotels/{id}", method = RequestMethod.DELETE)
			public void deleteReservation(@PathVariable Long id) {
				hotelService.deleteHotel(id);
			}
			
// ------------ Update a room ------------
			@RequestMapping(value = "/rooms/{hotelid}/{roomno}", method = RequestMethod.POST)
			public void updateRoom(@RequestBody Room room,@PathVariable Long hotelid,@PathVariable int roomno ) {
			 roomService.updateRoom(hotelid,roomno,room);
			}
			
// ------------ Delete a room ------------
			@RequestMapping(value = "/rooms/{hotelid}/{roomno}", method = RequestMethod.DELETE)
			public void deleteReservation(@RequestBody Room room,@PathVariable Long hotelid,@PathVariable int roomno) {
			roomService.deleteRoom(hotelid,roomno,room);
			}	
	//........................		
			@RequestMapping(method = RequestMethod.POST, value = "/login") 
			public Object userlogin(@RequestBody UserLogin userlogin){

				System.out.println("In logged in -User :"  + userlogin .getEmail());

				try {
					seeker = userService.getuser(userlogin.getEmail());
					if(seeker!=null) {
						if(userlogin.getPassword().equals(seeker.getPassword())) {
							System.out.println("In Seeker");
							System.out.println(seeker);
							return seeker;
						}
						else
							return null;
					}
				}
				catch(Exception e) {
					/*try {
						provider = providerService.getProvider(user.getEmail());
						if(provider!=null) {
							if(user.getPassword().equals(provider.getPassword())) {
								System.out.println("In Provider");
								System.out.println(provider);
								return provider;
							}
						}
						else
							return null;*/
					}//catch(Exception e2) {
//						admin = adminService.getAdmin(user.getEmail());
//						if(admin!=null) {
//							if(user.getPassword().equals(admin.getPassword())) {
//								System.out.println("In Admin");
//								System.out.println(admin);
//								return admin;
//							}
//						}
//						else
//							return null;
					//}
				//}
				
				//	provider = providerService.getProvider(user.getEmail());
				return null;
			}
	
}
