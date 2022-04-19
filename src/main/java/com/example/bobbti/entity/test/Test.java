package com.example.bobbti.entity.test;


import com.example.bobbti.entity.question.Question;
import lombok.Getter;

import javax.persistence.*;

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

    @Enumerated(EnumType.STRING)
    private TestStatus testStatus;

}
