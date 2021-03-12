package com.capgemini.lenskart.service;

import com.capgemini.lenskart.models.RegisterUser;
import com.capgemini.lenskart.models.dto.LoginDto;

public interface UserService {

	RegisterUser registerUser(RegisterUser user);

	String verifyUser(LoginDto login);

}
