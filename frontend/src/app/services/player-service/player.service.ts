import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {PlayerDto} from "../../models/player-dto";

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  constructor(private http: HttpClient) { }

  findAllPlayers() {
    return this.http.get<PlayerDto[]>("http://localhost:8080/player/all");
  }
}
