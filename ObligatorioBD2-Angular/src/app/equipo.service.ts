import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Equipo } from './equipo'; // Asegúrate de importar el modelo de equipo si es necesario

@Injectable({
  providedIn: 'root'
})
export class EquipoService {

  private apiUrl = 'http://localhost:8080/pais/paises';  // URL de la API de países

  constructor(private http: HttpClient) { }

  getEquipos(): Observable<Equipo[]> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    return this.http.get<Equipo[]>(this.apiUrl, { headers: headers });
  }
}
