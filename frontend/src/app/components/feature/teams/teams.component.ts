import {Component, OnInit} from '@angular/core';
import {PlayerDto} from "../../../models/player-dto";
import {TeamDto} from "../../../models/team-dto";
import {PlayerService} from "../../../services/player-service/player.service";
import {TeamService} from "../../../services/team-service/team.service";
import {RoleEnum} from "../../../models/enums/role.enum"

@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.scss']
})
export class TeamsComponent implements OnInit {

  teamDto: TeamDto[] = [];
  teamActual: TeamDto = new class implements TeamDto {
    idTeam: number = 0;
    name: string = "Empty Team";
    players: PlayerDto[] = [];
    points: number = 0;
  };
  coach: RoleEnum = RoleEnum.coach;

  constructor(private playerService: PlayerService, private teamService: TeamService) {

  }

  ngOnInit(): void {
    this.initTeams();
  }

  initTeams() {
    this.findAllTeams()
    this.findFirstTeam()
  }

  findAllTeams() {
    this.teamService.findAllTeams()
      .pipe()
      .subscribe(data => {
        console.log(data);
        this.teamDto = data;
      }, error => {
        console.log(error);
      });
  }

  findFirstTeam() {
    this.teamService.findTeamById(1)
      .pipe()
      .subscribe(data => {
        console.log(data);
        this.teamActual = data;
      }, error => {
        console.log(error);
      });
  }

  loadTeam(idTeam: number) {
    this.teamDto.forEach(team => {
      if (team.idTeam == idTeam) {
        this.teamActual = team;
      }
    });
  }
}
