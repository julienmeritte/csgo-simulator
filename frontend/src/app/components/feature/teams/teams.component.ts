import {Component, OnInit} from '@angular/core';
import {PlayerDto} from "../../../models/player-dto";
import {RoleEnum} from "../../../models/enums/role.enum";
import {TeamDto} from "../../../models/team-dto";
import {ActivatedRoute, Router} from '@angular/router';
import {PlayerService} from "../../../services/player-service/player.service";

@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.scss']
})
export class TeamsComponent implements OnInit {

  playerDto: PlayerDto[] | undefined;

  constructor(private playerService: PlayerService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.initPlayers();
  }

  initPlayers() {
    this.findAllPlayers();
  }

  findAllPlayers() {
    this.playerService.findAllPlayers()
      .pipe()
      .subscribe(data => {
        console.log(data);
        this.playerDto = data;
      }, error => {
        console.log(error);
      });
  }
}
