import { Component, OnInit } from '@angular/core';
import { Partido } from '../partido';

@Component({
  selector: 'app-prediccion',
  templateUrl: './prediccion.component.html',
  styleUrls: ['./prediccion.component.css']
})
export class PrediccionComponent implements OnInit {
  partidos?: Partido[];
  formularios: boolean = true;
  constructor() { 
    this.partidos = [
      {
        id: '1',
        equipo1Goles: 1,
        equipo2Goles: 0,
        imagenEquipo1: 'https://static.wixstatic.com/media/808eda_ba1d5f0dd10e4eedaaba5346e2aa1fd4~mv2.webp',
        imagenEquipo2: 'https://static.wixstatic.com/media/808eda_ba1d5f0dd10e4eedaaba5346e2aa1fd4~mv2.webp',
        equipo1: 'Equipo 1',
        equipo2: 'Equipo 2',
        fecha: this.addMinutes(new Date(), 120)
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
        fecha: this.addMinutes(new Date(), 30)
      }
    ];
  }

  ngOnInit(): void {
  }

  addMinutes(date: Date, minutes: number): Date {
    return new Date(date.getTime() + minutes * 60000);
  }

}
