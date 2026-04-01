package com.quiz.controller;

import com.quiz.entities.Quiz;
import com.quiz.services.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }
    @PostMapping
    public Quiz create(@RequestBody Quiz quiz){
        return quizService.add(quiz);
    }

    @GetMapping("/getAll")
    public List<Quiz> getAll(){
        return quizService.get();
    }
    @GetMapping("/{id}")
    public Quiz getOne(@PathVariable Long id){
       return quizService.getQuiz(id);
    }

    @DeleteMapping("/remove/{id}")
    public void removeQuiz(@PathVariable Long id){
       quizService.deleteQuiz(id);
    }
}
