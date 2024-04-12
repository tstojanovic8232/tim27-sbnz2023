import {Component, ElementRef, ViewChild} from '@angular/core';
import { animate, state, style, transition, trigger } from '@angular/animations';
import {Manga, MangaService, ResponseModel} from "../manga.service";
import {ActivatedRoute} from "@angular/router";
import {Location} from "@angular/common";

@Component({
  selector: 'app-manga',
  templateUrl: './section.component.html',
  styleUrls: ['./section.component.css'],

})
export class SectionComponent {
  imageUrl: string = "src/assets/images/manga.jpg"; // Set default image URL
  commentCount: number = 11; // Set default comment count
  viewCount: number = 9141; // Set default view count
  animeTitle: string = "Fate Stay Night: Unlimited Blade"; // Set default anime title
  animeSubtitle: string = "フェイト／ステイナイト, Feito／sutei naito"; // Set default anime subtitle

  manga: ResponseModel | undefined;
  reviews: any[] = [];
  recommendations: any[] = [];
  characterSearchResults: any[] = [];
  characterDetails: any;
  query: string = '';
  characterId!: number ;
  mangaResults: any[] | undefined;
  characterManga: any = { data: { characters: [] } };
  constructor(private animeService: MangaService, private route: ActivatedRoute, private location: Location) {

  }

  ngOnInit(): void {
    this.getAnime();
    this.animeService.getMangaReviews(this.route.snapshot.params['id']).subscribe(reviews => {
      this.reviews = reviews.data;
  }, error => {
    console.error('Error fetching manga reviews:', error);    // Handle error if needed
  })
    this.animeService.getMangaReccommendations(this.route.snapshot.params['id']).subscribe(recommendations => {
      this.recommendations = recommendations.data;
      console.log(this.recommendations)
    }, error => {
      console.error('Error fetching manga reviews:', error);    // Handle error if needed
    })

  }

  getAnime(): void {
    const id = +this.route.snapshot.params['id'];
    this.animeService.getManga(id).subscribe(
      (manga) => {
        this.manga = manga;
        this.getCharacterManga(id);
        console.log(this.manga?.data.chapters);
      },
      error => {
        console.error('Error fetching manga:', error);
      }
    );

    this.animeService.getMangaReviews(id).subscribe(
      (response: any) => {
        this.reviews = response.reviews;
        console.log('Reviews:', this.reviews);
      },
      (error: any) => {
        console.error('Error fetching manga reviews:', error);
      }
    );
  }

  getCharacterManga(malId: number): void {
    this.animeService.getCharacterManga(malId).subscribe(
      (data: any) => {
        // Filter main characters
        const mainCharacters = data.data.filter((character: any) => character);
        // Assign main characters to characterManga
        const firstSixCharacters = mainCharacters.slice(0, 7);
        // Assign first 6 characters to characterManga
        this.characterManga = { data: { characters: firstSixCharacters } };
        console.log('Main Characters:', this.characterManga);
      },
      error => {
        console.error('Error fetching character manga:', error);
        // Initialize characterManga as an empty array
        this.characterManga = { data: { characters: [] } };
      }
    );
  }
  scrollToTop() {
    window.scrollTo({
      top: 0,
      behavior: 'smooth'
    });
  }
}
