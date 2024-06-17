import { Component, OnInit } from '@angular/core';
import { Alumno } from '../alumno';
import { AlumnoService } from '../alumno.service';

@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.css']
})
export class LeaderboardComponent implements OnInit {
  alumnos: Alumno[] = [];
  errorMessage: string = "";
  constructor(private alumnoService: AlumnoService) {
  }

  ngOnInit(): void {
    this.alumnoService.getLeaderboard().subscribe(
      (data: Alumno[]) => {
        this.alumnos = data;
      },
      (error) => {
        console.error('Error fetching alumnos:', error);
        this.errorMessage = 'Hubo un error al cargar los alumnos del leaderboard.';
      }
    );
  }

}
