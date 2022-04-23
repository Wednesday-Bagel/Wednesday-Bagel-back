package com.example.bobbti.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
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

    private String image;

}
