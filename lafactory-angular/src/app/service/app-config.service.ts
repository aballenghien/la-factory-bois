import { Injectable } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AppConfigService {

  public url: string = "http://localhost:8080/api/"

  constructor() { }

  public security(): Object {
    let myHeaders: HttpHeaders = new HttpHeaders();
    myHeaders = myHeaders.append('Authorization', 'Basic ' + btoa('visiteur:123'));
    let myOptions: Object = { headers: myHeaders };

    return myOptions;
  }
}
