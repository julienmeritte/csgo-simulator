package com.csgosimulator.backend;

import com.csgosimulator.backend.Dto.enums.RolesEnum;
import com.csgosimulator.backend.Utils.Utils;
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
        Team team = Utils.initTeam("Natus Vincere");
        teamService.createTeam(team);

        playerService.createPlayer(Utils.initPlayer("Oleksandr", "Kostyliev", "s1mple", "https://i.imgur.com/SfFxYEJ.png", team, RolesEnum.awper));
        playerService.createPlayer(Utils.initPlayer("Denis", "Sharipov", "electronic", "https://i.imgur.com/hL20mNe.png", team, RolesEnum.rifler));
        playerService.createPlayer(Utils.initPlayer("Kirill", "Mikhailov", "Boombl4", "https://i.imgur.com/6ktDA2U.png", team, RolesEnum.leader));
        playerService.createPlayer(Utils.initPlayer("Ilya", "Zalutskiy", "Perfecto", "https://i.imgur.com/xSbOXMf.png", team, RolesEnum.support));
        playerService.createPlayer(Utils.initPlayer("Valeriy", "Vakhovskiy", "B1T", "https://i.imgur.com/xTQ7RX3.png", team, RolesEnum.rifler));
        playerService.createPlayer(Utils.initPlayer("Andrey", "Gorodenskiy", "B1ad3", "https://i.imgur.com/uWPRw4c.jpeg", team, RolesEnum.coach));
    }

    private void initVita() {
        Team team = Utils.initTeam("Vitality");
        teamService.createTeam(team);

        playerService.createPlayer(Utils.initPlayer("Mathieu", "Herbaut", "ZywOo", "https://i.imgur.com/ZqGTAfy.png", team, RolesEnum.awper));
        playerService.createPlayer(Utils.initPlayer("Richard", "Papillon", "shox", "https://i.imgur.com/HSuZJVg.png", team, RolesEnum.rifler));

    }

}
