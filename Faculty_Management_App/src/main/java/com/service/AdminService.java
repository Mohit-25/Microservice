package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vo.UserVo;

@Service
public class AdminService {
	
	@Autowired
	RestTemplate resttemp;
	
	public List<UserVo> getAllUsers()
	{
		ResponseEntity<List<UserVo>> response =resttemp.exchange("http://ADMIN-SERVICE/"
				+ "admin/user", HttpMethod.GET, null, new  ParameterizedTypeReference<List<UserVo>>() {
		});
		List<UserVo> list=response.getBody();
		return list;
	}

	public UserVo adduser(UserVo user) {
		RestTemplate restTemplate=new RestTemplate();
		ResponseEntity<UserVo> response =restTemplate.exchange("ADMIN-SERVICE/adduser", HttpMethod.POST, null, new  ParameterizedTypeReference<UserVo>() {
		});
		UserVo list=response.getBody();
		return list;
	}
	
	

}
