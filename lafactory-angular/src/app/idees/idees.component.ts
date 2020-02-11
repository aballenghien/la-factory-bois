/*import { Component, OnInit } from '@angular/core';
import { Idee } from '../model/idee';
import { IdeeService } from '../service/idee.service';
import { Visiteur } from '../model/visiteur';
import { VisiteurService } from '../service/visiteur.service';

@Component({
  selector: 'app-idees',
  templateUrl: './idees.component.html',
  styleUrls: ['./idees.component.css']
})
export class IdeesComponent implements OnInit {
  
  constructor(private ideeService: IdeeService, private visiteurService : VisiteurService) { }

  ngOnInit() {
  }

  private idee : Idee = new Idee();
  private visiteur : Visiteur = new Visiteur();

  public envoyerIdee():void {
    this.visiteurService.save(this.visiteur);
    this.idee.utilisateur.id = this.visiteur.id;
    this.ideeService.send(this.idee);
    this.idee = new Idee();
  }

}
*/