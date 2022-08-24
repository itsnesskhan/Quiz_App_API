package com.quiz.Controllers;

import java.net.URI;
import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.quiz.Models.User;
import com.quiz.Models.UserRole;
import com.quiz.Repository.StudentRepository;
import com.quiz.Repository.UserRolesRepository;
import com.quiz.Services.StudentServices;
import com.quiz.dtos.UserDto;
import com.quiz.helper.ApiResponse;

@Controller
@RequestMapping("/student")
@CrossOrigin(origins = "*")
public class StudentController {

	@Autowired
	private StudentServices studentServices;
	
	@Autowired
	private StudentRepository studentRepository;
	

	@GetMapping("/{stuId}")
	public ResponseEntity<User> getStudent(@PathVariable("stuId") Integer stuId) {
		User user = this.studentServices.getStudentById(stuId);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<User> registerUser(@RequestBody UserDto userDto) {
		User studentDto = this.studentServices.createStudent(userDto);
		
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user").toUriString());
		
		return ResponseEntity.created(uri).body(studentDto);
	}

	@GetMapping("")
	public ResponseEntity<List<UserDto>> getStudents() {
		List<UserDto> students = this.studentServices.getAllStudents();
		return new ResponseEntity<List<UserDto>>(students, HttpStatus.OK);
	}

	@PutMapping("/{stuId}")
	public ResponseEntity<User> updateStudent(@RequestBody UserDto user, @PathVariable("stuId") Integer stuId) {
		User updateStudent = this.studentServices.updateStudent(user, stuId);
		return new ResponseEntity<User>(updateStudent, HttpStatus.OK);
	}
	
	@DeleteMapping("/{stuId}")
	public ResponseEntity<?> deleteStudent(@PathVariable("stuId") Integer stuId) {
		this.studentServices.deleteStudent(stuId);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/current-user")
	public ResponseEntity<User> getCurrentUser(Principal principal){
		User user = studentRepository.findByEmail(principal.getName());
		return ResponseEntity.ok(user) ;
	}
	
	

}
