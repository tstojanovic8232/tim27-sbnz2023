import {Component, ElementRef, Renderer2, ViewChild} from '@angular/core';
import {Manga, MangaService} from "../manga.service";

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

  pId:number|any;
  apiNum:number|any;
  constructor(private mangaService:MangaService) { }

  ngOnInit(): void {
    // this.getMangas();
    this.getMostPopularMangas();
    this.getPaginationCount()
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
      .getMostPopularMangas()
      .subscribe((response) => (this.mangas = response.data),null,()=>{
        console.log(this.mangas)
      });
    this.dataLoaded = true;
    console.log(this.mangas)
  }
  getPaginationCount() {
    this.mangaService
      .getPagination()
      .subscribe((response) => {
        this.maxCount = response.pagination.last_visible_page;
      });
  }



  getNextAnimes(pr:number) {
    this.mangaService
      .getNextMangas(pr)
      .subscribe((response) => {
        (this.mangas = response.data)
      });
    this.dataLoaded = true;
  }

  handlePageChange(event: number) {
    this.getNextAnimes(event);
  }



}
