package com.talissonmelo.osworks.api.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talissonmelo.osworks.domain.model.Customers;
import com.talissonmelo.osworks.domain.repository.CustomersRepository;

@RestController
@RequestMapping(value = "/customers")
public class CustomersController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private CustomersRepository customersRepository;

	@GetMapping
	public List<Customers> findAll() {
		return customersRepository.findAll();
		//return customersRepository.findByNameContaining("Ta");
	}

}
