// import { Component, ElementRef } from '@angular/core';
// import { Manga, MangaService, ResponseModel } from "../manga.service";
// import { Router } from "@angular/router";
// import VanillaTilt from 'vanilla-tilt';
//
// @Component({
//   selector: 'app-browse-manga',
//   templateUrl: './browse-manga.component.html',
//   styleUrls: ['./browse-manga.component.css']
// })
// export class BrowseMangaComponent {
//   mangas: Manga[] = [];
//   filteredMangas: Manga[] = [];
//   dataLoaded = false;
//   currentpage: number = 1;
//   count: number = 30;
//   maxCount: number | undefined;
//   itemsPerPage: number = 12;
//   totalItems: number | undefined;
//   paginationId: string = 'pagination-controls-' + new Date().getTime();
//
//   apiNum: number | undefined;
//   searchText: string = '';
//
//   constructor(private mangaService: MangaService, private router: Router, private elementRef: ElementRef) {
//   }
//
//   manga: ResponseModel | undefined;
//
//   ngOnInit(): void {
//
//     this.getMostPopularMangas();
//
//
//   }
//   search() {
//     if (this.searchText !== undefined && this.searchText.trim() !== '') {
//       this.filteredMangas = this.mangas.filter((manga) => {
//         const titleMatch = manga.title.toLowerCase().includes(this.searchText.toLowerCase());
//         const authorMatch = manga.authors.some((author) => author.name.toLowerCase().includes(this.searchText.toLowerCase()));
//         const synopsisMatch = manga.synopsis.toLowerCase().includes(this.searchText.toLowerCase());
//         return titleMatch || authorMatch || synopsisMatch;
//       });
//     } else {
//       this.filteredMangas = this.mangas;
//     }
//   }
//   getMostPopularMangas() {
//     this.mangaService.getMangas().subscribe(
//       (response) => {
//         this.mangas = response.data;
//         this.filteredMangas = this.mangas;
//         this.totalItems = this.mangas.length;
//         this.search();
//       },
//       (error) => {
//         console.log(error);
//       }
//     );
//     this.dataLoaded = true;
//   }
//   pageChanged(event: any) {
//     this.currentpage = event;
//   }

import { Component } from '@angular/core';
import {ListResponseModel, Manga, MangaService} from "../manga.service";

@Component({
  selector: 'app-browse-manga',
  templateUrl: './browse-manga.component.html',
  styleUrls: ['./browse-manga.component.css']
})
export class BrowseMangaComponent {
  mangas: Manga[] = [];
  currentPage = 1;
  itemsPerPage = 12;
  totalItems = 0;

  constructor(private mangaService: MangaService) {}

  ngOnInit(): void {
    this.getMostPopularMangas();
  }

  getMostPopularMangas(page: number = 1) {
    this.mangaService.getMangas2(page, this.itemsPerPage).subscribe(
      (response) => {
        this.mangas = response.data;
        this.totalItems = response.data.length; // Update totalItems with the total count from the response
      },
      (error) => {
        console.log(error);
      }
    );
  }

  getTotalPages(): number {
    return Math.ceil(this.totalItems / this.itemsPerPage);
  }

  onPageChange(page: number) {
    if (page >= 1 && page <= this.getTotalPages()) {
      this.currentPage = page;
      this.getMostPopularMangas(page);
    }
  }

}


