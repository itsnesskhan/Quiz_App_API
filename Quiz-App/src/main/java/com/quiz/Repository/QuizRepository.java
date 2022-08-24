package com.quiz.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.Models.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
	Optional<Quiz> findByTitle(String title);

}
