package com.quiz.Services;


import java.util.List;
import java.util.Set;

import com.quiz.Models.User;
import com.quiz.Models.UserRole;
import com.quiz.dtos.UserDto;

public interface StudentServices {

	User createStudent(UserDto student);
	
	User updateStudent (UserDto student, Integer studentid);
	
	void deleteStudent(Integer studentid);
	
	List<UserDto> getAllStudents();
	
	User getStudentById(Integer studentid);
	
	
}
