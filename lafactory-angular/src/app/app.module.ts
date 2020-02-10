import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router'
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { IdeesComponent } from './idees/idees.component';
import { DernierePageEtapeComponent } from './derniere-page-etape/derniere-page-etape.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'idees', component: IdeesComponent },
  { path: 'derniere-page-tuto/:id', component: DernierePageEtapeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    IdeesComponent,
    DernierePageEtapeComponent
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
