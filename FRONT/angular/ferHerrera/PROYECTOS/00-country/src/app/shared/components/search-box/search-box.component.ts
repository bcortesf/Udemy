import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'shared-search-box',
  templateUrl: './search-box.component.html',
  styleUrl: './search-box.component.css'
})
export class SearchBoxComponent implements OnInit {
  /**PADRES:
   * src\app\countries\pages\by-capital-page\by-capital-page.component.html
   * src\app\countries\pages\by-country-page\by-country-page.component.html
   * src\app\countries\pages\by-region-page\by-region-page.component.html
   */
  @Input()
  public propiedadPlaceholder: string = '';

  @Output()
  onValue: EventEmitter<string> = new EventEmitter();
  emitValue(inputElement :HTMLInputElement){
    // const valu = inputElement.value
    console.log('DESDE_HIJO<SEARCH>:', {inputElement});
    const {value} = inputElement;
    this.onValue.emit(value)
  }

  ///////////////////////////////////
  ///////////////////////////////////
  emitirValorDirecto(value :string) {
    this.onValue.emit(value)
  }

  ngOnInit(): void {
    return;
    //->solo para pruebas BryanCFz:  throw new Error('Method not implemented.');
    const positions: { [key: string]: number } = {
      primeroKEY: 1
    };
    console.log(positions["primeroKEY"]);


    const translations: { [key: string]: Translation } = {
      latinoKEY:  {official:'Español', common:'Colombianito'},
      americaKEY: {official:'Ingles', common:'Gringolandio'}
    };
    console.log(translations["latinoKEY"]);
    console.log(translations["americaKEY"]);

  }
}
export interface Translation {
  official: string;
  common:   string;
}
/////////////////////////////////////
