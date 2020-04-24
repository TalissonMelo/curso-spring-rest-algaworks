package com.talissonmelo.osworks.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talissonmelo.osworks.domain.model.Comments;
import com.talissonmelo.osworks.domain.model.Customers;
import com.talissonmelo.osworks.domain.model.OrderOfService;
import com.talissonmelo.osworks.domain.model.enums.StatusOrderService;
import com.talissonmelo.osworks.domain.repository.CommentsRepository;
import com.talissonmelo.osworks.domain.repository.CustomersRepository;
import com.talissonmelo.osworks.domain.repository.OrderOfServiceRepository;
import com.talissonmelo.osworks.domain.service.exceptions.EntityNotFoundException;
import com.talissonmelo.osworks.domain.service.exceptions.RuleException;

@Service
public class OrderOfServiceService {
	
	@Autowired
	private OrderOfServiceRepository repository;
	
	@Autowired
	private CustomersRepository clientRepository;
	
	@Autowired
	private CommentsRepository commentsRepository;
	
	public OrderOfService insert(OrderOfService order) {
		
		Customers customers = clientRepository.findById(order.getCustomers().getId())
				.orElseThrow(() -> new RuleException("Cliente Não Encontrado. Id: " + order.getCustomers().getId()));
		
		order.setCustomers(customers);
		order.setStatus(StatusOrderService.OPEN);
		order.setDateOpen(OffsetDateTime.now());
		return repository.save(order);
	}
	
	
	public void finish(Long id) {
		OrderOfService order = find(id);
		order.finish();
		repository.save(order);
	}
	
	public Comments addComments(Long orderServiceId, String description) {
		
		Comments comment = new Comments();
		comment.setDescription(description);
		comment.setDateSend(OffsetDateTime.now());
		OrderOfService order = find(orderServiceId);
		comment.setOrder_of_service(order);
		
		return commentsRepository.save(comment);
	}

	private OrderOfService find(Long id) {
		return repository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Ordem de Serviço nao encontrada. Id: " + id));
	}
}
