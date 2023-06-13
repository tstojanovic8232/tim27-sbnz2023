import { Component } from '@angular/core';
import {LoginService} from "../login.service";
import {Router} from "@angular/router";
import {Korisnik} from "../korisnik";



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  id: number | undefined;
  prezime: string | undefined;
  uloga: string | undefined;

  korisnik: Korisnik = new Korisnik();
  username:string='';
  password:string='';

  constructor(private loginservice: LoginService, private router: Router) {

  }

  onSubmit() {
     console.log(this.username,this.password)
    this.loginservice.loginUser(this.username, this.password).subscribe(
      (data:any) => {
        console.log(data)
        alert('Login successful!');
        const receivedKorisnik: Korisnik = data;
        const ime = receivedKorisnik.korisniko_ime;
        const lozinka = receivedKorisnik.lozinka;


      },
      (error) => {
        console.log(error)
        alert('Sorry, bad credentials!');
      }
    );
  }
}
