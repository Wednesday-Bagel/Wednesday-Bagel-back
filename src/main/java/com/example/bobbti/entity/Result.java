package com.example.bobbti.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Result {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private Long id;

    @Column()
    private String title;
    private String describe;
    private String image;

}
