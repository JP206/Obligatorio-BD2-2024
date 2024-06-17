import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Prediccion } from './prediccion';
import { Observable } from 'rxjs';
import { PrediccionCrear } from './prediccion_crear';

@Injectable({
  providedIn: 'root'
})
export class PrediccionService {

  private apiUrl = 'http://localhost:8080/prediccion';  // URL de la API de países

  constructor(private http: HttpClient) { }

  getPredicciones(correoUsuario: string): Observable<Prediccion[]> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    return this.http.get<Prediccion[]>(this.apiUrl+'/'+correoUsuario, { headers: headers });
  }

  crearPrediccion(prediccion: PrediccionCrear): Observable<Boolean> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    return this.http.post<Boolean>(this.apiUrl+'/crear', prediccion, { headers: headers });
  }

  actualizarPrediccion(prediccion: PrediccionCrear): Observable<Boolean> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    
    return this.http.post<Boolean>(this.apiUrl+'/actualizar', prediccion, { headers: headers });
  }

}
