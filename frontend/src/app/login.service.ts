import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Korisnik} from "./korisnik";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private apiUrl = 'http://localhost:8084';

  constructor(private http: HttpClient) {}

  public loginUser(korisnik: Korisnik): Observable<any> {
    return this.http.post(`${this.apiUrl}/login`, korisnik);
  }

  public getUsers(): Observable<Korisnik[]> {
    return this.http.get<Korisnik[]>(`${this.apiUrl}/svi`);
  }
}
