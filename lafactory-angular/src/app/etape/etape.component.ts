import { Component, OnInit } from '@angular/core';
import {AppConfigService} from '../service//app-config.service'
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { ModeleService } from '../service/modele.service';


@Component({
  selector: 'app-etape',
  templateUrl: './etape.component.html',
  styleUrls: ['./etape.component.css']
})
export class EtapeComponent implements OnInit {
private idModele: number;
  constructor(private route:ActivatedRoute, private modeleService:ModeleService) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.idModele=params["id"];
    });
    this.modeleService.findById(this.idModele);
  }

}
