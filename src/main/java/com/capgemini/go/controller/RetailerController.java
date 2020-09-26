package com.capgemini.go.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.dto.RetailerDto;
import com.capgemini.go.service.RetailerService;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

@RestController
public class RetailerController {

	@Autowired
	RetailerService retailerService;

	Logger logger = LoggerFactory.getLogger(RetailerController.class);

	@PostMapping(path = "/addRetailer")
	@ResponseBody
	public ResponseEntity<RetailerDto> addRetailer(@RequestBody RetailerDto retailer) {
		RetailerDto addedRetailer = retailerService.addRetailer(retailer);
		logger.debug("Retailer Added Successfully");
		return new ResponseEntity<>(addedRetailer, HttpStatus.OK);
	}

	@PutMapping(path = "/updateRetailer")
	@ResponseBody
	public ResponseEntity<RetailerDto> updateRetailer(@RequestBody RetailerDto retailer) {
		RetailerDto updatedRetailer = retailerService.updateRetailer(retailer);
		logger.debug("Retailer Updated Successfully");
		return new ResponseEntity<>(updatedRetailer, HttpStatus.OK);
	}

	@GetMapping(path = "/getAllRetailers")
	@ResponseBody
	public ResponseEntity<List<RetailerDto>> getAllRetailers() {
		List<RetailerDto> retailerList = retailerService.viewRetailers();
		logger.debug("Retailers fetched Successfully");
		return new ResponseEntity<>(retailerList, HttpStatus.OK);
	}

	@DeleteMapping(path = "/deleteRetailer/{retailerId}")
	public ResponseEntity<String> deleteRetailer(@PathVariable("retailerId") String retailerId) {
		retailerService.deleteReatiler(retailerId);
		logger.debug("Retailer deleted Successfully");
		return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
	}

	@GetMapping(path = "/getRetailer/{retailerId}")
	@ResponseBody
	public ResponseEntity<RetailerDto> getRetailer(@PathVariable("retailerId") String retailerId) {
		RetailerDto retailer = retailerService.getRetailer(retailerId);
		logger.debug("Retailer fetched Successfully with id" + retailerId);
		return new ResponseEntity<>(retailer, HttpStatus.OK);
	}
}
