/*import { Idee } from '../model/idee';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppConfigService } from './app-config.service';

@Injectable({
  providedIn: 'root'
})
export class IdeeService {

  constructor(private httpClient : HttpClient, private srvAppConfig: AppConfigService) { }

  public idees: Array<Idee> = null;
  // private idee : Idee = new Idee();

  public send (idee : Idee):void{
    console.log(idee);
      this.httpClient
        .post<Idee>(`${ this.srvAppConfig.url + 'idee' }`, idee)
        .subscribe(resp => this.idees.push(resp));
  }
}*/