import { Component, EventEmitter, Output } from '@angular/core';
import { Character } from '../../interfaces/Character.interface';

@Component({
  selector: 'dbz-add-character',
  templateUrl: './add-character.component.html',
  styleUrl: './add-character.component.css'
})
export class AddCharacterComponent {

  //->Emitir a nuestro componente PADRE, donde esta mi lista personajes
  @Output()
  onNewCharacter: EventEmitter<Character> = new EventEmitter();

  public character: Character;

  constructor() {
    this.character = {
      name: '',
      power: 0
    };
  }

  /**@Output: Emitir al padre un valor, mediante metodo */
  emitCharacter() :void {
    console.log(this.character);
    if (!this.isCharacterValid) return;
    this.onNewCharacter.emit(this.character)

    this.resetCharacter();
  }

  resetCharacter() :void {
    this.character = { name: '', power: 0 };
  }

  isCharacterValid() :boolean {
    return this.character.name.trim().length > 0;
  }

}
