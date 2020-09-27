package com.capgemini.go.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.dto.RetailerDto;
import com.capgemini.go.service.RetailerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@Validated
public class RetailerController {

	@Autowired
	RetailerService retailerService;

	Logger logger = LoggerFactory.getLogger(RetailerController.class);

	@PostMapping(path = "/retailerList")
	public ResponseEntity<RetailerDto> addRetailer(@Valid @RequestBody RetailerDto retailer) {
		RetailerDto addedRetailer = retailerService.addRetailer(retailer);
		logger.debug("Retailer Added Successfully");
		return new ResponseEntity<>(addedRetailer, HttpStatus.OK);
	}

	@PutMapping(path = "/retailerList")
	public ResponseEntity<RetailerDto> updateRetailer(@Valid @RequestBody RetailerDto retailer) {
		RetailerDto updatedRetailer = retailerService.updateRetailer(retailer);
		logger.debug("Retailer Updated Successfully");
		return new ResponseEntity<>(updatedRetailer, HttpStatus.OK);
	}

	@GetMapping(path = "/retailerList")
	public ResponseEntity<List<RetailerDto>> getAllRetailers() {
		List<RetailerDto> retailerList = retailerService.viewRetailers();
		logger.debug("Retailers fetched Successfully");
		return new ResponseEntity<>(retailerList, HttpStatus.OK);
	}

	@DeleteMapping(path = "/retailerList/{retailerId}")
	public ResponseEntity<String> deleteRetailer(@PathVariable("retailerId") @Pattern(regexp="R[0-9]{5}" ,message="Invalid! Id must starts with R and have 5 digits after it.") String retailerId) {
		retailerService.deleteReatiler(retailerId);
		logger.debug("Retailer deleted Successfully");
		return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
	}

	@GetMapping(path = "/retailerList/{retailerId}")
	public ResponseEntity<RetailerDto> getRetailer(@PathVariable("retailerId") @Pattern(regexp="R[0-9]{5}" ,message="Invalid! Id must starts with R and have 5 digits after it.") String retailerId) {
		RetailerDto retailer = retailerService.getRetailer(retailerId);
		logger.debug("Retailer fetched Successfully with id" + retailerId);
		return new ResponseEntity<>(retailer, HttpStatus.OK);
	}
}
