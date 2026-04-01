package com.quiz.services;

import com.quiz.entities.Quiz;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizService {
    Quiz add(Quiz quiz);
    List<Quiz> get();
    Quiz getQuiz(Long id);
     ResponseEntity<?> deleteQuiz(Long id);
}
