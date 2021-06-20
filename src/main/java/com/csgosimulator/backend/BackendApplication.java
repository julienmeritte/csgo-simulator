package com.csgosimulator.backend;

import com.csgosimulator.backend.models.Player;
import com.csgosimulator.backend.models.Team;
import com.csgosimulator.backend.services.PlayerService;
import com.csgosimulator.backend.services.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@Slf4j
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
        initNavi();
        initVita();
    }

    private void initNavi() {
        List<Player> listPlayers = new ArrayList<>();
        Team team = new Team();
        team.setName("Natus Vincere");
        team.setPlayers(listPlayers);
        team.setPoints(0);

        teamService.createTeam(team);


        Player player = new Player();
        player.setFirstname("Oleksandr");
        player.setLastname("Kostyliev");
        player.setNickname("s1mple");
        player.setPhoto("https://i.imgur.com/SfFxYEJ.png");
        player.setTeam(team);
        playerService.createPlayer(player);

        Player playerBis = new Player();
        playerBis.setFirstname("Denis");
        playerBis.setLastname("Sharipov");
        playerBis.setNickname("electronic");
        playerBis.setPhoto("https://i.imgur.com/hL20mNe.png");
        playerBis.setTeam(team);
        playerService.createPlayer(playerBis);

        listPlayers.add(player);
        listPlayers.add(playerBis);

        team.setPlayers(listPlayers);

        teamService.save(team);
    }

    private void initVita() {
        List<Player> listPlayers = new ArrayList<>();
        Team team = new Team();
        team.setName("Vitality");
        team.setPlayers(listPlayers);
        team.setPoints(0);

        teamService.createTeam(team);


        Player player = new Player();
        player.setFirstname("Mathieu");
        player.setLastname("Herbaut");
        player.setNickname("ZywOo");
        player.setPhoto("https://i.imgur.com/ZqGTAfy.png");
        player.setTeam(team);
        playerService.createPlayer(player);

        Player playerBis = new Player();
        playerBis.setFirstname("Richard");
        playerBis.setLastname("Papillon");
        playerBis.setNickname("shox");
        playerBis.setPhoto("https://i.imgur.com/HSuZJVg.png");
        playerBis.setTeam(team);
        playerService.createPlayer(playerBis);

        listPlayers.add(player);
        listPlayers.add(playerBis);

        team.setPlayers(listPlayers);

        teamService.save(team);
    }

}
