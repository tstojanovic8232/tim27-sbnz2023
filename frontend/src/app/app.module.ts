import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { MangaComponent } from "./manga/manga.component";

import { AnimeModule } from './anime/anime.module';
import {RouterModule} from "@angular/router";




@NgModule({
  declarations: [
    AppComponent,
    LandingPageComponent,
    MangaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    AnimeModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
