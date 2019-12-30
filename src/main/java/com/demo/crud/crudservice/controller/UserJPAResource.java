package com.demo.crud.crudservice.controller;

import java.lang.reflect.Method;
import java.net.URI;
import java.util.List;
import java.util.Optional;

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
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.demo.crud.crudservice.bean.Post;
import com.demo.crud.crudservice.bean.User;
import com.demo.crud.crudservice.controller.exception.UserNotFoundException;
import com.demo.crud.crudservice.dao.UserDAOService;
import com.demo.crud.crudservice.repo.UserRepository;

@RestController
public class UserJPAResource {
	
	private UriComponents buildAndExpand;
	@Autowired
 private UserRepository userRepository;
	// retriveAllUser
	// retriveAllUser(int id);
	@GetMapping("/jpa/users")

	public List<User> retriveAllUser() {
		return userRepository.findAll();

	}

	@GetMapping("/jpa/users/{id}")

	public Resource<User> retriveUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id="+id);
		}
		else {
			//HATEOAS
			// "all-users" SERVER_PATH+"/users" 
			Resource<User> resource=new Resource<User>(user.get());
			ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retriveAllUser());
			resource.add(linkTo.withRel("all-users"));
			return resource;
		}
	}
	@DeleteMapping("/jpa/users/{id}")

	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
		
		
	}

	@PostMapping("/jpa/users")

	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User user1=userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user1.getId()).toUri();
		return ResponseEntity.created(location).build();
		

	}
	
	@GetMapping("/jpa/users/{id}/posts")

	public List<Post> retrieveAllPostsbyUserId(@PathVariable Integer id) {
		Optional<User> user = userRepository.findById(id);
		 if(!user.isPresent()) {
			 throw new UserNotFoundException("User Not found");
		 }
		 List<Post> posts = user.get().getPosts();
		return posts;

	}
}
