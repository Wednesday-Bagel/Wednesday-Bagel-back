package com.example.bobbti.service;

import com.example.bobbti.controller.dto.ResultResponseDto;
import com.example.bobbti.entity.Result;
import com.example.bobbti.entity.Team;
import com.example.bobbti.repository.QuizResultRepository;
import com.example.bobbti.repository.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final QuizResultRepository quizResultRepository;

    public TeamService(TeamRepository teamRepository, QuizResultRepository quizResultRepository) {
        this.teamRepository = teamRepository;
        this.quizResultRepository = quizResultRepository;
    }

    public String createTeam(String teamName) {
        // URL 생성
        String generatedCode = makeCode();

        // URL 중복체크
        if(this.teamRepository.existsByCode(generatedCode)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        // 팀 save
        this.teamRepository.save(Team.builder()
                .name(teamName)
                .code(generatedCode)
                .build());

        return generatedCode;
    }


    public List<ResultResponseDto> readAllByTeamCode(String teamcode){
        // team에서 teamcode로 team 알아내고
        Team team = this.teamRepository.findByCode(teamcode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Long teamId = team.getId();

        // quizresult에서 team으로 모두 불러오기
        // quizResults 돌면서 name, result 불러와서 TeamResultDto 만들고
        // List<TeamResultDto> 에 저장하기
        List<ResultResponseDto> resultResponseDtos = new ArrayList<>();
        this.quizResultRepository.findAllByTeam(team).forEach(
                quizResult -> {
                    Long id = quizResult.getId();
                    Result result = quizResult.getResult();
                    resultResponseDtos.add(new ResultResponseDto(id, quizResult.getName(), result));
                }
        );

        return resultResponseDtos;
    }

    public String makeCode(){
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit,rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

}
