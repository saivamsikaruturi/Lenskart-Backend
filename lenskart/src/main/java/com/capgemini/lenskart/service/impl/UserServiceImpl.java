package com.capgemini.lenskart.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lenskart.constants.LenskartConstants;
import com.capgemini.lenskart.exceptions.EntityAlreadyExistsException;
import com.capgemini.lenskart.exceptions.NotFoundException;
import com.capgemini.lenskart.models.RegisterUser;
import com.capgemini.lenskart.models.dto.LoginDto;
import com.capgemini.lenskart.repository.UserRegistrationRepository;
import com.capgemini.lenskart.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
public class UserServiceImpl implements UserService {
	
	@Autowired
	private final UserRegistrationRepository userRepository;

	@Override
	public RegisterUser registerUser(RegisterUser userDto) {
		
		Optional<RegisterUser> optionalUser = userRepository.findByUserNameAndPassword(userDto.getUserName(),userDto.getPassword());
		
		if(!optionalUser.isPresent()) {
			RegisterUser user = new RegisterUser();
			user.setUserId(userDto.getUserId());
			user.setFirstName(userDto.getFirstName());
			user.setLastName(userDto.getLastName());
			user.setUserName(userDto.getUserName());
			user.setPassword(userDto.getPassword());
			
			return userRepository.save(user);
		}else {
			throw new EntityAlreadyExistsException(LenskartConstants.USER_ALREADY_EXISTS);
		}	
	}

	@Override
	public String verifyUser(LoginDto login) {
		
		Optional<RegisterUser> optionalUser = userRepository.findByUserNameAndPassword(login.getUserName(), login.getPassword());
		if(optionalUser.isPresent()) {
			return "Login successful";
		}else {
			throw new NotFoundException(LenskartConstants.USER_NOT_FOUND);
		}
	}

}
