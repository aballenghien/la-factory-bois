import { Component, OnInit, Inject } from '@angular/core';
import { Modele } from '../model/modele';
import { Appreciation } from '../model/appreciation';
import { ActivatedRoute } from '@angular/router';
import { ModeleService } from '../service/modele.service';
import { AppreciationService } from '../service/appreciation.service';
import { StorageSessionServiceService } from '../service/storage-session-service.service';

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
    this.appreciation.modele = this.modeleService.modele;
    if (!appreciationSession) {
      this.appreciation.dateCommentaire = new Date();
    } else {
      if (this.appreciation.modele.id === appreciationSession.modele.id && this.appreciation.pseudo === appreciationSession.pseudo) {
        this.appreciation.id = appreciationSession.id;
      }else{        
        this.appreciation.dateCommentaire = new Date();
      }
    }
    this.appreciationService.save(this.appreciation);
  }

}
