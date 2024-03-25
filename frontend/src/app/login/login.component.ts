import {Component, ElementRef, Renderer2} from '@angular/core';
import {LoginService} from "../login.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Korisnik} from "../korisnik";
import {LocalService} from "../local.service";



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  container!: HTMLElement;
  registerBtn!: HTMLElement;
  loginBtn!: HTMLElement;

  showModal: boolean = false; // Add this line to track modal visibility

  isLoggedIn: boolean = false; // Add this line to declare the isLoggedIn property

  constructor(

    private route: ActivatedRoute,
    private router: Router,


  ) {}


  ngOnInit(): void {
    this.container = document.getElementById('container')!;
    this.registerBtn = document.getElementById('register')!;
    this.loginBtn = document.getElementById('login')!;

    this.registerBtn.addEventListener('click', () => {
      this.container.classList.add('active');
    });

    this.loginBtn.addEventListener('click', () => {
      this.container.classList.remove('active');
    });
  }






}
