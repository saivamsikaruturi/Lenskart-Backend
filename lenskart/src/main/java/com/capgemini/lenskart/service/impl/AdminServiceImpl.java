package com.capgemini.lenskart.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lenskart.constants.LenskartConstants;
import com.capgemini.lenskart.exceptions.EntityAlreadyExistsException;
import com.capgemini.lenskart.exceptions.NotFoundException;
import com.capgemini.lenskart.models.AdminCredential;
import com.capgemini.lenskart.models.RegisterUser;
import com.capgemini.lenskart.models.dto.AdminDto;
import com.capgemini.lenskart.repository.AdminRepository;
import com.capgemini.lenskart.repository.UserRegistrationRepository;
import com.capgemini.lenskart.service.AdminService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
public class AdminServiceImpl implements AdminService {

	@Autowired
	private final AdminRepository adminRepository;

	@Override
	public AdminCredential registerAdmin(AdminCredential adminDto) {

		Optional<AdminCredential> optionalAdmin = adminRepository.findById(adminDto.getUserId());

		if (!optionalAdmin.isPresent()) {
			AdminCredential admin = new AdminCredential();
			admin.setUserId(adminDto.getUserId());
			admin.setFirstName(adminDto.getFirstName());
			admin.setLastName(adminDto.getLastName());
			admin.setUserName(adminDto.getUserName());
			admin.setPassword(adminDto.getPassword());

			return adminRepository.save(admin);
		} else {
			throw new EntityAlreadyExistsException(LenskartConstants.ADMIN_EXISTS);
		}
	}

	@Override
	public String verifyAdmin(AdminDto login) {

		Optional<AdminCredential> optionalAdmin = adminRepository.findByUserNameAndPassword(login.getUserName(),
				login.getPassword());
		if (optionalAdmin.isPresent()) {
			return "Admin Login successful";
		} else {
			throw new NotFoundException(LenskartConstants.ADMIN_NOT_FOUND);
		}
	}

}
