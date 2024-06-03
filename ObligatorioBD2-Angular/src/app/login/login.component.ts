import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email: string = "";
  password: string = "";
  
  constructor(private router: Router) {}
 
  login() {
    /*if(this.email != "" && this.password != "") {
      let user: User = {
        id: "0",
        email: this.email,
        password: this.password,
        role: "none",
        token: "0"
      }
      this.authService.login(user)
      .subscribe(tokenInfo => this.authService.setSession(tokenInfo));
        
    }*/
    this.router.navigateByUrl('/home');
  }
}
