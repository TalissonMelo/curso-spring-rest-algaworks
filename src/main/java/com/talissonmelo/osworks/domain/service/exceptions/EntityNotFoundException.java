package com.talissonmelo.osworks.domain.service.exceptions;

public class EntityNotFoundException extends RuleException {
	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(String msg) {
		super(msg);
	}

}
