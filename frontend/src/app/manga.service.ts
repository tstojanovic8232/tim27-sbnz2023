import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

export interface Manga {
  mal_id: number;
  url: string;
  images: {
    jpg: {
      image_url: string;
      small_image_url: string;
      large_image_url: string;
    };
    webp: {
      image_url: string;
      small_image_url: string;
      large_image_url: string;
    };
  };
  trailer: {
    youtube_id: string;
    url: string;
    embed_url: string;
  };
  approved: boolean;
  titles: string[];
  title: string;
  title_english: string;
  title_japanese: string;
  title_synonyms: string[];
  type: string;
  source: string;
  episodes: number;
  status: string;
  airing: boolean;
  authors:string;
  aired: {
    from: string;
    to: string;
    prop: {
      from: {
        day: number;
        month: number;
        year: number;
      };
      to: {
        day: number;
        month: number;
        year: number;
      };
    };
    string: string;
  };
  duration: string;
  rating: string;
  score: number;
  scored_by: number;
  rank: number;
  popularity: number;
  members: number;
  favorites: number;
  synopsis: string;
  background: string;
  season: string;
  year: number;
  broadcast: {
    day: string;
    time: string;
    timezone: string;
    string: string;
  };
  producers: [
    {
      mal_id: number;
      type: string;
      name: string;
      url: string;
    }
  ];
  licensors: [
    {
      mal_id: number;
      type: string;
      name: string;
      url: string;
    }
  ];
  studios: [
    {
      mal_id: number;
      type: string;
      name: string;
      url: string;
    }
  ];
  genres: [
    {
      mal_id: number;
      type: string;
      name: string;
      url: string;
    }
  ];
  explicit_genres: [
    {
      mal_id: number;
      type: string;
      name: string;
      url: string;
    }
  ];
  themes: [
    {
      mal_id: number;
      type: string;
      name: string;
      url: string;
    }
  ];
  demographics: [
    {
      mal_id: number;
      type: string;
      name: string;
      url: string;
    }
  ];
  relations: [
    {
      relation: string;
      entry: [
        {
          mal_id: number;
          type: string;
          name: string;
          url: string;
        }
      ];
    }
  ];
  theme:{
    openings:[
      string
    ];
    endings:[
      string
    ];
  }
  external:[
    {
      name:string;
      url:string;
    }
  ]
  streaming:[
    {
      name:string;
      url:string;
    }
  ]
}
export interface ListResponseModel<T>{
  data:T[];
}
export interface Pagination{
  pagination:{
    last_visible_page:number;
    has_next_page:boolean;
    current_page:number;
    items:{
      count:number;
      total:number;
      per_page:number;
    }

  }
}
export interface ResponseModel{
  data:Manga
}
@Injectable({
  providedIn: 'root'
})
export class MangaService {

  apiUrl:string="https://api.jikan.moe/v4/manga";
  mostpopular:string="https://api.jikan.moe/v4/manga?order_by=score&sort=desc";


  constructor(private httpclient:HttpClient) { }


  getMangas():Observable<ListResponseModel<Manga>>{
    return this.httpclient.get<ListResponseModel<Manga>>(this.apiUrl);
  }
  getMostPopularMangas():Observable<ListResponseModel<Manga>>{
    return this.httpclient.get<ListResponseModel<Manga>>(this.mostpopular);
  }
  getAuthorsMangas():Observable<ListResponseModel<Manga>>{
    return this.httpclient.get<ListResponseModel<Manga>>(this.mostpopular);
  }
  getPagination():Observable<Pagination>{
    return this.httpclient.get<Pagination>(this.apiUrl);
  }

  getNextMangas(apiNum:number):Observable<ListResponseModel<Manga>>{
    return this.httpclient.get<ListResponseModel<Manga>>(this.apiUrl+"/"+apiNum+"/full");
  }

  getManga(id:number):Observable<ResponseModel>{
    const url = `${this.apiUrl}/${id}`;
    console.log(url);
    return this.httpclient.get<ResponseModel>(url).pipe();
  }
}
