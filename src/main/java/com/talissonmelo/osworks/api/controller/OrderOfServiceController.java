package com.talissonmelo.osworks.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.talissonmelo.osworks.domain.model.OrderOfService;
import com.talissonmelo.osworks.domain.service.OrderOfServiceService;

@RestController
@RequestMapping(value = "/orders")
public class OrderOfServiceController {
	
	@Autowired
	private OrderOfServiceService service;
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public OrderOfService insert(@Valid @RequestBody OrderOfService order) {
		return service.insert(order);
	}

}
