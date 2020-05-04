package com.springboot.example.hotelreservation.springboothotelreservation.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "room")
@NoArgsConstructor
@IdClass(Room.RoomId.class)
public class Room {
	@Id
	@Column(name="room_no")
	private int roomno;
	@Id
	@Column(name="hotel_id")
    private long hotelId;

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

	public void setRoomType(String roomtype) {
		this.roomType = roomtype;
	}

	@NotBlank
	@Column(name = "room_type")
	String roomType;
	
	@Data 
	 static class RoomId implements Serializable {
	    private int roomno;
	    private long hotelId;
	}

	/*
	 * 
    {
        "roomno": 100,
        "hotelId": 1,
        "roomType": "Economic"
    }
    
    	{
	"hotelname":"Taj",
	"city":"Bangalore",
	"rating":3,
	"totalrooms":100
	}
	 */
}

