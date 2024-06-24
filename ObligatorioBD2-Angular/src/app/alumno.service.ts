import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Alumno } from './alumno';

@Injectable({
  providedIn: 'root'
})
export class AlumnoService {

  private apiUrl = 'http://localhost:8080/alumno';  // URL de la API de países

  constructor(private http: HttpClient) { }

  getLeaderboard(): Observable<Alumno[]> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    return this.http.get<Alumno[]>(this.apiUrl+'/leaderboard', { headers: headers });
  }
  
  getTop15(): Observable<Alumno[]> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    return this.http.get<Alumno[]>(this.apiUrl+'/top15', { headers: headers });
  }

  getPuntaje(): Observable<number> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    return this.http.get<number>(this.apiUrl+'/puntaje?correo='+localStorage.getItem('correo') || "", { headers: headers });
  }
}
