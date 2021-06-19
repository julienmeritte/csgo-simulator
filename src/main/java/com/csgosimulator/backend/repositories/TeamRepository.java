package com.csgosimulator.backend.repositories;

import com.csgosimulator.backend.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM team")
    List<Team> getAllTeams();
}
