import { Component } from '@angular/core';

@Component({
  selector: 'app-heroes-list',
  templateUrl: './list.component.html',
  styleUrl: './list.component.css'
})
export class ListComponent {
  public heroNames: string[] = [
    'Spiderman', 'Ironman', 'Hulk', 'Thor'
  ];
  public heroNamesDelete: string[];
  public heroName: string ;


  constructor() {
    this.heroNamesDelete = [];
    this.heroName = '';
  }

  deleteLastHero() {
    this.heroName = this.heroNames.pop()!;
    this.heroNamesDelete.push(this.heroName);
  }

  deleteLastHeroById(index: number) {
    this.heroName = this.heroNames.splice(index,1).at(0) ?? 'nulito';
    this.heroNamesDelete.push(this.heroName);
  }
}





















