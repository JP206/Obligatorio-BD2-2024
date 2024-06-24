import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Registro } from '../registro';
import { UsuarioService } from '../usuario.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  @Input() nombre: string | undefined;
  @Input() apellido: string | undefined;
  @Input() correo: string | undefined;
  @Input() contrasenia: string | undefined;
  @Input() campeon: string | undefined;
  @Input() subcampeon: string | undefined;
  @Input() carrera: string | undefined;
  
  constructor(protected router: Router, private usuarioService: UsuarioService) { }
 
  signup() {
    let registro: Registro = {
      nombre: this.nombre,
      apellido: this.apellido,
      correo: this.correo,
      contrasenia: this.contrasenia,
      campeon: this.campeon,
      subcampeon: this.subcampeon,
      carrera: this.carrera
    }
    this.usuarioService.signup(registro).subscribe(registroHecho => {
      if (registroHecho){
        localStorage.setItem("esAdmin", "false")
        if (this.correo){
          localStorage.setItem("correo", this.correo)
        }
        this.router.navigate(["/home"])
      }
    })
  }


}
