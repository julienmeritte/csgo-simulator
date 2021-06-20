import {RoleEnum} from "./enums/role.enum";

export interface PlayerDto {
  idPlayer: number;
  firstname: string;
  lastname: string;
  nickname: string;
  team: string;
  photo: string;
}
