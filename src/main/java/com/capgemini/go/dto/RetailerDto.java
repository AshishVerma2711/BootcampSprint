package com.capgemini.go.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="retailer_table")
public class RetailerDto {

	@Id
	@Column(name="retailer_id")
	@Pattern(regexp="R[0-9]{5}" ,message="Invalid! Id must starts with R and have 5 digits after it.")
	String retailerId;
	@Column(name="retailer_name")
	@NotBlank(message = "Name is mandatory")
	@Size(min=2, message="Must be greater than 2")
	@Pattern(regexp="" ,message="Invalid Name! name must starts with capital letter.")
	String retailername;
	@Column(name="address")
	@NotBlank(message = "Address is mandatory")
	String address;
	@Column(name="zipcode")
	@Pattern(regexp="^\\d{3}\\s?\\d{3}$" ,message="Invalid zipcode! Must be of 6 digits")
	@NotBlank(message = "Zip Code is mandatory")
	String zipcode;
	@NotBlank(message = "City is mandatory")
	@Column(name="city")
	String city;
	@Column(name="state")
	@NotBlank(message = "State is mandatory")
	String state;
	@Column(name="phone_number")
	@Pattern(regexp="^[6789][0-9]{9}" ,message="Invalid mobile number!")
	@NotBlank(message = "Phone Number is mandatory")
	String phoneNumber;
	@Column(name="email")
	@Pattern(regexp="^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$" ,message="Invalid email!")
	@NotBlank(message = "Email is mandatory")
	String email;
	
	
	public RetailerDto() {
	}

	public String getRetailerId() {
		return retailerId;
	}

	public void setRetailerId(String retailerId) {
		this.retailerId = retailerId;
	}

	public String getRetailername() {
		return retailername;
	}

	public void setRetailername(String retailername) {
		this.retailername = retailername;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public RetailerDto(String retailerId, String retailername, String address, String zipcode, String city,
			String state, String phoneNumber, String email) {
		super();
		this.retailerId = retailerId;
		this.retailername = retailername;
		this.address = address;
		this.zipcode = zipcode;
		this.city = city;
		this.state = state;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	public RetailerDto(String retailername, String address, String zipcode, String city,
			String state, String phoneNumber, String email) {
		super();
		this.retailername = retailername;
		this.address = address;
		this.zipcode = zipcode;
		this.city = city;
		this.state = state;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
}
