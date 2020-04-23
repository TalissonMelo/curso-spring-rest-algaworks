package com.talissonmelo.osworks.model.dto;

import javax.validation.constraints.NotBlank;

public class CommentsInputDTO {
	
	@NotBlank
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
