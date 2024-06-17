import { Component, OnInit, Input } from '@angular/core';
import { Partido } from '../partido';
import { PrediccionService } from '../prediccion.service';
import { Prediccion } from '../prediccion';
import { PrediccionCrear } from '../prediccion_crear';
@Component({
  selector: 'app-partido',
  templateUrl: './partido.component.html',
  styleUrls: ['./partido.component.css']
})
export class PartidoComponent implements OnInit {
  @Input() partido: Partido | undefined;
  @Input() formularios: boolean = false;
  
  prediccionEquipo1: number = 0;
  prediccionEquipo2: number = 0;
  prediccion: PrediccionCrear | undefined;
  usuario: string = "juan@gmail.com";

  habilitado: boolean = true;
  errorMessage: string = "";

  constructor(private prediccionService: PrediccionService) { }

  ngOnInit(): void {
    if (this.partido) {
      const now = new Date();
      const fechaHoraString = `${this.partido.fecha}T${this.partido.hora}`;
      const partidoFecha = new Date(fechaHoraString);
      const diff = (partidoFecha.getTime() - now.getTime()) / 60000; // diferencia en minutos

      if (diff < 60) {
        this.habilitado = false;
      }
    }
  }
  
  apostar(): void {
    if(this.partido && this.partido.equipo1 && this.partido?.equipo2) {
      this.prediccion = {
        correoUsuario: this.usuario,
        prediccionEquipo1: this.prediccionEquipo1,
        prediccionEquipo2:  this.prediccionEquipo2,
        equipo1: this.partido.equipo1,
        equipo2:  this.partido.equipo2
      }
      this.prediccionService.crearPrediccion(this.prediccion).subscribe(
        (data: Boolean) => {
          console.log('se creo la prediccion: ', data);
        },
        (error) => {
          console.error('Error fetching prediccion:', error);
          this.errorMessage = 'Hubo un error al crear la prediccion.';
        }
      );
    }
  }
  
}

