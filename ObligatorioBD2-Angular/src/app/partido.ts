import { Time } from "@angular/common";

export interface Partido {
    id: string;
    golesEquipo1: number;
    golesEquipo2: number;
    imagenEquipo1: string | undefined;
    imagenEquipo2: string | undefined;
    equipo1: string;
    equipo2: string;
    fecha: Date;
    hora: string;
    etapa: string;
  }
