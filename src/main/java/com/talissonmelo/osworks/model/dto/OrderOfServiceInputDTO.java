package com.talissonmelo.osworks.model.dto;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

public class OrderOfServiceInputDTO {
	
	@NotBlank
	private String description;
	
	@NotNull
	private BigDecimal price;
	
	@NotNull
	@Valid
	private ClientIdInput customers;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public ClientIdInput getCustomers() {
		return customers;
	}

	public void setCustomers(ClientIdInput customers) {
		this.customers = customers;
	}
}
