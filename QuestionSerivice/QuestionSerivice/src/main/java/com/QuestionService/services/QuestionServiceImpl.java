package com.QuestionService.services;

import com.QuestionService.entities.Question;
import com.QuestionService.repository.QuestionRepo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private QuestionRepo questionRepo;

    public QuestionServiceImpl(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    @Override
    public Question create(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public List<Question> get() {
        return questionRepo.findAll();
    }

    @Override
    @Cacheable(value = "questions",key="#id")
    public Question getOne(Long id) {
        return questionRepo.findById(id).orElseThrow(()->new RuntimeException("question not found"));
    }

    @Override
    public List<Question> getQuestionOfQuiz(Long quizId) {
        return questionRepo.findByQuizId(quizId);
    }
}
