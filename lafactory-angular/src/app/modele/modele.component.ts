import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AppConfigService } from '../service/app-config.service';
import { ModeleService } from '../service/modele.service';
import { Modele } from '../model/modele';
import { Niveau } from '../model/niveau';
import { HttpClient } from '@angular/common/http';
import { Categorie } from '../model/categorie';
import { CategorieService } from '../service/categorie.service';

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
  private catMere : Categorie;
  public sousCategories : Array<Categorie>;

  constructor(private router : Router, private service : AppConfigService, private http : HttpClient, private route : ActivatedRoute, private srvCategorie: CategorieService) { 

   
    
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

     // GET CATEGORIE MERE
  // ...
  this.http.get<Categorie>(this.service.url + 'categorie/categorie/' +this.categorieId).subscribe(resp => {
    this.catMere=resp;
    this.sousCategories= this.srvCategorie.findByCategorie(this.catMere);
  });
   
   
  }
  

  public allerModele(modele : Modele) : void {
    this.router.navigate(['/modele', modele.id]);
  }

  
  

}
