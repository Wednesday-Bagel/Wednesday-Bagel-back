package com.example.bobbti.entity.question;

import com.example.bobbti.entity.test.Test;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class QuestionResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private Test test_id;

    @Column(nullable = false)
    private String resultTitle;
    @Column(nullable = false)
    private String resultDescribe;

    private Integer answer1;
    private Integer answer2;
    private Integer answer3;
    private Integer answer4;
    private Integer answer5;
    private Integer answer6;
    private Integer answer7;
    private Integer answer8;
    private Integer answer9;
    private Integer answer10;
    private Integer answer11;
    private Integer answer12;

    private String perfectMatch;
    private String badMatch;
    /**
     * image
     */
    private String questionResultImageName;
    private String questionResultImagePath;
    private String questionResultImageOriginName;
}
