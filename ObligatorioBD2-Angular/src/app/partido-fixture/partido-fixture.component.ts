import { Component, OnInit, Input } from '@angular/core';
import { Partido } from '../partido';
import { Equipo } from '../equipo';

@Component({
  selector: 'app-partido-fixture',
  templateUrl: './partido-fixture.component.html',
  styleUrls: ['./partido-fixture.component.css']
})
export class PartidoFixtureComponent implements OnInit {
  @Input() partido: Partido | undefined;
  @Input() formularios: boolean = false;
  @Input() admin: boolean = false;
  habilitado: boolean = true;
  equipos: Equipo[] = [];

  constructor() { }

  ngOnInit(): void {
    if (this.partido) {
      const now = new Date();
      const partidoFecha = new Date(this.partido.fecha);
      const diff = (partidoFecha.getTime() - now.getTime()) / 60000; // diferencia en minutos

      if (diff < 60) {
        this.habilitado = false;
      }
    }
  }

  openModal(grupo: string) {
    const modal = document.getElementById(`Modal`);
    if (modal) {
    modal.style.display = "block";}
  }

  closeModal() {
    const modal = document.getElementById(`Modal`);
    if (modal) {
    modal.style.display = "none";}
  }

  
}
