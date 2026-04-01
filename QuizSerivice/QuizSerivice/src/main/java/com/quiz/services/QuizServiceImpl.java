package com.quiz.services;

import com.quiz.entities.Quiz;
import com.quiz.repositoty.QuizRepo;
import com.sun.net.httpserver.Authenticator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService{

    private QuizRepo quizRepo;

    private QuestionClient questionClient;

    public QuizServiceImpl(QuizRepo quizRepo, QuestionClient questionClient) {
        this.quizRepo = quizRepo;
        this.questionClient = questionClient;
    }

    @Override
    public Quiz add(Quiz quiz) {
            return quizRepo.save(quiz);
    }

    @Override
    public List<Quiz> get() {

        List<Quiz> allQuiz = quizRepo.findAll();
        allQuiz.stream().map(q->{q.setQuestions(questionClient.getQuestionOfQuiz(q.getId()));
            return q;
        }).collect(Collectors.toList());
      return allQuiz;
    }

    @Override
    public Quiz getQuiz(Long id) {
        Quiz singleQuiz = quizRepo.findById(id).orElseThrow(() -> new RuntimeException("quiz not found"));
          singleQuiz.setQuestions(questionClient.getQuestionOfQuiz(singleQuiz.getId()));
        return  singleQuiz;
    }

    @Override
    public ResponseEntity<?> deleteQuiz(Long id) {
           quizRepo.deleteById(id);
           return ResponseEntity.ok("deleted successfully");
    }
}
