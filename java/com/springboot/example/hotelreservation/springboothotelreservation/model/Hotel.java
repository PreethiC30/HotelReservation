package com.springboot.example.hotelreservation.springboothotelreservation.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hotel")
@NoArgsConstructor
public class Hotel {
	public long getHotelid() {
		return hotelid;
	}

	public void setHotelid(long hotelid) {
		this.hotelid = hotelid;
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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="hotel_id")
    private long hotelid;

	 @Column(name="hotel_name")
	    private String hotelname;

	    @Column(name="city")
	    String city;

	    @Column(name="rating")
	    private int rating;
	    
	    @Column(name="Total_rooms")
	    private int totalrooms;
	
}
