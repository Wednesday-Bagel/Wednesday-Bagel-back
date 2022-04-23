package com.example.bobbti.repository;

import com.example.bobbti.entity.QuizResult;
import com.example.bobbti.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizResultRepository extends JpaRepository<QuizResult, Long> {
    List<QuizResult> findAllByTeam(Team team);
}
