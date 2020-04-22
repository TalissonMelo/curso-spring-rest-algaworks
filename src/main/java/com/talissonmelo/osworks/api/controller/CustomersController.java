package com.talissonmelo.osworks.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.talissonmelo.osworks.domain.model.Customers;
import com.talissonmelo.osworks.domain.repository.CustomersRepository;

@RestController
@RequestMapping(value = "/customers")
public class CustomersController {
	
	@Autowired
	private CustomersRepository customersRepository;

	@GetMapping
	public List<Customers> findAll() {
		return customersRepository.findAll();
		//return customersRepository.findByNameContaining("Ta");
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Customers> findById(@PathVariable Long id) {
		Optional<Customers> client = customersRepository.findById(id);
		
		if(client.isPresent()) {
			return ResponseEntity.ok().body(client.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Customers insert(@Valid @RequestBody Customers client) {
		return customersRepository.save(client);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Customers> update(@Valid @PathVariable Long id, @RequestBody Customers client){
		if(!customersRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		client.setId(id);
		customersRepository.save(client);
		return ResponseEntity.ok().body(client);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		if(!customersRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		customersRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
