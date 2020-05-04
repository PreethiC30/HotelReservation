package com.springboot.example.hotelreservation.springboothotelreservation.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.example.hotelreservation.springboothotelreservation.model.User;
import com.springboot.example.hotelreservation.springboothotelreservation.model.UserLogin;
import com.springboot.example.hotelreservation.springboothotelreservation.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	UserLogin userlogin;
	

	public void addUser(User user){
		System.out.println("im in adduser service"+user.getFirstName());
		userrepo.save(user);
	}
	
	public UserLogin getuser(String email){
		User user=userrepo.getByemail(email);
		userlogin.setEmail(email);
		userlogin.setPassword(user.getPassword());
		return userlogin;
	}
	
	
	public boolean validateemailexists(String email){
		if(userrepo.getByemail(email)!=null){
			System.out.println("true");
			return true;
		}else{
			System.out.println("false");
			return false;
		}
	}
}
