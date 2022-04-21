package com.example.bobbti.service;

import com.example.bobbti.controller.dto.TestDto;
import com.example.bobbti.repository.TestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {
    private static final Logger logger = LoggerFactory.getLogger(TestService.class);
    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public List<TestDto> readAll(){
        List<TestDto> testDtoList = new ArrayList<>();
        testRepository.findAll().forEach(test -> testDtoList.add(new TestDto(test)));

        return testDtoList;
    }
}
