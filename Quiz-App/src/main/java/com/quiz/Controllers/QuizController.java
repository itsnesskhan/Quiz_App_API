package com.quiz.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.Models.Quiz;
import com.quiz.Services.QuizService;
import com.quiz.helper.ApiResponse;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	@GetMapping("/{quizId}")
	public ResponseEntity<Quiz> getQuiz(@PathVariable Integer quizId) {
		Quiz quiz = quizService.getQuiz(quizId);
		return new ResponseEntity<Quiz>(quiz, HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Quiz>> getQuizes() {
		List<Quiz> allQuizs = quizService.getAllQuizs();
		return new ResponseEntity<List<Quiz>>(allQuizs, HttpStatus.OK);
	}
	

	@PostMapping("")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quizDto) {
		Quiz quiz = quizService.addQuiz(quizDto);
		return new ResponseEntity<Quiz>(quiz, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{quizId}")
	public ResponseEntity<?> deleteQuiz(@PathVariable Integer quizId) {
		quizService.deleteQuiz(quizId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Quiz Deleted Successfully!", true), HttpStatus.OK);
	}
	
	@PutMapping("/{quizId}")
	public ResponseEntity<Quiz> UpdateQuiz(@RequestBody Quiz quizDto, @PathVariable Integer quizId) {
		Quiz quiz = quizService.updateQuiz(quizDto, quizId);
		return new ResponseEntity<Quiz>(quiz, HttpStatus.OK);
	}

}
