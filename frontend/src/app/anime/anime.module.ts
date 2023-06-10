import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HeroBannerComponent} from './components/hero-banner/hero-banner.component';
import {TopNListComponent} from './components/top-nlist/top-nlist.component';
import {BasicNavBarComponent} from './components/basic-nav-bar/basic-nav-bar.component';
import {BasicFooterComponent} from './components/basic-footer/basic-footer.component';
import {BasicHomePageComponent} from './pages/basic-home-page/basic-home-page.component';
import {LoginComponent} from './components/login/login.component';
import {RouterModule} from '@angular/router';
import {SignupComponent} from './components/signup/signup.component';
import {AboutComponent} from './components/about/about.component';
import {BrowseComponent} from './components/browse/browse.component';
import {BasicAnimePagesComponent} from './pages/basic-anime-pages/basic-anime-pages.component';
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    HeroBannerComponent,
    TopNListComponent,
    BasicNavBarComponent,
    BasicFooterComponent,
    BasicHomePageComponent,
    LoginComponent,
    SignupComponent,
    AboutComponent,
    BrowseComponent,
    BasicAnimePagesComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    HttpClientModule
  ]
})
export class AnimeModule {
}
