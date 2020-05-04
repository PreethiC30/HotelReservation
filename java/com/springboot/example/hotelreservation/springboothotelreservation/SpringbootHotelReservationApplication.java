package com.springboot.example.hotelreservation.springboothotelreservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@ComponentScan(basePackages={"com.springboot.example.hotelreservation.springboothotelreservation"})
@EnableAutoConfiguration
public class SpringbootHotelReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHotelReservationApplication.class, args);
	}

}