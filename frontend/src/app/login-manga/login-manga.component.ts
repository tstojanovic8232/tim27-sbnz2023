import { Component } from '@angular/core';

class Korisnik {
}

@Component({
  selector: 'app-login-manga',
  templateUrl: './login-manga.component.html',
  styleUrls: ['./login-manga.component.css']
})
export class LoginMangaComponent {
  // id: number | undefined;
  // ime: string | undefined;
  // prezime: string | undefined;
  // uloga: string | undefined;
  //
  //
  // korisnik:Korisnik=new Korisnik();
  //
  // constructor(
  //   private loginservice: LoginService,
  //   private router: Router,
  //   private rad: KorisnikService
  //
  // ) {
  //   this.korisnik.uloga="user";
  // }
  // onSubmit() {
  //   this.loginservice.loginUser(this.korisnik).subscribe(data=>{
  //     alert("login succesful!");
  //     const role=data.uloga;
  //     const id=this.korisnik.id;
  //
  //     if(role.match('admin')){
  //       alert("Ulogovali ste se ko admin");
  //       this.router.navigate(['/admin']);
  //     }else  {
  //       alert("Ulogovali ste se ko user");
  //       this.router.navigate(['/user']);
  //     }
  //   },error => alert("sorry bad credentials!"));
  // }
}
