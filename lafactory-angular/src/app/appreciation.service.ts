import { Injectable, Inject } from '@angular/core';
import { AppConfigService } from './service/app-config.service';
import { HttpClient } from '@angular/common/http';
import { Appreciation } from './model/appreciation';
import { StorageSessionServiceService } from './storage-session-service.service';

@Injectable({
  providedIn: 'root'
})
export class AppreciationService {

  constructor(private srv: AppConfigService, private http: HttpClient,    
    private storageSessionService: StorageSessionServiceService) { }

  public save(appreciation: Appreciation): void {
    if(appreciation.id >0){
      this.http
      .put<Appreciation>(this.srv.url+"appreciation/modifier/"+appreciation.id, appreciation)
      .subscribe(resp => this.storageSessionService.set("appreciation-enregistree",resp));
    }else{
      this.http
      .post<Appreciation>(this.srv.url+"appreciation/ajouter", appreciation)
      .subscribe(resp => this.storageSessionService.set("appreciation-enregistree",resp));
    }
  }
}
