package com.example.bobbti.repository;

import com.example.bobbti.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Optional<Team> findByCode(String code);
    Boolean existsByCode(String code);
}
