import { Component, OnInit, SystemJsNgModuleLoader } from '@angular/core';
import { Idee } from '../model/idee';
import { IdeeService } from '../service/idee.service';
import { Visiteur } from '../model/visiteur';
import { VisiteurService } from '../service/visiteur.service';
import { HttpClient } from '@angular/common/http';
import { AppConfigService } from '../service/app-config.service';

@Component({
  selector: 'app-idees',
  templateUrl: './idees.component.html',
  styleUrls: ['./idees.component.css']
})
export class IdeesComponent implements OnInit {

  constructor(private httpClient : HttpClient, private ideeService: IdeeService, private visiteurService : VisiteurService, private srvAppConfig: AppConfigService) { }
  public idees: Array<Idee> = null;
  public visiteurs: Array<Visiteur> = null;
  ngOnInit() {

    this.httpClient
    .get<Array<Idee>>(`${ this.srvAppConfig.url + 'idee' }`)
    .subscribe(resp =>
    this.idees = resp
    );

    this.visiteurs = this.visiteurService.findAll();

  }




  private idee : Idee = new Idee();
  private visiteur : Visiteur = new Visiteur();

  public envoyerIdee():void {
    this.visiteurService.save(this.visiteur);
    // this.idee.utilisateur.id = this.visiteurService.findLast().id;
    this.idee.visiteur = this.visiteurService.findLast();
    this.ideeService.send(this.idee);
    this.idee = new Idee();
    alert("Merci " + `${ this.visiteur.prenom }` +", votre idée à bien été reçue !");
  }

}
