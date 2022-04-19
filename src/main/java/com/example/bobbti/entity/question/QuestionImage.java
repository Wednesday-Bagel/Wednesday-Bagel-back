package com.example.bobbti.entity.question;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class QuestionImage {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="questionImage_id")
    private Long id;

    @Column(nullable = false)
    private int exampleNumber;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String filePath;

    @Column(nullable = false)
    private String originName;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @Enumerated(EnumType.STRING)
    private QuestionImageStatus questionImageStatus;

}
