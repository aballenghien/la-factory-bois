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

  constructor(private srv: AppConfigService, private http: HttpClient) { }

  public findAll(): Array<Modele> {
    this.http
      .get<Array<Modele>>(this.srv.url + 'modele')
      .subscribe(resp =>
        this.modeles = resp);
    return this.modeles;
  }

  public findByCategorie(): Array<Modele> {
    this.http
      .get<Array<Modele>>(this.srv.url + 'modele')
      .subscribe(resp =>
        this.modeles = resp);
        return this.modeles;
  }

  public findByDifficulte(): Array<Modele> {
    this.http
      .get<Array<Modele>>(this.srv.url + 'modele')
      .subscribe(resp =>
        this.modeles = resp);
        return this.modeles;
  }

  public findById(id: number): Modele {
    this.http
      .get<Modele>(this.srv.url+'modele/'+id)
      .subscribe(resp => this.modele=resp);
    return this.modele;
  }
  public findByIdWithAppreciation(id: number): Modele {
    this.http
      .get<Modele>(this.srv.url+'modele/appreciation/'+id)
      .subscribe(resp => {
        
        this.modele = resp
        let noteMoy = 0;
        let nbNote = 0;
        for ( let a of this.modele.appreciations) {
          noteMoy += a.note;
          nbNote++;
        }
        this.modele.noteMoy=noteMoy/nbNote;

      });
    return this.modele;
  }

  
  public nombreEtapes(): number {
    return this.modele.etapes.length;
  }
}
