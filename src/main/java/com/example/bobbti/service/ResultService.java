package com.example.bobbti.service;

import com.example.bobbti.controller.dto.ResultResponseDto;
import com.example.bobbti.controller.dto.UserRequestDto;
import com.example.bobbti.entity.QuizResult;
import com.example.bobbti.entity.Result;
import com.example.bobbti.entity.Team;
import com.example.bobbti.repository.QuizResultRepository;
import com.example.bobbti.repository.ResultRepository;
import com.example.bobbti.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResultService {
    private final ResultRepository resultRepository;
    private final TeamRepository teamRepository;
    private final QuizResultRepository quizResultRepository;

    public ResultResponseDto findResult(UserRequestDto userRequestDto) {

        String mbti = findMBTI(userRequestDto.getAnswers());
        Long resultId = findResultId(mbti);

        Result result = this.resultRepository.findById(resultId+1)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        QuizResult QR = new QuizResult();
        QR.setName(userRequestDto.getName());
        QR.setResult(result);
        Optional<Team> teamOptional = this.teamRepository.findByCode(userRequestDto.getTeamCode());

        String teamName = "";
        if(teamOptional.isEmpty()){
            QR.setTeam(null);
        }else{
            QR.setTeam(teamOptional.get());
            teamName = teamOptional.get().getName();
        }

        quizResultRepository.save(QR);
        // id 
        Long id = QR.getId();
        return new ResultResponseDto(null, teamName, userRequestDto.getTeamCode(), id, userRequestDto.getName(), result);
    }

    public String findMBTI(List<Integer> answers){
        int[] category = {1, 8, 11, 2, 6, 10, 3, 5, 12, 4, 7, 9}; // category[0~2] : e,i  category[3~5] : n,s category[6~8] : f,t category[9~11] : p,j
        int[] score = new int[12]; // category 순서대로

        // get(category[0])의 값이 1이면 +1, 2이면 -1
        for (int i = 0; i < 12; i++) {
            int choice = answers.get(category[i]-1);
            score[i] += choice == 0 ? 1 : -1;
        }

        StringBuilder sb = new StringBuilder();

        sb.append(score[0] + score[1] + score[2] > 0 ? "e" : "i");
        sb.append(score[3] + score[4] + score[5] > 0 ? "n" : "s");
        sb.append(score[6] + score[7] + score[8] > 0 ? "f" : "t");
        sb.append(score[9] + score[10] + score[11] > 0 ? "p" : "j");

        return sb.toString();
    }

    public Long findResultId(String mbti){
        String[] mbtiList = {"estp", "estj", "esfp", "esfj", "entp", "entj", "enfp", "enfj", "istp", "istj", "isfp", "isfj", "intp", "intj", "infp", "infj"};
        long resultId = 0L;

        for(int i=0; i<16; i++){
            if(mbti.equals(mbtiList[i])){
                resultId = (long) i;
                break;
            }
        }

        return resultId;
    }
}
