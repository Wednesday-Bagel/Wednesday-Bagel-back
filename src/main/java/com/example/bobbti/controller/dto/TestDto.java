package com.example.bobbti.controller.dto;

import com.example.bobbti.entity.test.Test;
import com.example.bobbti.entity.test.TestStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestDto {

    private Long id;
    private String title;
    private String content;
//    private TestStatus testStatus;

    public TestDto(Test test){
        this.id = test.getId();
        this.title = test.getTitle();
        this.content = test.getContent();
    }
}
