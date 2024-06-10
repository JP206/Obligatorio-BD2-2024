import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Equipo } from '../equipo';

@Component({
  selector: 'app-equipo',
  templateUrl: './equipo.component.html',
  styleUrls: ['./equipo.component.css']
})
export class EquipoComponent implements OnInit {
  @Input() equipo: Equipo | undefined;
  @Output() seleccionarEquipo: EventEmitter<string> = new EventEmitter<string>();

  emitEvent() {
    console.log('emitio evento')
    if (this.equipo) {
      console.log('se aplico')
      this.seleccionarEquipo.emit(this.equipo.id);
    }
  }

  constructor() { }

  ngOnInit(): void {
  }

  seleccionar() {

  }

}
