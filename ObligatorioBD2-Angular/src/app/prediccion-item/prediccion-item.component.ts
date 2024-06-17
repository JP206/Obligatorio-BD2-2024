import { Component, Input, OnInit } from '@angular/core';
import { Partido } from '../partido';
import { Time } from '@angular/common';
import { EquipoService } from '../equipo.service';
import { PartidoService } from '../partido.service';
import { Equipo } from '../equipo';
import { Prediccion } from '../prediccion';
import { PrediccionService } from '../prediccion.service';
@Component({
  selector: 'app-prediccion-item',
  templateUrl: './prediccion-item.component.html',
  styleUrls: ['./prediccion-item.component.css']
})
export class PrediccionItemComponent implements OnInit {
  @Input() prediccion: Prediccion | undefined;
  equipos: Equipo[] = [];
  errorMessage: string = '';
  habilitado : boolean = true; // TODO VERIFICAR SI TODAVIA SE PUEDE CAMBIAR
  constructor(private equipoService: EquipoService, private prediccionService: PrediccionService) { }

  ngOnInit(): void {
    this.equipoService.getEquipos().subscribe(
      (data: Equipo[]) => {
        this.equipos = data;
      },
      (error) => {
        console.error('Error fetching equipos:', error);
        this.errorMessage = 'Hubo un error al cargar los equipos.';
      }
    );
  }

  obtenerBanderaPorNombreEquipo(nombreEquipo: string): string {
    const equipo = this.equipos.find(e => e.nombre === nombreEquipo);
    return equipo ? equipo.bandera : '';
  }

  actualizar() {
    // this.prediccionService.actualizarPrediccion() TODO
  }
}
