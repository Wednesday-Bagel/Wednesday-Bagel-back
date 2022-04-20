package com.example.bobbti.controller;

import com.example.bobbti.controller.dto.ResultDto;
import com.example.bobbti.controller.dto.UserInputDto;
import com.example.bobbti.service.ResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResultController {
    private static final Logger logger = LoggerFactory.getLogger(ResultController.class);
    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @PostMapping
    public ResponseEntity<?> createUserInput(
        @RequestBody UserInputDto userInputDto
    ){
        ResultDto resultDto = this.resultService.createUserInput(userInputDto);

        return ResponseEntity.ok(resultDto);
    }
}
