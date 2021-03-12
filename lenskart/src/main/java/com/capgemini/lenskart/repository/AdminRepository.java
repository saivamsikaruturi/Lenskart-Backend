package com.capgemini.lenskart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lenskart.models.AdminCredential;

@Repository
public interface AdminRepository extends JpaRepository<AdminCredential, Long>{
	
	//custom method
	public Optional<AdminCredential> findByUserNameAndPassword(String userName, String password);


}
