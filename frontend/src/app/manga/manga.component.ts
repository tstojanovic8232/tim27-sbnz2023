import {Component, ElementRef, Renderer2, ViewChild} from '@angular/core';
import {Manga, MangaService} from "../manga.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-manga',
  templateUrl: './manga.component.html',
  styleUrls: ['./manga.component.css']
})
export class MangaComponent {

  mangas: Manga[] = [];
  dataLoaded = false;
  p:number = 1;
  count:number = 30;
  maxCount:number|any;
  itemsPerPage: number = 10; // Number of items to display per page
  totalItems: number|any; // Total number of items
  pId:number|any;
  apiNum:number|any;
  constructor(private mangaService:MangaService,private router:Router) { }

  ngOnInit(): void {
    // this.getMangas();
    this.getMostPopularMangas();

  }

  getMangas() {
    this.mangaService
      .getMangas()
      .subscribe((response) => (this.mangas = response.data),null,()=>{
        console.log(this.mangas)
      });
    this.dataLoaded = true;
    console.log(this.mangas)
  }
  getMostPopularMangas() {
    this.mangaService
      .getMangas()
      .subscribe((response) => (this.mangas = response.data),null,()=>{
        console.log(this.mangas)
      });
    this.dataLoaded = true;
    console.log(this.mangas)
  }








  goToManga(mal_id: any) {
    // this.router.navigate(['/manga', mal_id]);
    console.log('sdaasd')
  }

}
