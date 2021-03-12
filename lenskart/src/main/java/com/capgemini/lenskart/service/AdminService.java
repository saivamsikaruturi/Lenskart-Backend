package com.capgemini.lenskart.service;

import com.capgemini.lenskart.models.AdminCredential;
import com.capgemini.lenskart.models.dto.AdminDto;

public interface AdminService {
	
	AdminCredential registerAdmin(AdminCredential admin);

	String verifyAdmin(AdminDto login);

}
