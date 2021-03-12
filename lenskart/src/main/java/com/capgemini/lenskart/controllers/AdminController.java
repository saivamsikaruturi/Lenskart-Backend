package com.capgemini.lenskart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.lenskart.models.AdminCredential;
import com.capgemini.lenskart.models.dto.AdminDto;
import com.capgemini.lenskart.service.AdminService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping(value = "/registerAdmin")
	public ResponseEntity<AdminCredential> registerAdmin(@RequestBody AdminCredential admin){
		return new ResponseEntity<>(adminService.registerAdmin(admin), HttpStatus.OK);
	}
	
	@PostMapping(value = "/verifyAdmin")
	public ResponseEntity<String> verifyAdmin(@RequestBody AdminDto login){
		return new ResponseEntity<>(adminService.verifyAdmin(login), HttpStatus.OK);
	}

}
