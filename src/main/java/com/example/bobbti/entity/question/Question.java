package com.example.bobbti.entity.question;


import com.example.bobbti.entity.test.Test;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Question {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long id;
    
    @Embedded
    private QuestionContent questionContents;

    @Embedded
    private QuestionExample questionExamples;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    private List<QuestionImage> images;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private Test test;

//    @Enumerated(EnumType.STRING)
//    private QuestionStatus questionStatus;
}
