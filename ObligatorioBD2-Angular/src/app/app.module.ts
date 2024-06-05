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

const appRoutes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'home', component: HomeComponent},
  {path: 'fixture', component: FixtureComponent},
  {path: 'fixtureadm', component: FixtureAdminComponent},
  {path: 'apuesta', component: ApuestasComponent},
  {path: 'leaderboard', component: LeaderboardComponent},
  {path: 'login', component: LoginComponent},
  {path: '', component: LoginComponent}
];

@NgModule({
  imports: [
    BrowserModule, FormsModule,
    RouterModule.forRoot(
        appRoutes, {enableTracing: true}  // <-- debugging purposes only
        ),
    NgbModule
  ],
  declarations: [
    AppComponent, LoginComponent, NavbarComponent, HomeComponent, ApuestasComponent, PrediccionComponent, PartidoComponent, FixtureComponent, PartidoFixtureComponent,
    LeaderboardComponent,
    FixtureAdminComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}