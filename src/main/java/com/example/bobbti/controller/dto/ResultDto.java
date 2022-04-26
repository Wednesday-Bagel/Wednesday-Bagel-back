package com.example.bobbti.controller.dto;

import com.example.bobbti.entity.Result;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultDto {
    private Long id;
    private String name;
    private String title;
    private String subtitle;
    private String detail;
    private String tip;
    private String perfectMatch;
    private String badMatch;
    private String questionResultImageName;

    public ResultDto(Long id, String name, Result result) {
        this.id = id;
        this.name = name;
        this.title = result.getTitle();
        this.subtitle = result.getSubtitle();
        this.detail = result.getDetail();
        this.tip = result.getTip();
        this.perfectMatch = result.getPerfectMatch();
        this.badMatch = result.getBadMatch();
        this.questionResultImageName = result.getImage();
    }
}
