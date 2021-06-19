package com.csgosimulator.backend.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Builder
@Table(name = "team")
public class Team implements Serializable {

    @Id
    @GeneratedValue
    private Long idTeam;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "team")
    private List<Player> players;

    public Team() {

    }
}