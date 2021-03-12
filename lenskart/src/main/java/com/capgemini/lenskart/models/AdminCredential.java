package com.capgemini.lenskart.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.capgemini.lenskart.models.dto.LoginDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AdminCredential implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
    @Column(name = "USER_ID")
	private Long userId;
	
	@Getter
	@Setter
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Getter
	@Setter
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Getter
	@Setter
	@Column(name = "U_NAME")
	private String userName;
	
	@Getter
	@Setter
	@Column(name = "U_PASSWORD")
	private String password;
	
	public AdminCredential(String firstName, String lastName, String userName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}

}
