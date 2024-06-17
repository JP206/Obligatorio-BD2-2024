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
    this.partidos.sort((a, b) => a.posicionFormulario - b.posicionFormulario);
    for ( const partido of partidos ) {
      console.log(partido)
      partido.imagenEquipo1 = this.obtenerBanderaPorNombreEquipo(partido.equipo1);
      partido.imagenEquipo2 = this.obtenerBanderaPorNombreEquipo(partido.equipo2);
      this.partidos.push(partido)
      switch (partido.etapa) {
        case "Fase de grupos":
          this.grupoA?.push(partido); // TODO REVISAR COMO CONOCER LA FASE DEL GRUPO QUE PERTENECE
          break;
        case "Cuartos de final":
          this.cuartos?.push(partido);
          break;
        case "Semifinales":
          this.semifinal?.push(partido);
          break;
        case "Final":
          this.final?.push(partido);
          break;
        case "3° puesto":
          this.tercerCuartoPuesto?.push(partido);
          break;
      }
    }
  }

  obtenerBanderaPorNombreEquipo(nombreEquipo: string): string {
    const equipo = this.equipos.find(e => e.nombre === nombreEquipo);
    return equipo ? equipo.bandera : '';
  }
}
