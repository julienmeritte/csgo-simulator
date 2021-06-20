import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {TeamDto} from "../../models/team-dto";

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  constructor(private http: HttpClient) {
  }

  findAllTeams() {
    return this.http.get<TeamDto[]>("/team/all");
  }

  findTeamById(id: number) {
    return this.http.get<TeamDto>("/team/find/" + id);
  }
}
