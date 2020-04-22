package com.talissonmelo.osworks.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talissonmelo.osworks.domain.model.Customers;
import com.talissonmelo.osworks.domain.repository.CustomersRepository;
import com.talissonmelo.osworks.domain.service.exceptions.RuleException;

@Service
public class CustomersService {

	@Autowired
	private CustomersRepository repository;
	
	public Customers insert(Customers client) {
		Customers customers = repository.findByEmail(client.getEmail());
		
		if(customers != null  && !customers.equals(client)) {
			throw new RuleException("Email já Cadastrado no Sistema...");
		}
		return repository.save(client);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}

