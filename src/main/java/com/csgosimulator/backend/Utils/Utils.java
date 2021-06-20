package com.csgosimulator.backend.Utils;

import com.csgosimulator.backend.Dto.PlayerDto;
import com.csgosimulator.backend.models.Player;
import lombok.Getter;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.web.bind.MissingServletRequestParameterException;

import java.util.ArrayList;
import java.util.List;

@Getter
public final class Utils {

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
        return dto;
    }
}