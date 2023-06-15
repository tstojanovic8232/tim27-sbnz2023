import {Component, OnInit} from '@angular/core';
import {Media} from "../media";
import {HttpClient} from "@angular/common/http";
import {Location} from "@angular/common";
import {LocalService} from "../local.service";

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css']
})
export class ProfilComponent implements OnInit {

  mangaData: Media[] = [];
  animeData: Media[] = [];
  apiurl = "http://localhost:8084/korisnik"
  korisnik_id: number;

  constructor(private http: HttpClient, private location: Location, private localService: LocalService) {
    let temp = localService.getData('id');
    if (temp)
      this.korisnik_id = parseInt(temp);
    else this.korisnik_id = 0;
    this.loadAnimeRecs();
    this.loadMangaRecs();
  }

  loadMangaRecs() {
     this.http.get(`${this.apiurl}/manga/${this.korisnik_id}`).subscribe((data:any)=>{
       for (const item of data) {
         const temp:Media=new Media();
         temp.id=item.id;
         temp.naziv=item.naziv;

         this.mangaData.push(temp);
       }
       this.mangaData.sort((a,b)=>{
         if(a.id<b.id)
           return -1;
         if(a.id>b.id)
           return 1;
         return 0

       })
     })
  }

  loadAnimeRecs() {
    this.http.get(`${this.apiurl}/anime/${this.korisnik_id}`).subscribe((data:any)=>{
      for (const item of data) {
        const temp:Media=new Media();
        temp.id=item.id;
        temp.naziv=item.naziv;
        this.animeData.push(temp);
      }
      this.animeData.sort((a,b)=>{
        if(a.id<b.id)
          return -1;
        if(a.id>b.id)
          return 1;
        return 0

      })
    })
  }

  ngOnInit() {

  }


  addManga() {
    this.http.post(`${this.apiurl}/manga/${this.korisnik_id}/dodajMangu`,this.mangaData[0].id).subscribe((response:any)=>{
      console.log(response)
       window.location.reload();
    })
  }

  addAnime() {
    this.http.post(`${this.apiurl}/anime/${this.korisnik_id}/dodajAnime`,this.animeData[0].id).subscribe((response:any)=> {
      console.log(response)
      window.location.reload();

    })
  }
}
