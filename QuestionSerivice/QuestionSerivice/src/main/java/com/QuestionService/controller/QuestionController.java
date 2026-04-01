package com.QuestionService.controller;

import com.QuestionService.entities.Question;
import com.QuestionService.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @PostMapping
    public Question create(@RequestBody Question question){
       return questionService.create(question);
    }
    @GetMapping("/getAll")
    public List<Question> getAll(){
        return questionService.get();
    }
    @GetMapping("/{questionId}")
    public Question getQuestion(@PathVariable Long questionId){
        return questionService.getOne(questionId);
    }

    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionOfQuiz(@PathVariable Long quizId){
        return questionService.getQuestionOfQuiz(quizId);
    }
}
