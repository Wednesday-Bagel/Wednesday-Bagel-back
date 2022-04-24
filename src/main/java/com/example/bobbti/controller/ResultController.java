package com.example.bobbti.controller;

import com.example.bobbti.controller.dto.UserRequestDto;
import com.example.bobbti.service.ResultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @PostMapping
    public ResponseEntity<?> createRequest(
            @RequestBody UserRequestDto userRequestDto
    ){
        return ResponseEntity.ok(this.resultService.findResult(userRequestDto));
    }
}
