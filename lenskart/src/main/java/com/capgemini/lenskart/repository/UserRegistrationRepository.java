package com.capgemini.lenskart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lenskart.models.RegisterUser;

@Repository
public interface UserRegistrationRepository extends JpaRepository<RegisterUser, Long>{
	
	//custom method
	public Optional<RegisterUser> findByUserNameAndPassword(String userName, String password);

}
