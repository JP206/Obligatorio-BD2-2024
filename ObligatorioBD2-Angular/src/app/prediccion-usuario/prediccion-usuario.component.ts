import { Component, OnInit } from '@angular/core';
import { Prediccion } from '../prediccion';
import { PrediccionService } from '../prediccion.service';

@Component({
  selector: 'app-prediccion-usuario',
  templateUrl: './prediccion-usuario.component.html',
  styleUrls: ['./prediccion-usuario.component.css']
})
export class PrediccionUsuarioComponent implements OnInit {
  predicciones: Prediccion[] = [];
  usuario: string = "juan"; // TODO QUE OBTENGA EL NOMBRE DE LOCALSTORAGE O NO SE.
  errorMessage: string = "";
  constructor(private prediccionService: PrediccionService) { }

  ngOnInit(): void {
    this.prediccionService.getPredicciones(this.usuario).subscribe( 
      (data: Prediccion[]) => {
        this.predicciones = data;
      },
      (error) => {
        console.error('Error fetching equipos:', error);
        this.errorMessage = 'Hubo un error al cargar los equipos.';
      }
    );
  }

}
