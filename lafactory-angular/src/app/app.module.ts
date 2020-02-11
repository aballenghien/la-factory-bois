import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router'
import { HttpClientModule } from '@angular/common/http';
import { StorageServiceModule, SESSION_STORAGE } from 'angular-webstorage-service';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { IdeesComponent } from './idees/idees.component';
import { ModeleComponent } from './modele/modele.component';
import { PremierePageEtapeComponent } from './premiere-page-etape/premiere-page-etape.component';
import { DernierePageEtapeComponent } from './derniere-page-etape/derniere-page-etape.component';

import { SERVICE_SESSION_STORAGE, StorageSessionServiceService } from './storage-session-service.service';
 

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'idees', component: IdeesComponent },
  { path: 'derniere-page-tuto/:id', component: DernierePageEtapeComponent },
  { path: 'modeles/:id/:niveau', component: ModeleComponent },
  { path: 'modeles/:id', component: ModeleComponent },
  { path: 'premiere-page-etape', component: PremierePageEtapeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ModeleComponent,
    PremierePageEtapeComponent,
    DernierePageEtapeComponent,
    IdeesComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    StorageServiceModule
  ],
  providers: [{ 
    provide: SERVICE_SESSION_STORAGE, useExisting: SESSION_STORAGE },
    StorageSessionServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
