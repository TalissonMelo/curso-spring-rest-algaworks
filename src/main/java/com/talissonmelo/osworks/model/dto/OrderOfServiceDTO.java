package com.talissonmelo.osworks.model.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.talissonmelo.osworks.domain.model.enums.StatusOrderService;

public class OrderOfServiceDTO {

	private Long id;
	private CustomersSummaryDTO customers;
	private String description;
	private BigDecimal price;
	private StatusOrderService status;
	private OffsetDateTime dateOpen;
	private OffsetDateTime dateFinished;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomersSummaryDTO getCustomers() {
		return customers;
	}

	public void setCustomers(CustomersSummaryDTO customers) {
		this.customers = customers;
	}

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

	public StatusOrderService getStatus() {
		return status;
	}

	public void setStatus(StatusOrderService status) {
		this.status = status;
	}

	public OffsetDateTime getDateOpen() {
		return dateOpen;
	}

	public void setDateOpen(OffsetDateTime dateOpen) {
		this.dateOpen = dateOpen;
	}

	public OffsetDateTime getDateFinished() {
		return dateFinished;
	}

	public void setDateFinished(OffsetDateTime dateFinished) {
		this.dateFinished = dateFinished;
	}
}
