package com.example.bobbti.repository;

import com.example.bobbti.entity.question.QuestionResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionResultRepository extends JpaRepository<QuestionResult, Long> {
    Optional<QuestionResult> findByAnswer1AndAndAnswer2AndAndAnswer3AndAndAnswer4AndAndAnswer5AndAndAnswer6AndAndAnswer7AndAndAnswer8AndAndAnswer9AndAnswer10AndAnswer11AndAnswer12(
            Integer answer1, Integer answer2, Integer answer3, Integer answer4, Integer answer5, Integer answer6,
            Integer answer7, Integer answer8, Integer answer9, Integer answer10, Integer answer11, Integer answer12
    );
}
