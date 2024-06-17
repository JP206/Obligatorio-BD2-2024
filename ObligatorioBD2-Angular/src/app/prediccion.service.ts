import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Prediccion } from './prediccion';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PrediccionService {

  private apiUrl = 'http://localhost:8080/prediccion';  // URL de la API de países

  constructor(private http: HttpClient) { }

  getPredicciones(nombreUsuario: string): Observable<Prediccion[]> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    return this.http.get<Prediccion[]>(this.apiUrl+'/'+nombreUsuario, { headers: headers });
  }

  crearPrediccion(prediccion: Prediccion): Observable<Boolean> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    return this.http.post<Boolean>(this.apiUrl+'/crear', prediccion, { headers: headers });
  }

}
