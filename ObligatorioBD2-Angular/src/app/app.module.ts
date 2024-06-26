import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule, Routes} from '@angular/router';

import {AppComponent} from './app.component';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FixtureComponent } from './fixture/fixture.component';
import { ApuestasComponent } from './apuestas/apuestas.component';
import { LeaderboardComponent } from './leaderboard/leaderboard.component';
import { PrediccionComponent } from './prediccion/prediccion.component';
import { PartidoComponent } from './partido/partido.component';
import { PartidoFixtureComponent } from './partido-fixture/partido-fixture.component';
import { FixtureAdminComponent } from './fixture-admin/fixture-admin.component';
import { EquipoComponent } from './equipo/equipo.component';
import { HttpClientModule } from '@angular/common/http';
import { EquipoService } from './equipo.service';
import { PrediccionUsuarioComponent } from './prediccion-usuario/prediccion-usuario.component';
import { PrediccionItemComponent } from './prediccion-item/prediccion-item.component';
import { SignupComponent } from './signup/signup.component';
const appRoutes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'home', component: HomeComponent},
  {path: 'fixture', component: FixtureComponent},
  {path: 'fixtureadm', component: FixtureAdminComponent},
  {path: 'apuesta', component: ApuestasComponent},
  {path: 'leaderboard', component: LeaderboardComponent},
  {path: 'signup', component: SignupComponent},
  {path: 'predicciones', component: PrediccionUsuarioComponent}
];

@NgModule({
  imports: [
    BrowserModule, FormsModule,
    RouterModule.forRoot(
        appRoutes, {enableTracing: true}  // <-- debugging purposes only
        ),
    NgbModule,
    HttpClientModule
  ],
  declarations: [
    AppComponent, LoginComponent, NavbarComponent, HomeComponent, ApuestasComponent, PrediccionComponent, PartidoComponent, FixtureComponent, PartidoFixtureComponent,
    LeaderboardComponent,
    FixtureAdminComponent,
    EquipoComponent,
    PrediccionUsuarioComponent,
    PrediccionItemComponent,
    SignupComponent
  ],
  providers: [
    EquipoService, // Añade aquí EquipoService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}