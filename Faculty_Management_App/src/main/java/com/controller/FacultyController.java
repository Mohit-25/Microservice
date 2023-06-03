package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.AdminService;
import com.vo.UserVo;

@RequestMapping("/faculty")
@RestController
public class FacultyController {

	@Autowired
	AdminService adminservice;
	
	@GetMapping("/user")
	public ResponseEntity<List<UserVo>> getAllUsers()
	{
		
		List<UserVo> admin=adminservice.getAllUsers();
		return ResponseEntity.ok(admin);
	}
	
	@PostMapping("/adduser")
	public ResponseEntity<UserVo> addUser(@RequestBody UserVo user)
	{
		UserVo User= adminservice.adduser(user);
		return ResponseEntity.ok(User);
	}
}
