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
  public myOptions: Object = this.srvAppConfig.security();

  public save (visiteur : Visiteur):void{
    console.log(visiteur);
      this.httpClient
        .post<Visiteur>(`${ this.srvAppConfig.url + 'visiteur' }`, visiteur, this.myOptions)
        .subscribe(resp => this.visiteurs.push(resp));
  }
}
