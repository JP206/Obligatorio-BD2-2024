import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-apuestas',
  templateUrl: './apuestas.component.html',
  styleUrls: ['./apuestas.component.css']
})
export class ApuestasComponent implements OnInit {

  constructor() { }


  ngOnInit() {
    //this.getApuestas();
  }

  getWindmill(): void {
    /*this.windmillService.getPendingWindmills()
    .subscribe(windmills => this.pendingWindmills = windmills);
    this.windmillService.getApprovedWindmills()
    .subscribe(windmills => this.approvedWindmills = windmills);
    this.windmillService.getDeniedWindmills()
    .subscribe(windmills => this.deniedWindmills = windmills);
  */
  }

}
