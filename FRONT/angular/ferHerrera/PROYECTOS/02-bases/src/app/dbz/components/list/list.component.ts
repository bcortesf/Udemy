import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Character } from '../../interfaces/Character.interface';


@Component({
  selector: 'dbz-list',
  templateUrl: './list.component.html',
  styleUrl: './list.component.css'
})
export class ListComponent {

  //->recibe data desde su padre<main-page.component>
  @Input()                      //->mismo nombre
  public characterList: Character[] = [{
    name: 'Trunks',
    power: 10
  }]

  //->recibe data desde su padre<main-page.component>
  @Input('characterList_Alias') //->asignar un alias
  public characterList2: Character[] = [{
    name: 'Trunks',
    power: 10
  }]

  //----------------------------------------------------
  //----------------------------------------------------
  //->emitir el indice desde este hijo<list.component> --> hacia su padre<main-page.component>
  @Output()
  onDeleteCharacterByIndex: EventEmitter<number> = new EventEmitter();
  onDeleteCharacterIndex(index :number) :void {
      this.onDeleteCharacterByIndex.emit(index);
  }
  @Output()
  onDeleteCharacterByUUID: EventEmitter<string> = new EventEmitter();
  onDeleteCharacterUUID(UUID:string) :void {
      this.onDeleteCharacterByUUID.emit(UUID);
  }

}
