package com.quiz.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.quiz.Exceptions.ResourceNotFoundException;
import com.quiz.Exceptions.UserAlreadyExistException;
import com.quiz.helper.ApiResponse;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException exception){
		ApiResponse apiResponse = new ApiResponse(exception.getMessage(), false);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<ApiResponse> userAlreadyExistExceptionHandler(UserAlreadyExistException exception){
		ApiResponse apiResponse = new ApiResponse(exception.getMessage(), false);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(value = {Exception.class, IllegalArgumentException.class, ExpiredJwtException.class, MalformedJwtException.class})
	public ResponseEntity<ApiResponse> globalExceptionHandler(Exception exception){
		ApiResponse apiResponse = new ApiResponse(exception.getMessage(), false);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
	}
}
