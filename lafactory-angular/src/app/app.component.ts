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
    this.categories = this.srvCategorie.findCategoriesNiv1();
  }

  private categorie: Categorie;
  private categories: Array<Categorie>;

  public niveau: string;

  private afficherModeles() {
    alert(this.categories.length);
    if (!this.niveau) {
      alert("ici");
      this.router.navigate(['/modele' , this.categorie.id]);
    }
    else {
      this.router.navigate(['/modele', this.categorie.id, this.niveau]);
    }
  }
}
