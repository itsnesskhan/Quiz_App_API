package com.quiz;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.quiz.Repository.OptionsRepository;

@SpringBootApplication
public class QuizAppApplication implements CommandLineRunner{
	
	@Autowired
	private OptionsRepository optionsRepository;

	public static void main(String[] args)  {
		SpringApplication.run(QuizAppApplication.class, args);

	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
//		Question question = new Question();
//		question.setQuestion_id(95);
//		List<Options> list = optionsRepository.findByQuestion(question);
//		System.out.println(list);
			
//		List<Options> list = optionsRepository.findByQuestionId(90);
//		System.out.println(list);
		
//		List<Options> optionsByQuestionId = optionService.getOptionsByQuestionId(95);
//		System.out.println(optionsByQuestionId);
		
	}

}
