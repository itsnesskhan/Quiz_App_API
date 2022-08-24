package com.quiz.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.Exceptions.ResourceNotFoundException;
import com.quiz.Models.Question;
import com.quiz.Models.Quiz;
import com.quiz.Repository.QuizRepository;

@Service
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizRepository quizRepository;

	@Override
	public Quiz addQuiz(Quiz quiz) {
		return this.quizRepository.save(quiz);
	}

	@Override
	public Quiz getQuiz(Integer quizId) {
		Quiz quiz = this.quizRepository.findById(quizId).orElseThrow(
				()->new ResourceNotFoundException("Quiz", "id", quizId));
		return quiz ;
	}

	@Override
	public Quiz updateQuiz(Quiz quizDto, Integer quizId) {
		Quiz quiz = this.quizRepository.findById(quizId).orElseThrow(
				()->new ResourceNotFoundException("Quiz", "id", quizId));
		quiz.setCategory(quizDto.getCategory());
		quiz.setTitle(quizDto.getTitle());
		quiz.setNumOfQuestion(quizDto.getNumOfQuestion());
		quiz.setQuestions(quizDto.getQuestions());
		quiz.setMaxMarks(quizDto.getMaxMarks());
		Quiz save = this.quizRepository.save(quiz);
		return save;
	}

	@Override
	public void deleteQuiz(Integer quizId) {
		Quiz quiz = this.quizRepository.findById(quizId).orElseThrow(
				()->new ResourceNotFoundException("Quiz", "id", quizId));
		quizRepository.delete(quiz);

	}

	@Override
	public List<Quiz> getAllQuizs() {
		return quizRepository.findAll();
	}

}
