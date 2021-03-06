package com.csgosimulator.backend.services;

import com.csgosimulator.backend.Dto.TeamDto;
import com.csgosimulator.backend.Utils.Utils;
import com.csgosimulator.backend.models.Player;
import com.csgosimulator.backend.models.Team;
import com.csgosimulator.backend.repositories.PlayerRepository;
import com.csgosimulator.backend.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    public void createTeam(Team team) {
        teamRepository.save(team);
    }

    public Team createTeam(String name) {

        Team team = new Team();
        team.setName(name);

        teamRepository.save(team);

        return team;
    }

    public List<TeamDto> getAllTeam() {
        List<Team> teams = teamRepository.getAllTeams();
        return Utils.teamToTeamDto(teams);
    }

    public void save(Team team) {
        teamRepository.save(team);
    }

    public TeamDto getTeamById(Long id) {
        Team team = teamRepository.getById(id);
        return Utils.teamToTeamDto(team);
    }
}
