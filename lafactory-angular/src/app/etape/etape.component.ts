import { Component, OnInit } from '@angular/core';
import {AppConfigService} from '../service//app-config.service'
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { ModeleService } from '../service/modele.service';
import { Modele } from '../model/modele'


@Component({
  selector: 'app-etape',
  templateUrl: './etape.component.html',
  styleUrls: ['./etape.component.css']
})
export class EtapeComponent implements OnInit {
private idModele: number;
  constructor(private route:ActivatedRoute, private modeleService:ModeleService, private router:Router) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.idModele=params["id"];
    });
    this.modeleService.findById(this.idModele);
  }

  public allerModeleDerPage(modele : Modele) : void {
    this.router.navigate(['/derniere-page-tuto/', modele.id]);
  }

}
