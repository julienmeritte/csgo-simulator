package com.csgosimulator.backend.models;

import com.csgosimulator.backend.Dto.enums.RolesEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@Builder
@Table(name = "player")
public class Player implements Serializable {

    @Id
    @GeneratedValue
    private Long idPlayer;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String nickname;

    private String photo;

    private RolesEnum role;

    @ManyToOne
    @JoinColumn(name = "idTeam")
    private Team team;

    public Player() {
        if (photo == null) {
            photo = "https://i.imgur.com/0CHEBuD.jpeg";
        }
        if (role == null) {
            role = RolesEnum.backup;
        }
    }
}
