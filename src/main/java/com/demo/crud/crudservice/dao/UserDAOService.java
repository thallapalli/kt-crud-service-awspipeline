package com.demo.crud.crudservice.dao;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.crud.crudservice.bean.User;

@Component
public class UserDAOService {
private static List<User> listOfUsers=new ArrayList<User>();
private static int userCount=2;
static {
	listOfUsers.add(new User(1,"KT",new Date()));
	listOfUsers.add(new User(2,"KT2",new Date()));
}
public List<User> findAll(){
	return listOfUsers;
}
 public User save(User user) {
	 if(user.getId()==null) {
		 user.setId(++userCount);
	 }
	 listOfUsers.add(user);
	return user;
 }
 public User findOne(int id) {
	for(User user:listOfUsers) {
		if(user.getId()==id) {
			return user;
		}
	}
	return null;
 }
 
}
