import { Component } from '@angular/core';
import {MangaService, ResponseModel} from "../manga.service";
import {ActivatedRoute} from "@angular/router";
import { Location } from '@angular/common';
@Component({
  selector: 'app-manga-details',
  templateUrl: './manga-details.component.html',
  styleUrls: ['./manga-details.component.css']
})
export class MangaDetailsComponent {
  manga: ResponseModel | undefined;

  constructor(private animeService: MangaService, private route: ActivatedRoute, private location: Location) {

  }

  ngOnInit(): void {
    this.getAnime();
  }

  getAnime():void{
    const id = +this.route.snapshot.params['id'];
    this.animeService.getManga(id).subscribe((manga) => (this.manga = manga));
    console.log(this.manga?.data.chapters);
  }


}
