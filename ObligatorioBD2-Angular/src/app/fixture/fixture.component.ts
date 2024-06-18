import { Component, OnInit } from '@angular/core';
import { Partido } from '../partido';
import { EquipoService } from '../equipo.service';
import { Equipo } from '../equipo';
import { PartidoService } from '../partido.service';

@Component({
  selector: 'app-fixture',
  templateUrl: './fixture.component.html',
  styleUrls: ['./fixture.component.css']
})
export class FixtureComponent implements OnInit {
  cuartos: Partido[] = [];
  semifinal: Partido[] = [];
  final: Partido[] = [];
  tercerCuartoPuesto: Partido[] = [];
  grupoA: Partido[] = [];
  grupoB: Partido[] = [];
  grupoC: Partido[] = [];
  grupoD: Partido[] = [];

  partidos: Partido[] = [];
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
        console.log('esta es la data: ', data)
        this.asignarPartidos(data);
      },
      (error) => {
        console.error('Error fetching partidos:', error);
        this.errorMessage = 'Hubo un error al cargar los partidos.';
      }
    );
  }

  openModal(grupo: string) {
    const modal = document.getElementById(`${grupo}Modal`);
    if (modal) {
    modal.style.display = "block";}
  }

  closeModal(grupo: string) {
    const modal = document.getElementById(`${grupo}Modal`);
    if (modal) {
    modal.style.display = "none";}
  }

  asignarPartidos(partidos: Partido[]) {
    partidos.sort((a, b) => a.posicionFormulario - b.posicionFormulario);
    for ( const partido of partidos ) {
      partido.imagenEquipo1 = this.obtenerBanderaPorNombreEquipo(partido.equipo1);
      partido.imagenEquipo2 = this.obtenerBanderaPorNombreEquipo(partido.equipo2);
      if (partido.golesEquipo1 == -1) {
        partido.golesEquipo1 = 0;
      }
      if (partido.golesEquipo2 == -1) {
        partido.golesEquipo2 = 0;
      }
      this.partidos.push(partido)
      
    }
  }

  obtenerBanderaPorNombreEquipo(nombreEquipo: string): string {
    const equipo = this.equipos.find(e => e.nombre === nombreEquipo);
    return equipo ? equipo.bandera : '';
  }
}
