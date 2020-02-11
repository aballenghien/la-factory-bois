import { Injectable } from '@angular/core';
import {Modele} from './model/modele';
import { AppConfigService } from './service/app-config.service';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Categorie } from './model/categorie';
import { Niveau } from './model/niveau';

@Injectable({
  providedIn: 'root'
})
export class ModeleService {

  public modele : Modele ;
  public modeles : Array<Modele>;
  private categorieId : number;
  private niveau : Niveau ;

  constructor(private service : AppConfigService, private http : HttpClient, private route : ActivatedRoute) {
    
    this.route.queryParams.subscribe(params => {
      this.categorieId = params['id'];
      console.log(this.categorieId);

      if (params['niveau'] != null) {
      this.niveau = params['niveau'];
      console.log(this.niveau);
      }
    });

    if (this.niveau == null){
      this.http.get<Array<Modele>>(service.url + 'modele/categorie/' + this.categorieId).subscribe(resp => this.modeles=resp);
      alert("ok");
    }

   

    if (this.categorieId != null && this.niveau != null){
      this.http.get<Array<Modele>>(service.url + 'modele/categorie/' + this.categorieId + '/niveau/' + this.niveau).subscribe(resp => this.modeles = resp)

    }

   }

   ngOnInit() {
     
  }
}
