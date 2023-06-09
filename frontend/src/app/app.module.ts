import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { MangaComponent } from "./manga/manga.component";

import { AnimeModule } from './anime/anime.module';
import {RouterModule} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import { SectionComponent } from './section/section.component';
import { MangaDetailsComponent } from './manga-details/manga-details.component';
import {NgxPaginationModule} from "ngx-pagination";




@NgModule({
  declarations: [
    AppComponent,
    LandingPageComponent,
    MangaComponent,
    SectionComponent,
    MangaDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    AnimeModule,
    HttpClientModule,
    NgxPaginationModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
