package com.example.bobbti.controller.dto;

import com.example.bobbti.entity.QuizResult;
import com.example.bobbti.entity.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultDto {

    private Long id;
    private String title;
    private String subtitle;
    private String detail;
    private String tip;
    private String perfectMatch;
    private String badMatch;
    private String questionResultImageName;

    public ResultDto(Result result){
        this.title = result.getTitle();
        this.subtitle = result.getSubtitle();
        this.detail = result.getDetail();
        this.tip = result.getTip();
        this.perfectMatch = result.getPerfectMatch();
        this.badMatch = result.getBadMatch();
        this.questionResultImageName = result.getImage();
    }
}
