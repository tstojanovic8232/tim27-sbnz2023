import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { MangaComponent } from "./manga/manga.component";
import { RouterModule } from "@angular/router";

@NgModule({
  declarations: [
    AppComponent,
    LandingPageComponent,
    MangaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule // Add RouterModule here
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
