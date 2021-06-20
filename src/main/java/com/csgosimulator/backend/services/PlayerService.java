package com.csgosimulator.backend.services;

import com.csgosimulator.backend.Dto.PlayerDto;
import com.csgosimulator.backend.Utils.Utils;
import com.csgosimulator.backend.models.Player;
import com.csgosimulator.backend.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public void createPlayer(Player player) {
        playerRepository.save(player);
    }

    public Player createPlayer(String firstname, String lastname, String nickname) {

        Player player = new Player();
        player.setFirstname(firstname);
        player.setLastname(lastname);
        player.setNickname(nickname);

        playerRepository.save(player);

        return player;
    }

    public List<PlayerDto> getAllPlayer() {
        List<Player> players = playerRepository.getAllPlayers();
        return Utils.playerToPlayerDto(players);
    }
}
