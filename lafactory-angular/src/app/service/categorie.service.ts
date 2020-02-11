import { Injectable } from '@angular/core';
import { AppConfigService } from './app-config.service';
import { HttpClient } from '@angular/common/http';
import { Categorie } from '../model/categorie';

@Injectable({
  providedIn: 'root'
})
export class CategorieService {

  public categories: Array<Categorie> = [];
  public categorie: Categorie;
  public myOptions: Object = this.srv.security();

  constructor(private srv: AppConfigService, private http: HttpClient) { }

  public findAll(): Array<Categorie> {
    this.http
      .get<Array<Categorie>>(this.srv.url + 'categorie', this.myOptions)
      .subscribe(resp =>
        this.categories = resp);
    return this.categories;
  }

  public findCategoriesNiv1(): Array<Categorie> {
    this.http
      .get<Array<Categorie>>(this.srv.url + 'categorie/1', this.myOptions)
      .subscribe(resp =>
        this.categories = resp);
    return this.categories;
  }

  public findByCategorie(categorie: Categorie): Array<Categorie> {
    this.http
      .get<Array<Categorie>>(this.srv.url + 'categorie/' + categorie.id, this.myOptions)
      .subscribe(resp =>
        this.categories = resp);
    return this.categories;
  }
}
