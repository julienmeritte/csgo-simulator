package com.csgosimulator.backend;

import com.csgosimulator.backend.models.Player;
import com.csgosimulator.backend.models.Team;
import com.csgosimulator.backend.services.PlayerService;
import com.csgosimulator.backend.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

    @Autowired
    PlayerService playerService;

    @Autowired
    TeamService teamService;

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Override
    public void run(String... params) throws Exception {

        List<Player> listPlayers = new ArrayList<>();
        Team team = new Team();
        team.setName("Test");
        team.setPlayers(listPlayers);

        teamService.createTeam(team);


        Player player = new Player();
        player.setFirstname("Oleksandr");
        player.setLastname("Kostyliev");
        player.setNickname("s1mple");

        playerService.createPlayer(player);

        Player playerBis = new Player();
        playerBis.setFirstname("Denis");
        playerBis.setLastname("Sharipov");
        playerBis.setNickname("electronic");

        playerService.createPlayer(playerBis);

        listPlayers.add(player);
        listPlayers.add(playerBis);

        team.setPlayers(listPlayers);

        teamService.save(team);
    }

}
