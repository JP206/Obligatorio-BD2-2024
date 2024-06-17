import { Component, OnInit } from '@angular/core';
import { Partido } from '../partido';
import { Time } from '@angular/common';
import { EquipoService } from '../equipo.service';
import { PartidoService } from '../partido.service';
import { Equipo } from '../equipo';
@Component({
  selector: 'app-prediccion',
  templateUrl: './prediccion.component.html',
  styleUrls: ['./prediccion.component.css']
})
export class PrediccionComponent implements OnInit {
  partidos: Partido[] = [];
  formularios: boolean = true;
  equipos: Equipo[] = [];
  errorMessage: string = '';

  constructor(private equipoService: EquipoService, private partidoService: PartidoService) { 
    
  }

  ngOnInit(): void {
    this.equipoService.getEquipos().subscribe(
      (data: Equipo[]) => {
        this.equipos = data;
      },
      (error) => {
        console.error('Error fetching equipos:', error);
        this.errorMessage = 'Hubo un error al cargar los equipos.';
      }
    );
    this.partidoService.getPartidos().subscribe(
      (data: Partido[]) => {
        this.asignarPartidos(data);
      },
      (error) => {
        console.error('Error fetching partidos:', error);
        this.errorMessage = 'Hubo un error al cargar los partidos.';
      }
    );
  }

  obtenerBanderaPorNombreEquipo(nombreEquipo: string): string {
    const equipo = this.equipos.find(e => e.nombre === nombreEquipo);
    return equipo ? equipo.bandera : '';
  }

  asignarPartidos(partidos: Partido[]) {
    for (const partido of partidos) {
      partido.imagenEquipo1 = this.obtenerBanderaPorNombreEquipo(partido.equipo1);
      partido.imagenEquipo2 = this.obtenerBanderaPorNombreEquipo(partido.equipo2);
    }
    this.partidos = partidos;
  }
}
