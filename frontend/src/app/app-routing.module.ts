import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LandingPageComponent} from "./landing-page/landing-page.component";
import {MangaComponent} from "./manga/manga.component";

const routes: Routes = [
  {
    path:'',component:LandingPageComponent
  },
  {
    path:'manga',component:MangaComponent
  },
  {
    path:'anime',component:LandingPageComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
