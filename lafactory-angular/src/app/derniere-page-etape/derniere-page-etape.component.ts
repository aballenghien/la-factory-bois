import { Component, OnInit } from '@angular/core';
import { Modele } from '../model/modele';
import { Appreciation } from '../model/appreciation';
import { ActivatedRoute } from '@angular/router';
import { ModeleService } from '../service/modele.service';

@Component({
  selector: 'app-derniere-page-etape',
  templateUrl: './derniere-page-etape.component.html',
  styleUrls: ['./derniere-page-etape.component.css']
})
export class DernierePageEtapeComponent implements OnInit {

  public appreciation:Appreciation;
  public modele:Promise<Modele>;
  private idModele:number;
  constructor(private route: ActivatedRoute, public modeleService:ModeleService) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.idModele=params["id"];
      alert(this.idModele);
    });
    this.modele = this.modeleService.findById(this.idModele);
  }

  public enregistrerAppreciation(){
  
  }

}
