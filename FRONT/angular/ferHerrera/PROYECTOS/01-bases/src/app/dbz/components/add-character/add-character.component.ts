import { Component } from '@angular/core';
import { Character } from '../../interfaces/Character.interface';

@Component({
  selector: 'dbz-add-character',
  templateUrl: './add-character.component.html',
  styleUrl: './add-character.component.css'
})
export class AddCharacterComponent {

  public character: Character;

  constructor() {
    this.character = {
      name: '',
      power: 0
    };
  }

  emitCharacter() :void {
    console.log(this.character);
    this.resetCharacter();
  }

  resetCharacter() :void {
    this.character = {
      name: '',
      power: 0
    };
  }

}
