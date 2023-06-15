import { Component } from '@angular/core';
import {LoginService} from "../login.service";
import {Router} from "@angular/router";
import {Korisnik} from "../korisnik";
import {LocalService} from "../local.service";



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

  constructor(private loginservice: LoginService, private router: Router,private localservice:LocalService) {

  }

  onSubmit() {
     console.log(this.username,this.password)
    this.loginservice.loginUser(this.username, this.password).subscribe(
      (data:any) => {
        console.log(data)

        this.localservice.saveData('id',data.id.toString())
        const receivedKorisnik: Korisnik = data;
        const ime = receivedKorisnik.korisniko_ime;
        const lozinka = receivedKorisnik.lozinka;

        this.router.navigate(['/profil']);

      },
      (error) => {
        console.log(error)
        alert('Sorry, bad credentials!');
      }
    );

  }
}
