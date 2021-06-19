package com.csgosimulator.backend.repositories;

import com.csgosimulator.backend.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    Player getByIdPlayer(Long idPLayer);

    Player getByNickname(String nickname);

    @Query(nativeQuery = true, value = "SELECT * FROM player")
    List<Player> getAllPlayers();
}
