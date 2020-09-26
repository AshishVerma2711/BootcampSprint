package com.capgemini.go.service;

import java.util.List;

import com.capgemini.go.dto.RetailerDto;

public interface RetailerService {
	
	RetailerDto addRetailer(RetailerDto retailer);
	RetailerDto updateRetailer(RetailerDto retailer);
	List<RetailerDto> viewRetailers();
	boolean deleteReatiler(String retailerId);
	RetailerDto getRetailer(String retailerId);
}
