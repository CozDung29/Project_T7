package com.managepage.api;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.managepage.dto.reponse.UserReponseDTO;
import com.managepage.service.interfac.UserService;


@RestController
public class UserAPI {
	
	@Autowired 
	private UserService userService;
	
	@GetMapping(value="/api/users")
	public Object getUserById(@RequestParam(name = "id", required = false) Long id) {
		UserReponseDTO userReponseDTO = userService.findById(id);
		return userReponseDTO;
	}
}
