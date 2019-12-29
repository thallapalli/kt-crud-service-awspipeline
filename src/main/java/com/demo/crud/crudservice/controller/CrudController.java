package com.demo.crud.crudservice.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.demo.crud.crudservice.bean.HelloworldBean;
import com.demo.crud.crudservice.model.Note;
import com.demo.crud.crudservice.repository.CrudRepository;

@RestController
@CrossOrigin(origins = "*")
public class CrudController {
	@Autowired
	CrudRepository crudRepository;
	@Autowired
	MessageSource messageSource;

	@GetMapping(value = "/greetme/{name}")
	public String greetme(@PathVariable String name) {
		return "Hello test mobile" + name;
	}
	@GetMapping(value = "/greetmei18n/{name}")
	public String greetmeini18N(@PathVariable String name,@RequestHeader(name="Accept-Language",required=false) Locale locale) {
		String country = locale.getCountry();
		System.out.println("country-----------"+country);
		
		return messageSource.getMessage("greetme.message", null, locale);
		
	}
	@GetMapping(value = "/helloworldbean/{name}")
	public HelloworldBean helloworldBean(@PathVariable String name) {
		return new HelloworldBean(name);
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
