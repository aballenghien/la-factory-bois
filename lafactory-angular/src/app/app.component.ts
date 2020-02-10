import { Component } from '@angular/core';
import { Categorie } from './model/categorie';
import { Niveau } from './model/niveau';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'lafactory-angular';

  constructor (private router: Router) {}

  private categories: Array<Categorie> = [
    new Categorie(1, "cat1"),
    new Categorie(2, "cat2")
];

  private niveau: Niveau;

  private afficherTuto() {
    this.router.navigate(['/tutoriel']);
  }
}
