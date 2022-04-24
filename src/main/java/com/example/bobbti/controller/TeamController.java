package com.example.bobbti.controller;

import com.example.bobbti.controller.dto.TeamNameDto;
import com.example.bobbti.repository.TeamRepository;
import com.example.bobbti.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Random;

@RestController
public class TeamController {

    private final TeamRepository teamRepository;
    private final TeamService teamService;

    public TeamController(TeamRepository teamRepository, TeamService teamService) {
        this.teamRepository = teamRepository;
        this.teamService = teamService;
    }

    // team code 생성하기
    @PostMapping("home")
    public ResponseEntity<?> createTeamCode(
            @RequestBody TeamNameDto teamNameDto
    ){
        String teamCode = this.teamService.createTeam(teamNameDto.getTeamName());

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().queryParam("team", teamCode).buildAndExpand().toUri();

        // ex) http://localhost:8080/home?team=kg20sxqFv0
        return ResponseEntity.created(location).build();
    }

    // team code로 팀 불러오기
    @GetMapping("result")
    public ResponseEntity<?> readTeamByCode(
            @RequestParam("team") String teamCode
    ){
        return ResponseEntity.ok(this.teamService.readAllByTeamCode(teamCode));
    }
}
