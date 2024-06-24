import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usuario } from './usuario';
import { Registro } from './registro';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

 login(usuario: Usuario){
  return this.http.post<any>('http://localhost:8080/login', usuario, this.httpOptions);
 } 

 signup(registro: Registro){
  return this.http.post<any>('http://localhost:8080/usuario/crearalumno', registro, this.httpOptions);
 }
}
