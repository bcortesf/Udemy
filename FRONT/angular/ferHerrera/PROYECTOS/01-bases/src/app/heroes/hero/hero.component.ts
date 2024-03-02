import { Component } from '@angular/core';

@Component({
  selector: 'app-heroes-hero',
  templateUrl: './hero.component.html',
  styleUrl: './hero.component.css'
})
export class HeroComponent {
  /**ATRIBUTES */
  public hero :{
      id: number,
      character: string,
      age: number,
      producer: string} =  {
    id: 1,
    character: 'ironman',
    age: 34,
    producer: 'Marvel'
  };

  public isNameActiveBtn :boolean = true;



  /**FUNCTIONAL-METHODS */
  toString(): string {
    return `${this.capitalizedName} tiene ${this.hero.age} años`;
  }
  changeUpperCaseName(newName: string):void {
    this.isNameActiveBtn = !this.isNameActiveBtn;
    this.hero.character = `${newName}`;
  }
  changeAge(): void {
    this.hero.age += 1;
  }
  resetForm(): void {
    this.isNameActiveBtn = !this.isNameActiveBtn;
    this.hero.age = 34;

    /**
     * ->Cambiar el DOOM de la primera coincidencia de este componente
     * ?  :opcional      querySelector('h4')?
     * !  :obligatorio   querySelector('h4')!
     */
    // document.querySelector('h4')?.innerHTML = '<h4>Desde angular</h4>';
    // document.querySelector('h4')!.innerHTML = '<h4>Desde angular</h4>';

    //->Cambiar todo el DOOM de todos lso componentes
    // document.querySelectorAll('h4').forEach( (elemento:HTMLHeadingElement) => {
    //   elemento.innerHTML =  '<h4>Desde angular</h4>';
    // })
  }

  /**GETTERS: Se crean como nuevas propiedades del componente <HERO> */
  public get character() : string {
    //->1.attr[character]
    return this.hero.character;
  }
  public get capitalizedName() : string {
    //->2.attr[capitalizedName]
    return this.character.charAt(0).toUpperCase()
    .concat( this.character.slice(1) )
  }

}
