package com.talissonmelo.osworks.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.talissonmelo.osworks.domain.model.OrderOfService;
import com.talissonmelo.osworks.domain.repository.OrderOfServiceRepository;
import com.talissonmelo.osworks.domain.service.OrderOfServiceService;

@RestController
@RequestMapping(value = "/orders")
public class OrderOfServiceController {
	
	@Autowired
	private OrderOfServiceService service;
	
	@Autowired
	private OrderOfServiceRepository repository;
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public OrderOfService insert(@Valid @RequestBody OrderOfService order) {
		return service.insert(order);
	}

	@GetMapping
	public List<OrderOfService> findAll(){
		return repository.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrderOfService> findById(@PathVariable Long id){
		Optional<OrderOfService> order = repository.findById(id);
		
		if(order.isPresent()) {
			return ResponseEntity.ok().body(order.get());
		}
		return ResponseEntity.notFound().build();
	}
}

