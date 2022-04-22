package com.example.bobbti.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Team {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    private String name;
    private String code;

}
