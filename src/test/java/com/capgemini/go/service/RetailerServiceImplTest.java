package com.capgemini.go.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.go.dto.RetailerDto;
import com.capgemini.go.excpetion.RetailerExcpetion;

@SpringBootTest
class RetailerServiceImplTest {

	@Autowired
	RetailerService retailerService;
	
	@Test
	void getRetailerListPass() {
		assertThat(retailerService.viewRetailers()).isNotEmpty();
	}

	@Test
	void addRetailerPass() {
		RetailerDto retailer= new RetailerDto("Bansal and sons","121, near ashok plaza","133486","Maholi","Punjab","8958684455","bansalshubhy@gmail.com");
		assertThat(retailerService.addRetailer(retailer)).isNotNull();
		retailerService.deleteReatiler("R10004");
	}
	
	@Test
	void addRetailerExcpetion() {
		RetailerDto retailer= new RetailerDto("Singla Sports", "S.C.F. 128 , Phase 12 SAS Nagar Mohali","160064", "Mohali", "Punjab", "7889546213", "singlasports@gmail.com");
		Assertions.assertThrows(RetailerExcpetion.class,()->{retailerService.addRetailer(retailer);});
	}
	
	@Test
	void updatePass() {
		RetailerDto retailer= new RetailerDto("R10003","Sudhanshu Sports", "S.C.F. 128 , Phase 12 SAS Nagar Mohali","160064", "Mohali", "Punjab", "7889546213", "singlasports@gmail.com");
		assertThat(retailerService.updateRetailer(retailer)).isNotNull();
	}
	
	@Test
	void updateException() {
		RetailerDto retailer= new RetailerDto("R10005","Sudhanshu Sports", "S.C.F. 128 , Phase 12 SAS Nagar Mohali","160064", "Mohali", "Punjab", "7889546213", "singlasports@gmail.com");
		Assertions.assertThrows(RetailerExcpetion.class,()->{retailerService.updateRetailer(retailer);});
	}
	
	@Test
	void getRetailerPass() {
		assertThat(retailerService.getRetailer("R10003")).isNotNull();
	}
	
	@Test
	void getRetailerException() {
		Assertions.assertThrows(RetailerExcpetion.class,()->{retailerService.getRetailer("R10005");});
	}
	
	@Test
	void deletePass() {
		RetailerDto retailer= new RetailerDto("Bansal and sons","121, near ashok plaza","133486","Maholi","Punjab","8958684455","bansalshubhy@gmail.com");
		retailerService.addRetailer(retailer);
		assertThat(retailerService.deleteReatiler("R10004")).isTrue();
	}
	
	@Test
	void deleteException() {
		Assertions.assertThrows(RetailerExcpetion.class,()->{retailerService.deleteReatiler("R10004");});
	}
}
