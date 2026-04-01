package com.QuestionService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionId;
    @QuestionTypeValidator
    private String question;
    @NotNull(message = "question can't be null")
    private Long quizId;
}
