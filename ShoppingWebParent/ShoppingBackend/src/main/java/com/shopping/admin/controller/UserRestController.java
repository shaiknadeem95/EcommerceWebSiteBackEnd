package com.shopping.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.admin.user.serviceImpl.UserServiceImpl;

@RestController
public class UserRestController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;

	@PostMapping(value="/users/check_email")
	public String checkEmailFunction(@Param("email") String email)
	{
		return userServiceImpl.checkEmailInDB(email)?"OK":"NOT_FOUND";
	}
}
