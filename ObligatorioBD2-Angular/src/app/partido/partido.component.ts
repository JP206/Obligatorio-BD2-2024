import { Component, OnInit, Input } from '@angular/core';
import { Partido } from '../partido';
import { PrediccionService } from '../prediccion.service';

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

  habilitado: boolean = true;

  constructor(private prediccionService: PrediccionService) { }

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
  
  apostar(): void {
    //prediccionService.crearPrediccion(prediccionEquipo1, prediccionEquipo2)
  }
}

