import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AppConfigService } from '../service/app-config.service';
import { ModeleService } from '../service/modele.service';
import { Modele } from '../model/modele';
import { Niveau } from '../model/niveau';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-modele',
  templateUrl: './modele.component.html',
  styleUrls: ['./modele.component.css']
})
export class ModeleComponent implements OnInit {

  public modele : Modele ;
  public modeles : Array<Modele>;
  private categorieId : number;
  private niveau : Niveau ;

  constructor(private router : Router, private service : AppConfigService, private http : HttpClient, private route : ActivatedRoute) { 

   
    
  }

  ngOnInit() {

    this.route.params.subscribe(params => {
      this.categorieId=params["id"];

      this.niveau=params["niveau"];
     
  
      if (this.niveau == null){
        this.http.get<Array<Modele>>(this.service.url + 'modele/categorie/' + this.categorieId).subscribe(resp => this.modeles=resp);
      }
  
      
  
      if (this.categorieId != null && this.niveau != null){
        this.http.get<Array<Modele>>(this.service.url + 'modele/categorie/' + this.categorieId + '/niveau/' + this.niveau).subscribe(resp => this.modeles = resp)
  
      }
    });
  }

  

}
