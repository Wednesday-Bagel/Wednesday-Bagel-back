package com.example.bobbti.controller.dto;

import com.example.bobbti.entity.question.QuestionResult;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionResultDto {
    private Long id;
    private Long test_id;
    private String resultTitle;
    private String resultDescribe;

    private Integer answer1;
    private Integer answer2;
    private Integer answer3;
    private Integer answer4;
    private Integer answer5;
    private Integer answer6;
    private Integer answer7;
    private Integer answer8;
    private Integer answer9;
    private Integer answer10;
    private Integer answer11;
    private Integer answer12;

    private String perfectMatch;
    private String badMatch;

    private String questionResultImageName;
    private String questionResultImagePath;
    private String questionResultImageOriginName;


    public QuestionResultDto(QuestionResult questionResult){
        this.id = questionResult.getId();
        this.test_id = 0L;
        this.resultTitle = questionResult.getResultTitle();
        this.resultDescribe = questionResult.getResultDescribe();
        this.answer1 = questionResult.getAnswer1();
        this.answer2 = questionResult.getAnswer2();
        this.answer3 = questionResult.getAnswer3();
        this.answer4 = questionResult.getAnswer4();
        this.answer5 = questionResult.getAnswer5();
        this.answer6 = questionResult.getAnswer6();
        this.answer7 = questionResult.getAnswer7();
        this.answer8 = questionResult.getAnswer8();
        this.answer9 = questionResult.getAnswer9();
        this.answer10 = questionResult.getAnswer10();
        this.answer11 = questionResult.getAnswer11();
        this.answer12 = questionResult.getAnswer12();
        this.perfectMatch = questionResult.getPerfectMatch();
        this.badMatch = questionResult.getBadMatch();
        this.questionResultImageName = questionResult.getQuestionResultImageName();
        this.questionResultImagePath = questionResult.getQuestionResultImagePath();
        this.questionResultImageOriginName = questionResult.getQuestionResultImageOriginName();
    }
}
