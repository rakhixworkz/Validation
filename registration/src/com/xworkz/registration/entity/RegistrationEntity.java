package com.xworkz.registration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="registration_details")
public class RegistrationEntity {
	@Id
	@Column(name="r_id")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	@Column(name="r_userName")
	private String userName;
	@Column(name="r_email")
	private String email;
	@Column(name="r_password")
	private String password;
	@Column(name="r_city")
	private String city;
	@Column(name="r_country")
	private String country;
	@Column(name="r_mobNo")
	private long mobileNumber;
	@Column(name="r_indianCitizen")
	private boolean indianCitizen;
	public RegistrationEntity(String userName, String email, String password, String city, String country,
			long mobileNumber, boolean indianCitizen) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.city = city;
		this.country = country;
		this.mobileNumber = mobileNumber;
		this.indianCitizen = indianCitizen;
	}
	

}
