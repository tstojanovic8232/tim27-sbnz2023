
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingPageComponent } from "./landing-page/landing-page.component";
import { MangaComponent } from "./manga/manga.component";


import {BasicHomePageComponent} from "./anime/pages/basic-home-page/basic-home-page.component";
import {LoginComponent} from "./anime/components/login/login.component";
import {BasicAnimePagesComponent} from "./anime/pages/basic-anime-pages/basic-anime-pages.component";
import {BrowseComponent} from "./anime/components/browse/browse.component";
import {AboutComponent} from "./anime/components/about/about.component";


const routes: Routes = [
  {
    path: '', component: LandingPageComponent
  },
  {

    path: 'manga', component: MangaComponent
  },
  {
    path: 'anime', component: LandingPageComponent,

    // path: 'home', redirectTo: '', pathMatch: "full"
  },
  {
    path: 'manga', component: MangaComponent
  },
  {
    path: 'signup', component: LoginComponent
  },
  {
    path: 'login', component: LoginComponent
  },
  {
    path: 'anime', component:BasicAnimePagesComponent, children:
      [
        {
          path: '', component: BasicHomePageComponent
        },
        {
          path: 'browse', component: BrowseComponent
        },
        {
          path: 'about', component: AboutComponent
        },
      ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
