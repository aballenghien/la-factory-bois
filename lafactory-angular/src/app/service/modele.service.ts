import { Injectable } from '@angular/core';
import { AppConfigService } from './app-config.service';
import { HttpClient } from '@angular/common/http';
import { Modele } from '../model/modele';

@Injectable({
  providedIn: 'root'
})
export class ModeleService {

  public modeles: Array<Modele> = [];
  public modele: Modele;
  public myOptions: Object = this.srv.security();

  constructor(private srv: AppConfigService, private http: HttpClient) { }

  public findAll(): Array<Modele> {
    this.http
      .get<Array<Modele>>(this.srv.url + 'modele', this.myOptions)
      .subscribe(resp =>
        this.modeles = resp);
    return this.modeles;
  }

  public findByCategorie(): Array<Modele> {
    this.http
      .get<Array<Modele>>(this.srv.url + 'modele', this.myOptions)
      .subscribe(resp =>
        this.modeles = resp);
        return this.modeles;
  }

  public findByDifficulte(): Array<Modele> {
    this.http
      .get<Array<Modele>>(this.srv.url + 'modele', this.myOptions)
      .subscribe(resp =>
        this.modeles = resp);
        return this.modeles;
  }

  public findById(id: number): Modele {
    this.http
      .get<Modele>(this.srv.url+'modele/'+id, this.myOptions)
      .subscribe(resp => this.modele = resp);
    return this.modele;
  }

  
  public nombreEtapes(): number {
    return this.modele.etapes.length;
  }
}
