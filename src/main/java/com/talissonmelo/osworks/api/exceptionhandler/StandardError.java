package com.talissonmelo.osworks.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class StandardError {

	private Integer status;
	private OffsetDateTime timestamp;
	private String msg;
	private List<FieldName> errors = new ArrayList<FieldName>();

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public OffsetDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(OffsetDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<FieldName> getErrors() {
		return errors;
	}

	public void setErrors(List<FieldName> errors) {
		this.errors = errors;
	}
}
