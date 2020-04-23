package com.talissonmelo.osworks.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.talissonmelo.osworks.domain.model.enums.StatusOrderService;

@Entity
public class OrderOfService {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Customers customers;
	private String description;
	private BigDecimal price;
	
	@Enumerated(EnumType.STRING)
	private StatusOrderService status;
	private LocalDateTime dateOpen;
	private LocalDateTime dateFinished;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Customers getCustomers() {
		return customers;
	}
	
	public void setCustomers(Customers customers) {
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
	
	public LocalDateTime getDateOpen() {
		return dateOpen;
	}
	
	public void setDateOpen(LocalDateTime dateOpen) {
		this.dateOpen = dateOpen;
	}
	
	public LocalDateTime getDateFinished() {
		return dateFinished;
	}
	
	public void setDateFinished(LocalDateTime dateFinished) {
		this.dateFinished = dateFinished;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderOfService other = (OrderOfService) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
