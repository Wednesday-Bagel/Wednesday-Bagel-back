package com.example.bobbti.controller.dto;

import com.example.bobbti.entity.Quiz;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuizDto {
    private Long id;

    private String question;
    private String answerChoice1;
    private String answerChoice2;

    public QuizDto(Quiz quiz) {
        this.id = quiz.getId();
        this.question = quiz.getQuestion();
        this.answerChoice1 = quiz.getAnswerChoice1();
        this.answerChoice2 = quiz.getAnswerChoice2();
    }
}
