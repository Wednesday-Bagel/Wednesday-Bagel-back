package com.example.bobbti.repository;

import com.example.bobbti.entity.test.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
