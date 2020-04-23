package com.talissonmelo.osworks.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talissonmelo.osworks.domain.model.OrderOfService;

public interface OrderOfServiceRepository extends JpaRepository<OrderOfService, Long> {

}
