import {PlayerDto} from "./player-dto";

export interface TeamDto {
  idTeam: number;
  name: string;
  points: number;
  players: PlayerDto[];
}
