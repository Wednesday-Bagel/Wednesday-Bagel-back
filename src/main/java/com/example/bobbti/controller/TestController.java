package com.example.bobbti.controller;

import com.example.bobbti.controller.dto.TestDto;
import com.example.bobbti.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(ResultController.class);
    private final TestService testService;

    public TestController(
            @Autowired TestService testService
    ) {
        this.testService = testService;
    }
    @GetMapping
    public ResponseEntity<Collection<TestDto>> readAll(){
        return ResponseEntity.ok(this.testService.readAll());
    }


}
