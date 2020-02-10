import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {AppConfigService} from '../service//app-config.service'
import { Etape } from '../model/Etape'
import { Modele } from '../model/Modele'


@Injectable({
  providedIn: 'root'
})
export class EtapeService {
  public etapes:Array<Etape> =null;

  constructor(private http: HttpClient, private srvAppConfig: AppConfigService) { }

  
if(Modele.id != 0){
  this.http.get<Array<Etape>>(`${this.srvAppConfig.url}etape`).subscribe(resp => this.etapes = resp );
}


public findAll() : Array<Etape>{
  this.http.get<Array<Etape>>(`${this.srvAppConfig.url}etape`).subscribe(resp => this.etapes = resp );
  return this.etapes;
}





}
