package com.csgosimulator.backend.Utils;

import com.csgosimulator.backend.Dto.PlayerDto;
import com.csgosimulator.backend.Dto.TeamDto;
import com.csgosimulator.backend.Dto.enums.RolesEnum;
import com.csgosimulator.backend.models.Player;
import com.csgosimulator.backend.models.Team;
import com.csgosimulator.backend.services.PlayerService;
import com.csgosimulator.backend.services.TeamService;
import lombok.Getter;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MissingServletRequestParameterException;

import java.util.ArrayList;
import java.util.List;

@Getter
public final class Utils {

    @Autowired
    private TeamService teamService;

    @Autowired
    private PlayerService playerService;

    public static JSONObject jsonifyParamsMissing(MissingServletRequestParameterException exception) throws JSONException {
        JSONObject response = new JSONObject();
        response.put("messsage", exception.getMessage());
        response.put("Param Name", exception.getParameterName());
        response.put("Param Type", exception.getParameterType());
        return response;
    }

    public static List<PlayerDto> playerToPlayerDto(List<Player> players) {
        List<PlayerDto> playerDtos = new ArrayList<>();
        for (Player player : players
        ) {
            PlayerDto dto = new PlayerDto();
            dto.setIdPlayer(player.getIdPlayer());
            dto.setFirstname(player.getFirstname());
            dto.setLastname(player.getLastname());
            dto.setNickname(player.getNickname());
            dto.setTeam(player.getTeam().getName());
            dto.setPhoto(player.getPhoto());
            dto.setRole(player.getRole());
            playerDtos.add(dto);
        }
        return playerDtos;
    }

    public static PlayerDto playerToPlayerDto(Player player) {
        PlayerDto dto = new PlayerDto();
        dto.setIdPlayer(player.getIdPlayer());
        dto.setFirstname(player.getFirstname());
        dto.setLastname(player.getLastname());
        dto.setNickname(player.getNickname());
        dto.setTeam(player.getTeam().getName());
        dto.setPhoto(player.getPhoto());
        dto.setRole(player.getRole());
        return dto;
    }

    public static List<TeamDto> teamToTeamDto(List<Team> teams) {
        List<TeamDto> teamDtos = new ArrayList<>();
        for (Team team : teams
        ) {
            TeamDto dto = new TeamDto();
            dto.setIdTeam(team.getIdTeam());
            dto.setName(team.getName());
            dto.setPoints(team.getPoints());
            List<PlayerDto> playerDtos = new ArrayList<>();
            for (Player player : team.getPlayers()
                 ) {
                playerDtos.add(playerToPlayerDto(player));
            }
            dto.setPlayers(playerDtos);
            teamDtos.add(dto);
        }
        return teamDtos;
    }

    public static TeamDto teamToTeamDto(Team team) {
        TeamDto dto = new TeamDto();
        dto.setIdTeam(team.getIdTeam());
        dto.setName(team.getName());
        dto.setPoints(team.getPoints());
        List<PlayerDto> playerDtos = new ArrayList<>();
        for (Player player : team.getPlayers()
        ) {
            playerDtos.add(playerToPlayerDto(player));
        }
        dto.setPlayers(playerDtos);
        return dto;
    }

    public static Team initTeam(String name) {
        List<Player> players = new ArrayList<>();
        Team team = new Team();
        team.setName(name);
        team.setPlayers(players);
        team.setPoints(0);

        return team;
    }

    public static Player initPlayer(String firstname, String lastname, String nickname, String photo, Team team) {
        Player player = new Player();
        player.setFirstname(firstname);
        player.setLastname(lastname);
        player.setNickname(nickname);
        player.setPhoto(photo);
        player.setTeam(team);
        return player;
    }

    public static Player initPlayer(String firstname, String lastname, String nickname, String photo, Team team, RolesEnum role) {
        Player player = new Player();
        player.setFirstname(firstname);
        player.setLastname(lastname);
        player.setNickname(nickname);
        player.setPhoto(photo);
        player.setTeam(team);
        player.setRole(role);
        return player;
    }
}