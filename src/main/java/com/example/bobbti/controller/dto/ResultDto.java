package com.example.bobbti.controller.dto;

import com.example.bobbti.entity.question.Question;
import com.example.bobbti.entity.question.QuestionResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultDto {

    private Long id;
    private Long test_id;
    private String resultTitle;
    private String resultDescribe;
    private String perfectMatch;
    private String badMatch;
    private String questionResultImageName;
    private String questionResultImagePath;
    private String questionResultImageOriginName;

    public ResultDto(QuestionResult questionResult){
        this.id = questionResult.getId();
        this.test_id = 0L;
        this.resultTitle = questionResult.getResultTitle();
        this.resultDescribe = questionResult.getResultDescribe();
        this.perfectMatch = questionResult.getPerfectMatch();
        this.badMatch = questionResult.getBadMatch();
        this.questionResultImageName = questionResult.getQuestionResultImageName();
        this.questionResultImagePath = questionResult.getQuestionResultImagePath();
        this.questionResultImageOriginName = questionResult.getQuestionResultImageOriginName();
    }

}
