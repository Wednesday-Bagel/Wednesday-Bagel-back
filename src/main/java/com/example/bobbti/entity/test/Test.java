package com.example.bobbti.entity.test;


import com.example.bobbti.entity.question.Question;
import com.example.bobbti.entity.question.QuestionResult;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name =  "test_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @OneToOne(optional = false, fetch = FetchType.LAZY, mappedBy = "test", cascade = CascadeType.ALL)
    private Question question;

    @OneToMany(mappedBy = "test_id", cascade = CascadeType.ALL)
    private List<QuestionResult> questionResult = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private TestStatus testStatus;

}
