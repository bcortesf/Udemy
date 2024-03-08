import { Component, EventEmitter, Input, OnDestroy, OnInit, Output } from '@angular/core';
import { Subject, Subscription, debounceTime } from 'rxjs';

@Component({
  selector: 'shared-search-box',
  templateUrl: './search-box.component.html',
  styleUrl: './search-box.component.css'
})
export class SearchBoxComponent implements OnInit, OnDestroy {
  /**PADRES:
   * src\app\countries\pages\by-capital-page\by-capital-page.component.html
   * src\app\countries\pages\by-country-page\by-country-page.component.html
   * src\app\countries\pages\by-region-page\by-region-page.component.html
   */
  @Input()
  public propiedadPlaceholder: string = '';

  /**FUNCIONALIDAD: buscar al presionar tecla.ENTER */
  @Output()
  onKeyEnterValue: EventEmitter<string> = new EventEmitter();
  emitKeyEnterValue(inputElement :HTMLInputElement){
    // const valu = inputElement.value
    console.log('DESDE_HIJO<SEARCH>:', {inputElement});
    const {value} = inputElement;
    this.onKeyEnterValue.emit(value)
  }


  /**FUNCIONALIDAD: cuando usuario deje de escribir,
   * esperar un lapso de EQUIS segundos para emprezar busqueda
   * debouncer = TuboDeAgua(sale-hagua-hasta-cerrar-llave)*/
  private debouncer: Subject<string> = new Subject();
  private debouncerSuscription?: Subscription;

  ngOnInit(): void {
    this.debouncerSuscription = this.debouncer
      .pipe(
        debounceTime(1000)
      )
      .subscribe( (searchTerm: string) => {
        // console.log('debouncer value', searchTerm);
        this.onDebounce.emit(searchTerm);
      });
  }

  @Output()
  onDebounce: EventEmitter<string> = new EventEmitter();
  emitKeyPressValue(searchTerm: string){
    this.debouncer.next( searchTerm )
  }


  /**Cuando salga d eun componente, debedestruir el componente  + observadores creados */
  ngOnDestroy(): void {
    this.debouncerSuscription?.unsubscribe();
  }
  ///////////////////////////////////
  ///////////////////////////////////
  emitirValorDirecto(value :string) {
    this.onKeyEnterValue.emit(value)
  }

  objetoMedianteLLAVES() {
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
