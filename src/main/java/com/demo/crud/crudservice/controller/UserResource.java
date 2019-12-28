package com.demo.crud.crudservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.crud.crudservice.bean.User;
import com.demo.crud.crudservice.dao.UserDAOService;

@RestController
public class UserResource {
	@Autowired
	UserDAOService userDAOService;

	// retriveAllUser
	// retriveAllUser(int id);
	@GetMapping("/users")

	public List<User> retriveAllUser() {
		return userDAOService.findAll();

	}

	@GetMapping("/users/{id}")

	public User retriveUser(@PathVariable int id) {
		return userDAOService.findOne(id);

	}

	@PostMapping("/users")

	public User createUser(@RequestBody User user) {
		return userDAOService.save(user);

	}
}
