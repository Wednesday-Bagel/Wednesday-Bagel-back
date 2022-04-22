package com.example.bobbti.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class QuizResult {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "result_id")
    private Result result;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

}
