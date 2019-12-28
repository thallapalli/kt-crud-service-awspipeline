package com.demo.crud.crudservice.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import com.demo.crud.crudservice.bean.User;
import com.demo.crud.crudservice.controller.exception.UserNotFoundException;
import com.demo.crud.crudservice.dao.UserDAOService;

@RestController
public class UserResource {
	@Autowired
	UserDAOService userDAOService;
	private UriComponents buildAndExpand;

	// retriveAllUser
	// retriveAllUser(int id);
	@GetMapping("/users")

	public List<User> retriveAllUser() {
		return userDAOService.findAll();

	}

	@GetMapping("/users/{id}")

	public User retriveUser(@PathVariable int id) {
		User user = userDAOService.findOne(id);
		if(user==null) {
			throw new UserNotFoundException("id="+id);
		}
		else {
			//HATEOAS
			// "all-users" SERVER_PATH+"/users" 
		
			return user;
		}
	}
	@DeleteMapping("/users/{id}")

	public void deleteUser(@PathVariable int id) {
		User user = userDAOService.deleteById(id);
		if(user==null) {
			throw new UserNotFoundException("id="+id);
		}
		
	}

	@PostMapping("/users")

	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User user1=userDAOService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(user1.getId()).toUri();
		return ResponseEntity.created(location).build();
		

	}
}
