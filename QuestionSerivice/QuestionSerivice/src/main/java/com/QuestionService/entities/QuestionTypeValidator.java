package com.QuestionService.entities;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD ,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = QuestionType.class)
public @interface QuestionTypeValidator {
  public String message() default "Invalid type of question it must include java,python & pyspa";

  Class<?>[] groups() default {};

  // ✅ REQUIRED
  Class<? extends Payload>[] payload() default {};
}
