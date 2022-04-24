package com.example.bobbti.service;

import com.example.bobbti.controller.dto.QuizDto;
import com.example.bobbti.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;

    public List<QuizDto> readAll(){
        List<QuizDto> quizDtoList = new ArrayList<>();
        quizRepository.findAll().forEach(quiz -> quizDtoList.add(new QuizDto(quiz)));

        return quizDtoList;
    }
}
