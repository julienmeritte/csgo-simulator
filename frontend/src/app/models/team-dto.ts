import {PlayerDto} from "./player-dto";

export interface TeamDto {
  name: string;
  points: number;
  players: PlayerDto[];
}
