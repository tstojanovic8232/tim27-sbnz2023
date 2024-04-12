import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LandingPageComponent} from "./landing-page/landing-page.component";
import {MangaComponent} from "./manga/manga.component";

import {BasicHomePageComponent} from "./anime/pages/basic-home-page/basic-home-page.component";


import {BasicAnimePagesComponent} from "./anime/pages/basic-anime-pages/basic-anime-pages.component";
import {BrowseComponent} from "./anime/components/browse/browse.component";
import {AboutComponent} from "./anime/components/about/about.component";
import {MangaDetailsComponent} from "./manga-details/manga-details.component";
import {BrowseMangaComponent} from "./browse-manga/browse-manga.component";
import {SignupComponent} from "./signup/signup.component";
import {LoginComponent} from "./login/login.component";
import {ProfilComponent} from "./profil/profil.component";
import {SectionComponent} from "./section/section.component";
import {FooterComponent} from "./footer/footer.component";



const routes: Routes = [
  {
    path: '', component: LandingPageComponent
  },
  {
    path: '', component: FooterComponent
  },
  {
    path: 'sec/:id', component: SectionComponent
  },
  {
    path: 'home', redirectTo: '', pathMatch: "full"
  },
  {
    path: 'manga', component: MangaComponent
  },

  {
    path: 'login', component: LoginComponent
  },
  {
    path:'browsemanga',component:BrowseMangaComponent
  }
  ,{ path: 'manga/:id', component: MangaDetailsComponent},

  {
    path: 'signup', component: SignupComponent
  },
  {
    path: 'profil', component: ProfilComponent
  },
  {
    path: 'anime', component: BasicAnimePagesComponent, children:
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
