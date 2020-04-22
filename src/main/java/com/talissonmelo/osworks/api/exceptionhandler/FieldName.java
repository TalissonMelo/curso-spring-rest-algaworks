package com.talissonmelo.osworks.api.exceptionhandler;

public class FieldName {
	
	private String name;
	private String msg;

	public FieldName() {
		super();
	}

	public FieldName(String name, String msg) {
		super();
		this.name = name;
		this.msg = msg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
