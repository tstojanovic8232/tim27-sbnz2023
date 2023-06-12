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
  ime: string | undefined;
  prezime: string | undefined;
  uloga: string | undefined;


  korisnik:Korisnik=new Korisnik();
  //
  constructor(
    private loginservice: LoginService,
    private router: Router,


  ) {

  }
  onSubmit() {
    this.loginservice.loginUser(this.korisnik).subscribe(data=>{
      alert("login succesful!");
      const ime=data.ime;
      const lozinka=this.korisnik.lozinka;

      if(this.korisnik.ime.match(ime) && this.korisnik.lozinka.match(lozinka)){
        alert("Ulogovali ste se uspesno!");
        this.router.navigate(['/user']);
      }
    },error => alert("sorry bad credentials!"));
  }
}
