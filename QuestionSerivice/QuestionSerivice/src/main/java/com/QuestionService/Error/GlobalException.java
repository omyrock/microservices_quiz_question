package com.QuestionService.Error;


import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstaraintViolation(ConstraintViolationException constraintViolationException){
           List<String> errors= constraintViolationException.getConstraintViolations()
                    .stream().map(a->a.getMessage()).toList();
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Validation Field",errors));

    }
}
