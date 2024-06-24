import { Component, OnInit, Input } from '@angular/core';
import { UsuarioService } from '../usuario.service';
import { Usuario } from '../usuario';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  @Input() correo: string | undefined;
  @Input() contrasenia: string | undefined;
  tipoUsuario: string = "";
  
  constructor(protected router: Router, private usuarioService: UsuarioService) { }
 
  login() {
    let usuario: Usuario = {
      correo: this.correo,
      contrasenia: this.contrasenia
    }
    this.usuarioService.login(usuario).subscribe(usuarioRecibido => {
      if (usuarioRecibido.loginExitoso){
        localStorage.setItem("esAdmin", usuarioRecibido.esAdmin)
        if (this.correo){
          localStorage.setItem("correo", this.correo)
        }
        this.router.navigate(["/home"])
      }
    })
  }
}
