export interface Partido {
    id: string;
    equipo1Goles: number;
    equipo2Goles: number;
    imagenEquipo1: string | undefined;
    imagenEquipo2: string | undefined;
    equipo1: string;
    equipo2: string;
    fecha: Date;
  }