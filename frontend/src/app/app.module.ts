import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { MangaComponent } from "./manga/manga.component";
import {SignupComponent} from './signup/signup.component';

import { AnimeModule } from './anime/anime.module';
import {Router, RouterModule} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import { SectionComponent } from './section/section.component';
import { MangaDetailsComponent } from './manga-details/manga-details.component';
import {NgxPaginationModule} from "ngx-pagination";
import { NavbarmangaComponent } from './navbarmanga/navbarmanga.component';
import { BrowseMangaComponent } from './browse-manga/browse-manga.component';
import {FormsModule} from "@angular/forms";
import {LoginComponent} from "./login/login.component";







@NgModule({
  declarations: [
    AppComponent,
    LandingPageComponent,
    MangaComponent,
    SignupComponent,
    SectionComponent,
    MangaDetailsComponent,
    NavbarmangaComponent,
    BrowseMangaComponent,
    LoginComponent

  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        RouterModule,
        HttpClientModule,
        NgxPaginationModule,
        FormsModule


    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
