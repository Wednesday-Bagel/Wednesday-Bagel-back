package com.example.bobbti.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuizResultDto {
    private Long id;
    private String name;
    private Long result_id;
    private Long team_id;


}
