package com.demo.crud.crudservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.crud.crudservice.bean.Name;
import com.demo.crud.crudservice.bean.Person1;
import com.demo.crud.crudservice.bean.Person2;

@RestController
public class PersonVersionController {
	@GetMapping("v1/person")
 public Person1 person1() {
	 return new Person1("KT 1");
 }
	@GetMapping("v2/person")
 public Person2 person2() {
	 return new Person2(new Name("Karnakar","Thallapalli"));
 }
	@GetMapping(value="person/version",params="version=1")
	 public Person1 person1asparam() {
		 return new Person1("KT 1");
	 }
	@GetMapping(value="person/version",params="version=2")
	 public Person2 person2asparam() {
		 return new Person2(new Name("Karnakar","Thallapalli"));
	 }
}
