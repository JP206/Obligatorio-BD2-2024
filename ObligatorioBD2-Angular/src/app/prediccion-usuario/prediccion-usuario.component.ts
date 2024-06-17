import { Component, OnInit } from '@angular/core';
import { Prediccion } from '../prediccion';
import { PrediccionService } from '../prediccion.service';
import { Equipo } from '../equipo';
import { EquipoService } from '../equipo.service';

@Component({
  selector: 'app-prediccion-usuario',
  templateUrl: './prediccion-usuario.component.html',
  styleUrls: ['./prediccion-usuario.component.css']
})
export class PrediccionUsuarioComponent implements OnInit {
  predicciones: Prediccion[] = [];
  usuario: string = "juan@gmail.com"; // TODO QUE OBTENGA EL NOMBRE DE LOCALSTORAGE O NO SE.
  errorMessage: string = "";
  equipos: Equipo[] = [];
  puntajeTotal: number = 0;
  constructor(private prediccionService: PrediccionService, private equipoService: EquipoService) { }

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
    this.prediccionService.getPredicciones(this.usuario).subscribe( 
      (data: Prediccion[]) => {
        for (const prediccion of data) {
          if (prediccion.equipo1 && prediccion.equipo2) {
            prediccion.imagenEquipo1 = this.obtenerBanderaPorNombreEquipo(prediccion.equipo1);
            prediccion.imagenEquipo2 = this.obtenerBanderaPorNombreEquipo(prediccion.equipo2);
          }
          if (prediccion.puntaje) {
            this.puntajeTotal += prediccion.puntaje;
          }
        }
        this.predicciones = data;
        console.log('Se obtuvo esta data de predicciones: ', data)
      },
      (error) => {
        console.error('Error fetching predicciones:', error);
        this.errorMessage = 'Hubo un error al cargar las predicciones.';
      }
    );
  }

  obtenerBanderaPorNombreEquipo(nombreEquipo: string): string {
    const equipo = this.equipos.find(e => e.nombre === nombreEquipo);
    return equipo ? equipo.bandera : '';
  }

}
