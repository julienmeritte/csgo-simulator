package com.csgosimulator.backend.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeamDto {
    Long idTeam;
    String name;
    Integer points;
    List<PlayerDto> players;
}
