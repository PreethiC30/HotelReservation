package com.springboot.example.hotelreservation.springboothotelreservation.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usertable")
@NoArgsConstructor
public class User {

	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "customer_id")
	    private Long id;

	    @Column(name = "first_name")
	    private String firstName;
	    
	    @Column(name = "last_name")
	    private String lastName;
	    
	   
		@Column(name = "email", nullable = false, unique = true)
		@Email(message = "Please provide a valid e-mail")
		@NotEmpty(message = "Please provide an e-mail")
		private String email;
		
		@Column(name = "password")
		private String password;

	    public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

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
