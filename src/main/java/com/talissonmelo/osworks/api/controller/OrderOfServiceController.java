package com.talissonmelo.osworks.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
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
import com.talissonmelo.osworks.model.dto.OrderOfServiceDTO;
import com.talissonmelo.osworks.model.dto.OrderOfServiceInputDTO;

@RestController
@RequestMapping(value = "/orders")
public class OrderOfServiceController {

	@Autowired
	private OrderOfServiceService service;

	@Autowired
	private OrderOfServiceRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public OrderOfServiceDTO insert(@Valid @RequestBody OrderOfServiceInputDTO dto) {
		OrderOfService order = toEntity(dto);
		return fromDTO(service.insert(order));
	}

	@GetMapping
	public List<OrderOfServiceDTO> findAll() {
		return toCollectionFromDTO(repository.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<OrderOfServiceDTO> findById(@PathVariable Long id) {
		Optional<OrderOfService> order = repository.findById(id);

		if (order.isPresent()) {
			OrderOfServiceDTO dto = fromDTO(order.get());
			return ResponseEntity.ok().body(dto);
		}
		return ResponseEntity.notFound().build();
	}

	private OrderOfServiceDTO fromDTO(OrderOfService order) {
		return modelMapper.map(order, OrderOfServiceDTO.class);
	}

	private List<OrderOfServiceDTO> toCollectionFromDTO(List<OrderOfService> orders) {
		return orders.stream().map(order -> fromDTO(order)).collect(Collectors.toList());
	}

	private OrderOfService toEntity(OrderOfServiceInputDTO dto) {
		return modelMapper.map(dto, OrderOfService.class);
	}
}
