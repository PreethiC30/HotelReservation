package com.springboot.example.hotelreservation.springboothotelreservation.model;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import lombok.Data;


@Component
public class Search {
	public Search(int roomno, String roomType, String hotelname, String city, int rating, int totalrooms) {
		super();
		this.roomno = roomno;
		this.roomType = roomType;
		this.hotelname = hotelname;
		this.city = city;
		this.rating = rating;
		this.totalrooms = totalrooms;
	}
	
	public Search(){
		
	}
	private int roomno;
	String roomType;
	private long hotelId;
	private String hotelname;
	String city;
	private int rating;
	private int totalrooms;
	public int getRoomno() {
		return roomno;
	}
	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}
	public long getHotelId() {
		return hotelId;
	}
	public void setHotelId(long hotelId) {
		this.hotelId = hotelId;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getTotalrooms() {
		return totalrooms;
	}
	public void setTotalrooms(int totalrooms) {
		this.totalrooms = totalrooms;
	}
}
