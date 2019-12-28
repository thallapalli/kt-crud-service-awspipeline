package com.demo.crud.crudservice.bean;

public class HelloworldBean {

	private String message;

	public HelloworldBean(String name) {
		// TODO Auto-generated constructor stub
		this.message=name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Hello Worlbena",  message);
	}

}
