import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Partido } from './partido';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PartidoService {

  private apiUrl = 'http://localhost:8080/partido';  // URL de la API de países

  constructor(private http: HttpClient) { }

  getPartidos(): Observable<Partido[]> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    return this.http.get<Partido[]>(this.apiUrl+'/partidos', { headers: headers });
  }

  editarPartido(partido: Partido): Observable<Boolean> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    return this.http.put<Boolean>(this.apiUrl+'/editar', partido, { headers: headers });
  }

}
