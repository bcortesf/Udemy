import { Component, Input } from '@angular/core';
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

}
