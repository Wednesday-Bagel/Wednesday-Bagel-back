package com.example.bobbti.entity.teamTest;


import javax.persistence.*;

@Entity
public class Team {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private String resultTitle;

    @Column(nullable = false)
    private String resultDescribe;

    /**
     * image
     */
    @Column(nullable = false)
    private String questionResultImageName;
    @Column(nullable = false)
    private String questionResultImagePath;
    @Column(nullable = false)
    private String questionResultOriginName;
}
