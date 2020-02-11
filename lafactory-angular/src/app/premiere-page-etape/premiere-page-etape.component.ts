import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ModeleService } from '../service/modele.service';
import { Modele } from '../model/modele';


@Component({
  selector: 'app-premiere-page-etape',
  templateUrl: './premiere-page-etape.component.html',
  styleUrls: ['./premiere-page-etape.component.css']
})
export class PremierePageEtapeComponent implements OnInit {

  private id: number;
  private modele: Modele; 
  constructor(private route:ActivatedRoute, private srvModele: ModeleService, private router:Router) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.id=params["id"];
    });
    
    this.srvModele.findByIdWithAppreciation(this.id);
  }

  public allerEtape(modele : Modele) : void {
    this.router.navigate(['/etape/', modele.id]);
  }

}
