package com.csgosimulator.backend.controllers;

import com.csgosimulator.backend.Dto.PlayerDto;
import com.csgosimulator.backend.Dto.TeamDto;
import com.csgosimulator.backend.models.Team;
import com.csgosimulator.backend.services.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/all")
    public ResponseEntity<Object> getAllTeams() {

        List<TeamDto> teams = teamService.getAllTeam();

        return ResponseEntity.status(200).body(teams);
    }

    @GetMapping("/find/{idteam}")
    public ResponseEntity<Object> getOneTeamById(@PathVariable(name = "idteam") Long id) {
        return ResponseEntity.status(200).body(teamService.getTeamById(id));
    }
}
