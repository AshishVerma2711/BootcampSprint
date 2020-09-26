package com.capgemini.go.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="retailer_table")
public class RetailerDto {

	@Id
	@Column(name="retailer_id")
	String retailerId;
	@Column(name="retailer_name")
	String retailername;
	@Column(name="address")
	String address;
	@Column(name="zipcode")
	String zipcode;
	@Column(name="city")
	String city;
	@Column(name="state")
	String state;
	@Column(name="phone_number")
	String phoneNumber;
	@Column(name="email")
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
