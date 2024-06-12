import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PrediccionService {

  private apiUrl = 'http://localhost:8080/partido';  // URL de la API de países

  constructor(private http: HttpClient) { }

  /*getPredicciones(): Observable<Partido[]> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    return this.http.get<Partido[]>(this.apiUrl+'/partidos', { headers: headers });
  }*/

  /*crearPrediccion(partido: Partido): Observable<Boolean> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    return this.http.put<Boolean>(this.apiUrl+'/editar', partido, { headers: headers });
  }*/

}
