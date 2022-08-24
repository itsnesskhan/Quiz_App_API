package com.quiz.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import com.quiz.Models.Name;
import com.quiz.Models.UserRole;

import antlr.collections.List;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
	
	private Integer id;

	private Name name;
	private String email;
	private String password;

}

