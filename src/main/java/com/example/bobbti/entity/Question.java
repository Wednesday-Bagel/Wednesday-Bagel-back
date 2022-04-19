package com.example.bobbti.entity;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Question {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private QuestionContent questionContent;

}
