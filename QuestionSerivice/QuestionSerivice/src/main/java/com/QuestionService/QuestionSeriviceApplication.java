package com.QuestionService;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@EnableCaching
@SpringBootApplication
public class QuestionSeriviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionSeriviceApplication.class, args);

	}

}
