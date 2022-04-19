package com.example.bobbti.entity;

import javax.persistence.*;

@Entity
public class QuestionResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
