import {Component, ElementRef, Renderer2, ViewChild} from '@angular/core';
import {Manga, MangaService} from "../manga.service";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {map, mergeMap, timer} from "rxjs";

@Component({
  selector: 'app-manga',
  templateUrl: './manga.component.html',
  styleUrls: ['./manga.component.css']
})
export class MangaComponent {

  mangas: Manga[] = [];
  dataLoaded = false;
  p: number = 1;
  count: number = 12;
  maxCount: number | any;
  itemsPerPage: number = 10; // Number of items to display per page
  totalItems: number | any; // Total number of items
  pId: number | any;
  apiNum: number | any;
   apiUrl = 'https://api.mangadex.org/manga?title=naruto'; // Assuming this is the base API URL
  requestInterval = 1000 / 3;
  mangaData: any[] = [];
  mangaImages: any[] = [];
  chapterImages: any[] | undefined; // This is where you'll store the images
  chapters: any[] = [];
  constructor(private mangaService: MangaService, private router: Router, private httpclient: HttpClient) {
  }

  ngOnInit(): void {
    // this.getMangas();
    // this.mangaService.getMangaData();
    // this.mangaData = this.mangaService.mangaData;
    this.getMostPopularMangas();

  }











  // getMangas() {
  //   this.mangaService
  //     .getMangas()
  //     .subscribe((response) => (this.mangas = response.data), null, () => {
  //       console.log(this.mangas)
  //
  //     });
  //   this.dataLoaded = true;
  //   console.log(this.mangas)
  //
  //
  // }

  getMostPopularMangas() {
    this.mangaService
      .getMostPopularMangas()
      .subscribe((response) => (this.mangas = response.data), null, () => {
        console.log(this.mangas)
      });
    this.dataLoaded = true;
    console.log(this.mangas)


  }


  handleButtonClick(mangaId:number) {

    this.router.navigate(['/manga', mangaId]);
  }
}









