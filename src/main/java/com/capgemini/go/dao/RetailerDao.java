package com.capgemini.go.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.go.dto.RetailerDto;

@Repository
public interface RetailerDao extends CrudRepository<RetailerDto, String> {
	
	@Query(value= "Select r.retailerId from RetailerDto r")
	public List<String> getAllRetailerIds();
	public boolean existsByEmail(String email);
}
