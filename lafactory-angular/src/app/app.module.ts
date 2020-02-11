import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router'
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { IdeesComponent } from './idees/idees.component';
import { ModeleComponent } from './modele/modele.component';
import { PremierePageEtapeComponent } from './premiere-page-etape/premiere-page-etape.component';
import { EtapeComponent } from './etape/etape.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'idees', component: IdeesComponent },
  { path: 'modeles/:id', component: ModeleComponent },
  { path: 'modeles/:id/:niveau', component: ModeleComponent },
  { path: 'premiere-page-etape', component: PremierePageEtapeComponent },
  { path : 'etape/:id', component: EtapeComponent},
  { path: '', redirectTo: 'home', pathMatch: 'full' }
  
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    IdeesComponent,
    ModeleComponent,
    PremierePageEtapeComponent
    EtapeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
