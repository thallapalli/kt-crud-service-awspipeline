package com.demo.crud.crudservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.crud.crudservice.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
