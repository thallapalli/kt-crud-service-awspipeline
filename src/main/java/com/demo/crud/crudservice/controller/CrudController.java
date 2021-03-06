package com.demo.crud.crudservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.demo.crud.crudservice.model.Note;
import com.demo.crud.crudservice.repository.CrudRepository;

@RestController
@CrossOrigin(origins = "*")
public class CrudController {
	@Autowired
	CrudRepository crudRepository;

	@GetMapping(value = "/greetme/{name}")
	public String greetme(@PathVariable String name) {
		return "Hello test mobile" + name;
	}

	@GetMapping(value = "/retrievenotes")
	public List<Note> retrivenotes() {
		return crudRepository.retrivenotes();
	}

	@PostMapping(value = "/createnote")
	public int createNote(@RequestBody Note note) {
		return crudRepository.createNote(note);
	}

	@PutMapping(value = "/updatenote")
	public int updateNote(@RequestBody Note note) {
		return crudRepository.updateNote(note);
	}
	@DeleteMapping(value="/deletenote/{id}")
	public void deleteNote(@PathVariable int id){
		crudRepository.deleteNote(id);
	}

	

}
