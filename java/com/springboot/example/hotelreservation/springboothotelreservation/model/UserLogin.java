package com.springboot.example.hotelreservation.springboothotelreservation.model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.stereotype.Component;
@Component
@MappedSuperclass
public class UserLogin  {
@Id
private String email;
private String password;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


}
