package com.example.bobbti.controller;

import com.example.bobbti.controller.dto.QuizDto;
import com.example.bobbti.controller.dto.UserRequestDto;
import com.example.bobbti.service.QuizService;
import com.example.bobbti.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("test")
public class ResultController {
    private final QuizService quizService;
    private final ResultService resultService;

    @GetMapping
    public ResponseEntity<Collection<QuizDto>> readAll(
            @RequestParam(value = "team", required = false) String teamCode
    ){
        return ResponseEntity.ok(this.quizService.readAll(teamCode));
    }
    @PostMapping
    public ResponseEntity<?> createRequest(
            @RequestBody UserRequestDto userRequestDto
    ){
        return ResponseEntity.ok(this.resultService.findResult(userRequestDto));
    }
}
