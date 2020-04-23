package com.talissonmelo.osworks.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talissonmelo.osworks.domain.model.Customers;
import com.talissonmelo.osworks.domain.model.OrderOfService;
import com.talissonmelo.osworks.domain.model.enums.StatusOrderService;
import com.talissonmelo.osworks.domain.repository.CustomersRepository;
import com.talissonmelo.osworks.domain.repository.OrderOfServiceRepository;
import com.talissonmelo.osworks.domain.service.exceptions.RuleException;

@Service
public class OrderOfServiceService {
	
	@Autowired
	private OrderOfServiceRepository repository;
	
	@Autowired
	private CustomersRepository clientRepository;
	
	public OrderOfService insert(OrderOfService order) {
		
		Customers customers = clientRepository.findById(order.getCustomers().getId())
				.orElseThrow(() -> new RuleException("Cliente Não Encontrado. Id: " + order.getCustomers().getId()));
		
		order.setCustomers(customers);
		order.setStatus(StatusOrderService.OPEN);
		order.setDateOpen(OffsetDateTime.now());
		return repository.save(order);
	}

}
