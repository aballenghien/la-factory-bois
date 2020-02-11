import { Component } from '@angular/core';
import { Categorie } from './model/categorie';
import { Niveau } from './model/niveau';
import { Router } from '@angular/router';
import { CategorieService } from './service/categorie.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'lafactory-angular';

  constructor (private router: Router, private srvCategorie: CategorieService) {
    this.srvCategorie.findCategoriesNiv1();
  }

  private categorie: Categorie = new Categorie(1);
  private categories: Array<Categorie>;

  public niveau: string = "Difficulté";
  public niveaux = Object.values(Niveau);

  private afficherModeles() {
    if (this.niveau === "Difficulté") {
      this.router.navigate(['/modele' , this.categorie.id]);
    }
    else {
      this.router.navigate(['/modele', this.categorie.id, this.niveau]);
    }
  }
}
