import { Component, OnInit } from '@angular/core';
import { Alumno } from '../alumno';

@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.css']
})
export class LeaderboardComponent implements OnInit {
  alumnos?: Alumno[];
  constructor() { 
    this.alumnos = [
      {
        id: '1',
        nombre: 'Santiago',
        apellido: 'Ferraro',
        edad: 21,
        puesto: 1
      },
      {
        id: '1',
        nombre: 'Santiago',
        apellido: 'Ferraro',
        edad: 21,
        puesto: 1
      },
      {
        id: '1',
        nombre: 'Santiago',
        apellido: 'Ferraro',
        edad: 21,
        puesto: 1
      },
      {
        id: '1',
        nombre: 'Santiago',
        apellido: 'Ferraro',
        edad: 21,
        puesto: 1
      },
      {
        id: '1',
        nombre: 'Santiago',
        apellido: 'Ferraro',
        edad: 21,
        puesto: 1
      },
      {
        id: '1',
        nombre: 'Santiago',
        apellido: 'Ferraro',
        edad: 21,
        puesto: 1
      },
      {
        id: '1',
        nombre: 'Santiago',
        apellido: 'Ferraro',
        edad: 21,
        puesto: 1
      },
      {
        id: '1',
        nombre: 'Santiago',
        apellido: 'Ferraro',
        edad: 21,
        puesto: 1
      },
      {
        id: '1',
        nombre: 'Santiago',
        apellido: 'Ferraro',
        edad: 21,
        puesto: 1
      },
      {
        id: '1',
        nombre: 'Santiago',
        apellido: 'Ferraro',
        edad: 21,
        puesto: 1
      }
    ];
  }

  ngOnInit(): void {
  }

}
