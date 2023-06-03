package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.UserEntity;
import com.repository.UserRepository;

@CrossOrigin
@RequestMapping("/admin")
@RestController
public class UserController {
	
	@Autowired
	UserRepository userrepo;
	
	@GetMapping("/user")
	public List<UserEntity> getalluser()
	{
	  return userrepo.findAll();
	}
	
	@PostMapping("/adduser")
	public UserEntity adduser(@RequestBody UserEntity user)
	{
		return userrepo.save(user);
	}
	
	@DeleteMapping("/user/{id}")
	public UserEntity deleteuser(@PathVariable("id") Integer id)
	{
		UserEntity user= userrepo.findById(id).orElse(null);
		userrepo.deleteById(id);
		return user;
	}

	
}
