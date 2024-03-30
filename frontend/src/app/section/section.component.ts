import {Component, ElementRef, ViewChild} from '@angular/core';
import { animate, state, style, transition, trigger } from '@angular/animations';
import {Manga, MangaService} from "../manga.service";

@Component({
  selector: 'app-manga',
  templateUrl: './section.component.html',
  styleUrls: ['./section.component.css'],

})
export class SectionComponent {
  currentIndex: number = 0;
  mangas: Manga[] = [];
  p: number = 1;
  count: number = 10;
  maxCount: number | any;
  itemsPerPage: number = 10;
  cards = [
    { id: 116778, title: 'Chainsaw Man', imageUrl: 'assets/img/manga9.jpg', description: 'Denji has a simple dream—to live a happy and peaceful life, spending time with a girl he likes. This is a far cry from reality, however, as Denji is forced by the yakuza into killing devils in order to pay off his crushing debts. Using his pet devil Pochita as a weapon, he is ready to do anything for a bit of cash.' },
    { id: 11, title: 'NARUTO', imageUrl: 'assets/img/manga10.jpg', description: 'The story delves into Naruto\'s growth as a ninja, his quest for recognition, and his journey to protect his loved ones and the village. Along the way, Naruto discovers the truth about his heritage, uncovers dark secrets, and faces the consequences of his choices. He forms friendships, develops rivalries, and learns valuable life lessons about determination, friendship, and the meaning of being a true ninja.' },
    { id: 12, title: 'BLEACH', imageUrl: 'assets/img/manga11.jpg', description: 'The story centers around Ichigo Kurosaki, a teenager with the ability to see ghosts. One day, he unintentionally obtains the powers of a Soul Reaper, a celestial being responsible for protecting the living world from malevolent spirits known as Hollows. As Ichigo embraces his new role as a Soul Reaper, he embarks on various missions to defend humanity from Hollow attacks.' },
    { id: 114745, title: 'BLUE LOCK', imageUrl: 'assets/img/manga12.jpg', description: 'The protagonist, Yoichi Isagi, is a talented high school soccer player who gets recruited by Blue Lock. He finds himself in a unique training facility, where 300 other skilled strikers from across the country have also been selected. These players must compete against each other in intense matches and training sessions to earn a spot on the national team.' },
    { id: 86337, title: 'BLACK CLOVER', imageUrl: 'assets/img/manga13.jpg', description: 'Despite his lack of magic, Asta dreams of becoming the Wizard King, the highest-ranking mage in the kingdom. He possesses an unwavering determination and an incredible physical strength that compensates for his magical deficiency. Asta\'s journey begins when he receives a rare five-leaf clover grimoire, which grants him the power of anti-magic, allowing him to nullify and repel magical spells.' },
    { id: 642, title: 'VINLAND SAGA', imageUrl: 'assets/img/manga14.jpg', description: 'Set during the Viking Age, the story follows the life of Thorfinn, a young Viking warrior seeking revenge against Askeladd, the mercenary leader who killed his father. Thorfinn, once a fearless and ruthless warrior, becomes entangled in a series of battles and conflicts as he travels with Askeladd\'s band of warriors. Over time, he begins to question the path of violence and vengeance he has chosen.' }



  ];
  mangaList = [
    { id: 1, title: 'Manga Title 1', imageUrl: 'assets/img/manga4.jpg', description: 'Description 1' },
    { id: 2, title: 'Manga Title 2', imageUrl: 'assets/img/manga5.jpg', description: 'Description 2' },
    { id: 3, title: 'Manga Title 3', imageUrl: 'assets/img/manga6.jpg', description: 'Description 3' },
    { id: 4, title: 'Manga Title 4', imageUrl: 'assets/img/manga2.jpg', description: 'Description 4' },
    { id: 5, title: 'Manga Title 4', imageUrl: 'assets/img/manga3.jpg', description: 'Description 4' },
    { id: 6, title: 'Manga Title 4', imageUrl: 'assets/img/new.jpg', description: 'Description 4' },
    { id: 7, title: 'Manga Title 4', imageUrl: 'assets/img/shounen.jpg', description: 'Description 4' },
    { id: 8, title: 'Manga Title 4', imageUrl: 'assets/img/anime.jpg', description: 'Description 4' },
    ...this.cards

    // Add more manga objects as needed
  ];


  public constructor(private mangaService:MangaService) {

  }

  ngOnInit(): void {

    this.getMostPopularMangas();


  }

  @ViewChild('cardsList') cardsList!: ElementRef;

  scrollCards(direction: 'left' | 'right'): void {
    const cards = this.cardsList.nativeElement;
    const scrollAmount = direction === 'left' ? -290+5 : 282-7;
    cards.scrollBy({ left: scrollAmount, behavior: 'smooth' });
  }


  pictures=[
    {imageUrl: 'assets/img/manga7.jpg'},
    {imageUrl: 'assets/img/mang3.jpg'},
    {imageUrl: 'assets/img/manga4.jpg'},
    {imageUrl: 'assets/img/manga5.jpg'},
    {imageUrl: 'assets/img/manga6.jpg'},
    {imageUrl: 'assets/img/manga8.jpg'}





  ]
  handleButtonClick(mangaId: number) {
    // Implement your logic when the "Read more" button is clicked
  }

  resetAnimation(): void {
    const element = document.getElementById("animate");
    if (element) {
      element.classList.remove("run-animation");
      void element.offsetWidth;
      element.classList.add("run-animation");
    }
  }

  selectedIndex: number = 0; // Add selectedIndex property here


  getMostPopularMangas(): void {
    this.mangaService.getMostPopularMangas().subscribe(response => {
      this.mangas = response.data;

      // Find the manga with the highest score
      const mangaWithHighestScore = this.mangas.reduce((prev, current) => {
        return (prev.score > current.score) ? prev : current;
      });

      console.log('Manga with highest score:', mangaWithHighestScore);
    }, error => {
      console.error('Error fetching most popular mangas:', error);
    });
  }


}
