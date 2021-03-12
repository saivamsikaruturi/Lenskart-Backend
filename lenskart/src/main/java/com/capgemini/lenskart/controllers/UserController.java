package com.capgemini.lenskart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.lenskart.models.RegisterUser;
import com.capgemini.lenskart.models.dto.LoginDto;
import com.capgemini.lenskart.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping(value = "/registerUser")
	public ResponseEntity<RegisterUser> registerUser(@RequestBody RegisterUser user){
		return new ResponseEntity<>(userService.registerUser(user), HttpStatus.OK);
	}
	
	@PostMapping(value = "/verifyUser")
	public ResponseEntity<String> verifyUser(@RequestBody LoginDto login){
		return new ResponseEntity<>(userService.verifyUser(login), HttpStatus.OK);
	}
	
	
}
