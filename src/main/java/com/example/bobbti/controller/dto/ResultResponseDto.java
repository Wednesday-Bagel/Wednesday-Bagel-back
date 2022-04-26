package com.example.bobbti.controller.dto;

import com.example.bobbti.entity.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultResponseDto {
    private Long id;
    private String teamName;
    private String teamCode;
    private List<TeamResultDto> resultDtos = new ArrayList<>();

    public ResultResponseDto(Long id, String teamName,String teamCode,Long memberId, String name, Result result){
        this.id = id;
        this.teamName = teamName;
        this.teamCode = teamCode;
        this.resultDtos.add(new TeamResultDto(memberId, name, result));
    }
}

