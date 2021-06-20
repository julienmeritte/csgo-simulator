package com.csgosimulator.backend.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerDto {
    Long idPlayer;
    String firstname;
    String lastname;
    String nickname;
    String team;
    String photo;
}
