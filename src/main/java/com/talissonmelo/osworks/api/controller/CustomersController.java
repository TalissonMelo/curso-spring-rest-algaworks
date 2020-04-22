package com.talissonmelo.osworks.api.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talissonmelo.osworks.domain.model.Customers;

@RestController
@RequestMapping(value = "/customers")
public class CustomersController {
	
	@PersistenceContext
	private EntityManager manager;

	@GetMapping
	public List<Customers> findAll() {
		return manager.createQuery("from Customers" , Customers.class).getResultList();
	}

}