//
//
//
//
//
//   getActionMangas() {
//     this.mangaService
//       .getActionMangas()
//       .subscribe((response) => (this.mangas = response.data),null,()=>{
//         console.log(this.mangas)
//       });
//     this.dataLoaded = true;
//     this.filteredMangas = this.mangas;
//     console.log(this.mangas)
//   }
//   getShounen() {
//     this.mangaService
//       .getShounen()
//       .subscribe((response) => (this.mangas = response.data),null,()=>{
//         console.log(this.mangas)
//       });
//     this.dataLoaded = true;
//     this.filteredMangas = this.mangas;
//     console.log(this.mangas)
//   }
//   getSeinen() {
//     console.log('sadasdsad');
//     this.mangaService
//       .getSeinen()
//       .subscribe((response) => (this.mangas = response.data),null,()=>{
//         console.log(this.mangas)
//       });
//     this.dataLoaded = true;
//     this.filteredMangas = this.mangas;
//     console.log(this.mangas)
//   }
//   getSupernatural() {
//     console.log('sadasdsad');
//     this.mangaService
//       .getSupernatural()
//       .subscribe((response) => (this.mangas = response.data),null,()=>{
//         console.log(this.mangas)
//       });
//     this.dataLoaded = true;
//     this.filteredMangas = this.mangas;
//     console.log(this.mangas)
//   }
//   getMystery() {
//     console.log('sadasdsad');
//     this.mangaService
//       .getMystery()
//       .subscribe((response) => (this.mangas = response.data),null,()=>{
//         console.log(this.mangas)
//       });
//     this.dataLoaded = true;
//     this.filteredMangas = this.mangas;
//     console.log(this.mangas)
//   }
//
//   getAdvantureMangas() {
//     this.mangaService
//       .getAdvanture()
//       .subscribe((response) => (this.mangas = response.data),null,()=>{
//         console.log(this.mangas)
//       });
//     this.dataLoaded = true;
//     this.filteredMangas = this.mangas;
//     console.log(this.mangas)
//   }
//   getHorror() {
//     this.mangaService
//       .getHorror()
//       .subscribe((response) => (this.mangas = response.data),null,()=>{
//         console.log(this.mangas)
//       });
//     this.dataLoaded = true;
//     this.filteredMangas = this.mangas;
//     console.log(this.mangas)
//   }
//   getFantasy() {
//     this.mangaService
//       .getFantasy()
//       .subscribe((response) => (this.mangas = response.data),null,()=>{
//         console.log(this.mangas)
//       });
//     this.dataLoaded = true;
//     this.filteredMangas = this.mangas;
//     console.log(this.mangas)
//   }
//   getRomance() {
//     this.mangaService
//       .getRomance()
//       .subscribe((response) => (this.mangas = response.data),null,()=>{
//         console.log(this.mangas)
//       });
//     this.dataLoaded = true;
//     this.filteredMangas = this.mangas;
//     console.log(this.mangas)
//   }
//   getShojo() {
//     this.mangaService
//       .getShojo()
//       .subscribe((response) => (this.mangas = response.data),null,()=>{
//         console.log(this.mangas)
//       });
//     this.dataLoaded = true;
//     this.filteredMangas = this.mangas;
//     console.log(this.mangas)
//   }
//   getComedy() {
//     this.mangaService
//       .getComedy()
//       .subscribe((response) => (this.mangas = response.data),null,()=>{
//         console.log(this.mangas)
//       });
//     this.dataLoaded = true;
//     this.filteredMangas = this.mangas;
//     console.log(this.mangas)
//   }
//   getSport() {
//     this.mangaService
//       .getSport()
//       .subscribe((response) => (this.mangas = response.data),null,()=>{
//         console.log(this.mangas)
//       });
//     this.dataLoaded = true;
//     this.filteredMangas = this.mangas;
//     console.log(this.mangas)
//   }
//   getMilitary() {
//     this.mangaService
//       .getMilitary()
//       .subscribe((response) => (this.mangas = response.data),null,()=>{
//         console.log(this.mangas)
//       });
//     this.dataLoaded = true;
//     this.filteredMangas = this.mangas;
//     console.log(this.mangas)
//   }
//   getMecha() {
//     this.mangaService
//       .getMecha()
//       .subscribe((response) => (this.mangas = response.data),null,()=>{
//         console.log(this.mangas)
//       });
//     this.dataLoaded = true;
//     this.filteredMangas = this.mangas;
//     console.log(this.mangas)
//   }
//   getPsychological() {
//     this.mangaService
//       .getPsychological()
//       .subscribe((response) => (this.mangas = response.data),null,()=>{
//         console.log(this.mangas)
//       });
//     this.dataLoaded = true;
//     this.filteredMangas = this.mangas;
//     console.log(this.mangas)
//   }
//   getMangas() {
//     const startIndex = (this.currentpage - 1) * this.itemsPerPage;
//     const endIndex = startIndex + this.itemsPerPage;
//     this.filteredMangas = this.mangas.slice(startIndex, endIndex);
//   }
//
//
//
//
// }
