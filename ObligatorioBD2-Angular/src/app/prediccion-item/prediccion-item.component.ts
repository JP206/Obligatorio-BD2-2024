import { Component, Input, OnInit } from '@angular/core';
import { Partido } from '../partido';
import { Time } from '@angular/common';
import { EquipoService } from '../equipo.service';
import { PartidoService } from '../partido.service';
import { Equipo } from '../equipo';
import { Prediccion } from '../prediccion';
import { PrediccionService } from '../prediccion.service';
import { PrediccionCrear } from '../prediccion_crear';
@Component({
  selector: 'app-prediccion-item',
  templateUrl: './prediccion-item.component.html',
  styleUrls: ['./prediccion-item.component.css']
})
export class PrediccionItemComponent implements OnInit {
  @Input() prediccion: Prediccion | undefined;
  prediccionCrear: PrediccionCrear | undefined;
  equipos: Equipo[] = [];

  usuario: string = "juan@gmail.com"; // TODO QUE OBTENGA EL NOMBRE DE LOCALSTORAGE O NO SE.
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
    if (this.prediccion) {
      const now = new Date();
      const fechaHoraString = `${this.prediccion.fecha}T${this.prediccion.hora}`;
      const prediccionFecha = new Date(fechaHoraString);
      const diff = (prediccionFecha.getTime() - now.getTime()) / 60000; // diferencia en minutos

      if (diff < 60) {
        this.habilitado = false;
      }
    }
  }

  obtenerBanderaPorNombreEquipo(nombreEquipo: string): string {
    const equipo = this.equipos.find(e => e.nombre === nombreEquipo);
    return equipo ? equipo.bandera : '';
  }

  actualizar() {
    if (this.prediccion) {
      console.log('entro')
      this.prediccionCrear = {
        correoUsuario: this.usuario,
        prediccionEquipo1: this.prediccion.prediccionEquipo1,
        prediccionEquipo2: this.prediccion.prediccionEquipo2,
        equipo1: this.prediccion.equipo1,
        equipo2: this.prediccion.equipo2
      }
    }
    if (this.prediccionCrear) {
      console.log(this.prediccionCrear)
      this.prediccionService.actualizarPrediccion(this.prediccionCrear).subscribe(
        (data: Boolean) => {
          console.log('Se actualizo la predicción: ', data);
        },
        (error) => {
          console.error('Error fetching partidos:', error);
          this.errorMessage = 'Hubo un error al cargar los partidos.';
        }
      );
    }
  }
}
