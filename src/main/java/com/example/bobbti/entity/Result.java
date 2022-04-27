package com.example.bobbti.entity;

import com.example.bobbti.controller.dto.ResultDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private Long id;

    private String title;
    private String subtitle;
    private String detail;
    private String tip;
    private String perfectMatch;
    private String badMatch;

    @Column(columnDefinition = "TEXT")
    private String image;

    public Result(ResultDto resultDto){
        this.title = resultDto.getTitle();
        this.subtitle = resultDto.getSubtitle();
        this.detail = resultDto.getDetail();
        this.tip = resultDto.getTip();
        this.perfectMatch = resultDto.getPerfectMatch();
        this.badMatch = resultDto.getBadMatch();
        this.image = resultDto.getQuestionResultImageName();
    }
}
