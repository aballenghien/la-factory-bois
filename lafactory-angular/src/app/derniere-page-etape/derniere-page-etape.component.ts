import { Component, OnInit, Inject } from '@angular/core';
import { Modele } from '../model/modele';
import { Appreciation } from '../model/appreciation';
import { ActivatedRoute } from '@angular/router';
import { ModeleService } from '../service/modele.service';
import { AppreciationService } from '../appreciation.service';
import { StorageSessionServiceService } from '../storage-session-service.service';

@Component({
  selector: 'app-derniere-page-etape',
  templateUrl: './derniere-page-etape.component.html',
  styleUrls: ['./derniere-page-etape.component.css']
})
export class DernierePageEtapeComponent implements OnInit {

  public appreciation: Appreciation;
  public modele: Modele;
  private idModele: number;

  constructor(private route: ActivatedRoute,
    public modeleService: ModeleService,
    public appreciationService: AppreciationService,
    private storageSessionService: StorageSessionServiceService
  ) {
    this.appreciation = new Appreciation();
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.idModele = params["id"];
    });
    this.modeleService.findById(this.idModele);
  }

  public enregistrerAppreciation() {
    let appreciationSession: Appreciation = this.storageSessionService.get("appreciation-enregistree");
    if (!appreciationSession) {
      this.appreciation.dateCommentaire = new Date();
      this.appreciation.modele = this.modeleService.modele;
    } else {
      this.appreciation.id = appreciationSession.id;
    }
    this.appreciationService.save(this.appreciation);
  }

}
