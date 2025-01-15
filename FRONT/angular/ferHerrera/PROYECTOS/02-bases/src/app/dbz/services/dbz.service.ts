import { Injectable } from '@angular/core';
import { Character } from '../interfaces/Character.interface';

/**TERCEROS */
//-> https://www.npmjs.com/package/uuid
import { v4 as uuid } from 'uuid';
// console.log(uuid());


@Injectable({
  providedIn: 'root'
})
export class DbzService {

  public characters : Character[] = [
    {id: uuid(), name: 'Krillin', power: 1000},
    {id: uuid(), name: 'Goku', power: 9500},
    {id: uuid(), name: 'Vegeta', power: 7500},
    {id: uuid(), name: 'Broly', power: 34000}
  ]


  // https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/splice
  //-------------------------------------------------------------------
  //-------------------------------------------------------------------
                    //->OUTPUTS, de mis hijos
  onNewCharacter(character :Character) {
    // character.id = uuid();
    // this.characters.push(character);
    //...................................

    // const newCharacter: Character = { id: uuid()
    //   ,name: character.name, power: character.power
    // }
    const newCharacter: Character = { id: uuid()
        , ...character //->copia las demas propiedades
      }


    this.characters.splice( this.characters.length, 0, newCharacter );
  }

  onDeleteCharacterByIndex(indexArray :number) {
    this.characters.splice(indexArray, 1);
  }
  onDeleteCharacterByUUID(UUIDcharacter :string) {
    this.characters = this.characters.filter(
      // (character:Character) => ! (character.id!.includes(UUIDcharacter))
      (character:Character) => character.id !== UUIDcharacter
    );
  }
  //-------------------------------------------------------------------
}
