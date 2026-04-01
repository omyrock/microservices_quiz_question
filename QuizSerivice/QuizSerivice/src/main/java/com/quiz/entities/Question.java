package com.quiz.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {

//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionId;
    private String question;
    private Long quizId;
}
