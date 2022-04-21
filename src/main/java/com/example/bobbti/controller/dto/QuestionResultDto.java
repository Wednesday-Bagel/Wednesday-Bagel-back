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

}
