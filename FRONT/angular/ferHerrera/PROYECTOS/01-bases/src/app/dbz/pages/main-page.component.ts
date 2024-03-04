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

  //------------------------------------------------------------------------------------------------
                                            //->OUTPUTS, de mis hijos
  onNewCharacter(character :Character) {
    // https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/splice
    this.characters.splice( this.characters.length, 0, character );
    // this.characters.push(character)
  }

  onDeleteCharacterByIndex(indexArray :number) {
    this.characters.splice(indexArray, 1);
  }
  onDeleteCharacterByName(nameCharacter :string) {
    this.characters = this.characters.filter(
      character => !character.name.includes(nameCharacter)
    );
  }

  //------------------------------------------------------------------------------------------------
}
