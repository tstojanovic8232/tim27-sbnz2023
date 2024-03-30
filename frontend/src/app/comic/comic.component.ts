import { Component } from '@angular/core';

@Component({
  selector: 'app-comic',
  templateUrl: './comic.component.html',
  styleUrls: ['./comic.component.css']
})
export class ComicComponent {
  resetAnimation(): void {
    const element = document.getElementById("animate");
    if (element) {
      element.classList.remove("run-animation");
      void element.offsetWidth;
      element.classList.add("run-animation");
    }
  }
}
