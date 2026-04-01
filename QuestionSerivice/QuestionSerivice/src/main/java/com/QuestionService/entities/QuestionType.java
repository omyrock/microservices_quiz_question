package com.QuestionService.entities;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class QuestionType implements ConstraintValidator<QuestionTypeValidator,String> {

    @Override
    public boolean isValid(String questionType, ConstraintValidatorContext constraintValidatorContext) {
        List<String> listOfQuizId= Arrays.asList("java","python","pyspa");
        return listOfQuizId.stream().anyMatch(lan->questionType.contains(lan));
    }
}
