package com.talissonmelo.osworks.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.sun.istack.NotNull;
import com.talissonmelo.osworks.domain.model.enums.StatusOrderService;
import com.talissonmelo.osworks.domain.model.validations.ValidationGroups;

@Entity
@Table(name = "order_of_service")
public class OrderOfService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Valid
	@NotNull
	@ConvertGroup(from = Default.class, to = ValidationGroups.CustomersId.class)
	@ManyToOne
	@JoinColumn(name = "customers_id")
	private Customers customers;
	
	@NotBlank
	private String description;
	
	@NotNull
	private BigDecimal price;
	
	@JsonProperty(access = Access.READ_ONLY)
	@Enumerated(EnumType.STRING)
	private StatusOrderService status;
	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime dateOpen;
	
	@JsonProperty(access = Access.READ_ONLY)
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