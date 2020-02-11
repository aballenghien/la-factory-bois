import { Component, OnInit } from '@angular/core';
import { CategorieService } from '../service/categorie.service';
import { Categorie } from '../model/categorie';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private srvCategorie: CategorieService, private app: AppComponent) { }

  ngOnInit() {
  }
  // GET CATEGORIE MERE
  // ...
  public catMere : Categorie = new Categorie(0, "avion");

  public sousCategories : Array<Categorie> = this.srvCategorie.findByCategorie(this.catMere);
  
}
