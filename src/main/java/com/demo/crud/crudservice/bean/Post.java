package com.demo.crud.crudservice.bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;

@Entity
public class Post {
	@javax.persistence.Id
	@GeneratedValue
	private Integer Id;
	private String description;
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	public Post(Integer id, String description, User user) {
		super();
		Id = id;
		this.description = description;
		this.user = user;
	}

	public Post() {
		super();
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
