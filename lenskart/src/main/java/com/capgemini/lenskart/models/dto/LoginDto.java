package com.capgemini.lenskart.models.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class LoginDto implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@JsonProperty(value = "userName")
	private String userName;
	
	@Getter
	@Setter
	@JsonProperty(value = "password")
	private String password;


}
