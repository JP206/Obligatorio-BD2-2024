import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
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
  @Output() elegirEquipo: EventEmitter<{ idPartido: string, equipo: number }> = new EventEmitter<{ idPartido: string, equipo: number }>();

  emitEvent(equipo: number) {
    console.log('emitio evento')
    if (this.partido) {
      console.log('se aplico')
      this.elegirEquipo.emit({ idPartido: this.partido?.id, equipo: equipo });
    }
  }

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
}
