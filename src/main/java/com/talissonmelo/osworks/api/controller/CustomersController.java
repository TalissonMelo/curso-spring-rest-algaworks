package com.talissonmelo.osworks.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talissonmelo.osworks.domain.model.Customers;

@RestController
@RequestMapping(value = "/customers")
public class CustomersController {

	@GetMapping
	public List<Customers> findAll() {
		Customers cl = new Customers();
		cl.setId(1l);
		cl.setName("Talisson Melo");
		cl.setEmail("talisson.cursos@gmail.com");
		cl.setPhone("1234-1234");
		
		Customers cl2 = new Customers();
		cl2.setId(2l);
		cl2.setName("Maria José");
		cl2.setEmail("maria.cursos@gmail.com");
		cl2.setPhone("1234-1234");
		
		return Arrays.asList(cl, cl2);
	}

}
