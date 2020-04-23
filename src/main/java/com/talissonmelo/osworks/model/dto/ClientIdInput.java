package com.talissonmelo.osworks.model.dto;

import com.sun.istack.NotNull;

public class ClientIdInput {

	@NotNull
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
