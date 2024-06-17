import { Component, OnInit } from '@angular/core';
import { EquipoService } from '../equipo.service';
import { Partido } from '../partido';
import { Equipo } from '../equipo';
import { PartidoService } from '../partido.service';

@Component({
  selector: 'app-fixture-admin',
  templateUrl: './fixture-admin.component.html',
  styleUrls: ['./fixture-admin.component.css']
})
export class FixtureAdminComponent implements OnInit {
  cuartos: Partido[] = [];
  semifinal: Partido[] = [];
  final: Partido[] = [];
  tercerCuartoPuesto: Partido[] = [];
  grupoA: Partido[] = [];
  grupoB: Partido[] = [];
  grupoC: Partido[] = [];
  grupoD: Partido[] = [];
  admin: boolean = true;
  equipos: Equipo[] = [];
  partidoSeleccionado: Partido | undefined;
  equipoSeleccionado: number = 0;
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

  openModal(grupo: string) {
    const modal = document.getElementById(`${grupo}Modal`);
    if (modal) {
      modal.style.display = "block";
    }
  }

  closeModal(grupo: string) {
    const modal = document.getElementById(`${grupo}Modal`);
    if (modal) {
      modal.style.display = "none";
    }
  }

  closeModalEquipos() {
    const modal = document.getElementById('ModalEquipos');
    if (modal) {
      modal.style.display = "none";
    }
  }

  confirmar() {
    //this.partidoService.actualizarPartidos(this.partidos) TODO HACERLO ASI CON LOS NUEVOS
    this.partidoService.actualizarPartidos(this.grupoA.concat(this.grupoB, this.grupoC, this.grupoD, this.semifinal, this.final, this.cuartos, this.tercerCuartoPuesto)).subscribe(
      (data: Boolean) => {
        console.log('se actualizaron: ', data)
      },
      (error) => {
        console.error('Error cambiando partidos:', error);
        this.errorMessage = 'Hubo un error al actualizar los partidos.';
      }
    );
  }

  abrirSeleccion(event: {partido: Partido, equipo: number}) {
    const modal = document.getElementById('ModalEquipos');
    if (modal) {
      modal.style.display = "block";
    }
    console.log('se obtuvo el evento');
    this.partidoSeleccionado = event.partido;
    this.equipoSeleccionado = event.equipo;
  }

  confirmarCambio(nombreEquipo: string) {
    if (this.partidoSeleccionado){
      if (this.equipoSeleccionado == 1) {
        this.partidoSeleccionado.equipo1 = nombreEquipo;
        this.partidoSeleccionado.imagenEquipo1 = this.obtenerBanderaPorNombreEquipo(nombreEquipo)
      } 
      else if (this.equipoSeleccionado == 2) {
        this.partidoSeleccionado.equipo2 = nombreEquipo;
        this.partidoSeleccionado.imagenEquipo2 = this.obtenerBanderaPorNombreEquipo(nombreEquipo)
      }
      
      this.partidoService.editarPartido(this.partidoSeleccionado).subscribe(
        (data: Boolean) => {
          console.log('Ocurrio la edición: ', data);
        },
        (error) => {
          console.error('Error fetching partidos:', error);
          this.errorMessage = 'Hubo un error al cargar los partidos.';
        }
      );
      console.log('confirmando cambios de equipo: ' + nombreEquipo);
    }
  }

  asignarPartidos(partidos: Partido[]) {
    for ( const partido of partidos ) {
      partido.imagenEquipo1 = this.obtenerBanderaPorNombreEquipo(partido.equipo1);
      partido.imagenEquipo2 = this.obtenerBanderaPorNombreEquipo(partido.equipo2);
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
