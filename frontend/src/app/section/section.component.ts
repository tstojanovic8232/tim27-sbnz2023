import { Component } from '@angular/core';
import {Manga, MangaService} from "../manga.service";

@Component({
  selector: 'app-section',
  templateUrl: './section.component.html',
  styleUrls: ['./section.component.css']
})
export class SectionComponent {
  mangas: Manga[] = [];
  dataLoaded = false;

  constructor(private mangaService:MangaService) { }

  ngOnInit(): void {
    this.getMangas();
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
}
