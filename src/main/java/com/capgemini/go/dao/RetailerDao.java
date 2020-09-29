package com.capgemini.go.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.go.entity.Retailer;

@Repository
public interface RetailerDao extends CrudRepository<Retailer, String> {

	@Query(value = "Select r.retailerId from Retailer r")
	public List<String> getAllRetailerIds();

	public boolean existsByEmail(String email);
}
