package com.talissonmelo.osworks.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talissonmelo.osworks.domain.model.Customers;

public interface CustomersRepository extends JpaRepository<Customers, Long> {
	
	List<Customers> findByName(String name);
	List<Customers> findByNameContaining(String name);

}
