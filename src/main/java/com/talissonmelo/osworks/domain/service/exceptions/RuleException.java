package com.talissonmelo.osworks.domain.service.exceptions;

public class RuleException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public RuleException(String msg) {
		super(msg);
	}
}
