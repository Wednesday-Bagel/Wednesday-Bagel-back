package com.example.bobbti.service;

import com.example.bobbti.controller.dto.QuizDto;
import com.example.bobbti.entity.Team;
import com.example.bobbti.repository.QuizRepository;
import com.example.bobbti.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;
    private final TeamRepository teamRepository;

    public List<QuizDto> readAll(String teamCode){
        if(teamCode != null && teamCode != ""){
            Team team = this.teamRepository.findByCode(teamCode).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        }
        List<QuizDto> quizDtoList = new ArrayList<>();
        quizRepository.findAll().forEach(quiz -> quizDtoList.add(new QuizDto(quiz)));

        return quizDtoList;
    }
}
