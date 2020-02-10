import { Injectable } from '@angular/core';
import { Visiteur } from '../model/visiteur';
import { HttpClient } from '@angular/common/http';
import { AppConfigService } from './app-config.service';

@Injectable({
  providedIn: 'root'
})
export class VisiteurService {

  constructor(private httpClient : HttpClient, private srvAppConfig: AppConfigService) { }

  public visiteurs: Array<Visiteur> = null;

  public findAll(): Array<Visiteur> {
    this.httpClient
    .get<Array<Visiteur>>(`${ this.srvAppConfig.url + 'visiteur' }`)
    .subscribe(resp =>
    this.visiteurs = resp
    );
      return this.visiteurs;
  }
  private visiteur : Visiteur = new Visiteur();
  public lastVisiteur : Visiteur;

  public findLast (): Visiteur{
    this.httpClient
        .get<Visiteur>( this.srvAppConfig.url + 'visiteur/last')
        .subscribe(resp => this.lastVisiteur = resp);

        return this.lastVisiteur;
  }

  public save (visiteur : Visiteur):void{
    console.log(visiteur);
      this.httpClient
        .post<Visiteur>(`${ this.srvAppConfig.url + 'visiteur' }`, visiteur)
        .subscribe(resp => this.visiteurs.push(resp));
  }
}
