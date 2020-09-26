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

@RestController
public class RetailerController {

	@Autowired
	RetailerService retailerService;
	
	@PostMapping(path="/addRetailer")
	@ResponseBody
	public ResponseEntity<RetailerDto> addRetailer(@RequestBody RetailerDto retailerDto){
		RetailerDto addedRetailer= retailerService.addRetailer(retailerDto);
		return new ResponseEntity<RetailerDto>(addedRetailer,HttpStatus.OK);
	}
	
	@PutMapping(path="/updateRetailer")
	@ResponseBody
	public ResponseEntity<RetailerDto> updateRetailer(@RequestBody RetailerDto retailerDto){
		RetailerDto updatedRetailer= retailerService.updateRetailer(retailerDto);
		return new ResponseEntity<RetailerDto>(updatedRetailer,HttpStatus.OK);
	}
	
	@GetMapping(path="/getAllRetailers")
	@ResponseBody
	public ResponseEntity<List<RetailerDto>> getAllRetailers(){
		List<RetailerDto> retailerList= retailerService.viewRetailers();
		return new ResponseEntity<List<RetailerDto>>(retailerList,HttpStatus.OK);
	}
	
	@DeleteMapping(path="/deleteRetailer/{retailerId}")
	public ResponseEntity<String> deleteRetailer(@PathVariable("retailerId") String retailerId){
		retailerService.deleteReatiler(retailerId);
		return new ResponseEntity<String>("Successfully Deleted",HttpStatus.OK);
	}
	
	@GetMapping(path="/getRetailer/{retailerId}")
	@ResponseBody
	public ResponseEntity<RetailerDto> getRetailer(@PathVariable("retailerId") String retailerId){
		RetailerDto retailer = retailerService.getRetailer(retailerId);
		return new ResponseEntity<RetailerDto>(retailer,HttpStatus.OK);
	}
}
