import { Component} from '@angular/core';
import { Character } from '../interfaces/Character.interface';



@Component({
  selector: 'app-dbz-pages-main-page',
  templateUrl: './main-page.component.html',
  styleUrl: './main-page.component.css'
})
export class MainPageComponent {

  public characters : Character[] = [
    {name: 'Krillin', power: 1000},
    {name: 'Goku', power: 9500},
    {name: 'Vegeta', power: 7500},
    {name: 'Broly', power: 34000}
  ]

  // constructor() {}

}
