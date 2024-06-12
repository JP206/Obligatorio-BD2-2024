import { Component, OnInit } from '@angular/core';
import { EquipoService } from '../equipo.service';
import { Partido } from '../partido';
import { Equipo } from '../equipo';

@Component({
  selector: 'app-fixture-admin',
  templateUrl: './fixture-admin.component.html',
  styleUrls: ['./fixture-admin.component.css']
})
export class FixtureAdminComponent implements OnInit {
  partido: Partido;
  grupoA?: Partido[];
  grupoB?: Partido[];
  grupoC?: Partido[];
  grupoD?: Partido[];
  admin: boolean = true;
  equipos: Equipo[] = [];
  partidoSeleccionado: string = '';
  equipoSeleccionado: number = 0;
  errorMessage: string = '';

  constructor(private equipoService: EquipoService) {
    this.partido = {
      id: '3',
      equipo1Goles: 3,
      equipo2Goles: 1,
      imagenEquipo1: 'https://static.wixstatic.com/media/808eda_ba1d5f0dd10e4eedaaba5346e2aa1fd4~mv2.webp',
      imagenEquipo2: 'https://static.wixstatic.com/media/808eda_ba1d5f0dd10e4eedaaba5346e2aa1fd4~mv2.webp',
      equipo1: 'Uruguay',
      equipo2: 'Jamaica',
      fecha: new Date()
    }
    this.grupoA = [
      {
        id: '1',
        equipo1Goles: 1,
        equipo2Goles: 0,
        imagenEquipo1: 'https://static.wixstatic.com/media/808eda_ba1d5f0dd10e4eedaaba5346e2aa1fd4~mv2.webp',
        imagenEquipo2: 'https://static.wixstatic.com/media/808eda_ba1d5f0dd10e4eedaaba5346e2aa1fd4~mv2.webp',
        equipo1: 'Equipo 1',
        equipo2: 'Equipo 2',
        fecha: new Date()
      },
      {
        id: '2',
        equipo1Goles: 2,
        equipo2Goles: 2,
        imagenEquipo1: 'https://static.wixstatic.com/media/808eda_ba1d5f0dd10e4eedaaba5346e2aa1fd4~mv2.webp',
        imagenEquipo2: 'https://static.wixstatic.com/media/808eda_ba1d5f0dd10e4eedaaba5346e2aa1fd4~mv2.webp',
        equipo1: 'Equipo 3',
        equipo2: 'Equipo 4',
        fecha: new Date('2024-05-13T18:45:00')
      },
      {
        id: '3',
        equipo1Goles: 3,
        equipo2Goles: 1,
        imagenEquipo1: 'https://static.wixstatic.com/media/808eda_ba1d5f0dd10e4eedaaba5346e2aa1fd4~mv2.webp',
        imagenEquipo2: 'https://static.wixstatic.com/media/808eda_ba1d5f0dd10e4eedaaba5346e2aa1fd4~mv2.webp',
        equipo1: 'Equipo 5',
        equipo2: 'Equipo 6',
        fecha: new Date()
      }
    ];
    this.grupoB = this.grupoA;
    this.grupoC = this.grupoA;
    this.grupoD = this.grupoA;
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
    // Código para confirmar
  }

  abrirSeleccion(event: {idPartido: string, equipo: number}) {
    const modal = document.getElementById('ModalEquipos');
    if (modal) {
      modal.style.display = "block";
    }
    console.log('se obtuvo el evento');
    this.partidoSeleccionado = event.idPartido;
    this.equipoSeleccionado = event.equipo;
  }

  confirmarCambio(nombreEquipo: string) {
    // Confirmar cambios
    console.log('confirmando cambios de equipo: ' + nombreEquipo);
  }
}
