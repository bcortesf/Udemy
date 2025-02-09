import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ValidatorFn, Validators } from '@angular/forms';
import { CountriesService } from '../../services/countries.service';
import { Country, Region, SmallCountry } from '../../interfaces/country.interfaces';
import { count, filter, map, switchMap, tap } from 'rxjs';

@Component({
  selector: 'app-selector-page',
  templateUrl: './selector-page.component.html',
  styleUrl: './selector-page.component.css'
})
export class SelectorPageComponent implements OnInit {

  public isTrue = 1;

  public myForm: FormGroup = this.fb.nonNullable.group(
    {
      continent: ['', [Validators.required], []],
      country  : ['', [Validators.required], []],
      frontiers: ['', [Validators.required], []]
    }
  );

  constructor(
    private fb: FormBuilder,
    private countriesService: CountriesService
  ) {}

  ngOnInit(): void {
    this.onRegionChanged();

    /**
     * OPCION #1: "HTML" y QUITAR-METODO "this.onCountryChanged();" de -> ngOnInit
     * <!-- <select formControlName="country" (change)="onCountryChanged_HTML($event)" class="form-control"> -->
     *
     * OPCION #2: "HTML" + METODO "this.onCountryChanged();"  con -> ngOnInit
     * <select formControlName="country" class="form-control">
     */

    this.onCountryChanged();
  }


  get regions(): Region[] {
    return this.countriesService.regions;
  }
  public countriesByRegion: SmallCountry[] = [];
  public bordersByCountrySTR: string[] = [];
  public bordersByCountry: SmallCountry[] = [];


  /**
   * ->switchMap: recibe valor de un Observable: "la-region",
                  y permite subscribirse a otro observable
   */
  onRegionChanged(): void {
    this.myForm.get('continent')!.valueChanges
      .pipe(
        // map(valueChanges => valueChanges as Region),
        tap( () => this.myForm.get('country')!.setValue('') ), //cambiar valor selector
        tap( () => this.bordersByCountrySTR = []),
        switchMap(
          // (regionValue) =>  this.countriesService.getCountriesByRegion(regionValue)
          // (regionValue :any) =>  this.countriesService.getCountriesByRegion(regionValue)
          (regionValue :Region) =>  this.countriesService.getCountriesByRegion(regionValue)
        )
      )
      .subscribe( (smallCountries: SmallCountry[]) =>  {
        this.countriesByRegion = smallCountries;
        this.countriesByRegion
          .sort( (countryA, countryB) => countryA.name.common.localeCompare(countryB.name.common) );
      });
  }


  onCountryChanged(): void {
    this.myForm.get('country')!.valueChanges                     //[value]=country.cca3 ~~ string
      .pipe(
        tap( () =>  { //cambiar valor selector
            // this.myForm.get('frontiers')!.setValue('');
            this.myForm.get('frontiers')!.reset();
        }),
        map( (alphaCodeCCA3) => alphaCodeCCA3 as string),        //[value]=country.cca3 ~~ string
        //->Solucion-2: por si viene VACIO
        //  - Si es vacio, para en "filter", y no ejecuta mas; osea no ejecutaria(switchMap) y tampoco se (SUSBRIBIRIA)
        filter( alphaCodeCCA3 => alphaCodeCCA3.trim().length > 0 ),
        /**
         * primer-servicio :  obtiene <Pais>; Con un arrreglo de [Fronteras] del <Pais>.  Las [Fronteras] son en formato codigo "CCA3". Ejemplo{COL,BRA,USA}
         * segundo-servicio: Obtener nombre completo de las [FRONTERAS], segun primer-servicio: switchMap(getCountryByAlphaCodeCCA3)
         */
        switchMap( (alphaCodeCCA3: string) => this.countriesService.getCountryByAlphaCodeCCA3(alphaCodeCCA3) ),      //->primer-servicio
        switchMap( (country:SmallCountry) => this.countriesService.getCountryBordersByCodes( country.borders??[] ) ), //->segundo-servicio
        //->(Agregar y Remover) validador, Cuando no exista Frontera
        tap(
          /**SOLUCION-#1 */
          // (countries:SmallCountry[]) => (countries.length > 0)
          //   ? this._addValidators('frontiers', Validators.required)
          //   : this._removeValidators('frontiers', Validators.required)

            /**SOLUCION-#2 */
            (countries:SmallCountry[]) => this._borderRequired('frontiers', countries)
        )
      )
      .subscribe( (smallCountriesFinds: SmallCountry[]) =>  {
        console.log('smallCountriesFinds', smallCountriesFinds );
        this.bordersByCountry = smallCountriesFinds;
      });
  }

  onCountryChanged_STRING(): void {
    this.myForm.get('country')!.valueChanges                              //[value]=country.cca3 ~~ string
      .pipe(
        tap( () => this.myForm.get('frontiers')!.setValue('') ), //cambiar valor selector
        map( (alphaCodeCCA3) => alphaCodeCCA3 as string),
        //->Solucion-2: por si viene VACIO
        //  - Si es vacio, para en "filter", y no ejecuta mas; osea no ejecutaria(switchMap) y tampoco se (SUSBRIBIRIA)
        filter( alphaCodeCCA3 => alphaCodeCCA3.length > 0 ),
        switchMap( (alphaCodeCCA3: string) => this.countriesService.getCountryByAlphaCodeCCA3(alphaCodeCCA3) ),
      )
      .subscribe( (smallCountryFind: SmallCountry) =>  {
        console.log('smallCountryFind', smallCountryFind );
        this.bordersByCountrySTR = (smallCountryFind?.borders) as string[];
      });
  }
  onCountryChanged_2(): void {
    this.myForm.get('country')!.valueChanges                              //[value]=country.cca3
      .pipe(
        tap( () => this.myForm.get('frontiers')!.setValue('') ), //cambiar valor selector
      )
      .subscribe( (country_cca3: string) =>  {
        const countryFind = this.countriesByRegion
          .find( (country: SmallCountry) => country.cca3 === country_cca3 );

        this.bordersByCountrySTR = (countryFind?.borders) as string[];
      });
  }
  onCountryChanged_HTML(event: Event): void {
    const eventSelectedValue = (event.target as HTMLSelectElement).value; //[value]=country.cca3
    const formSelectedValue = this.myForm.get('country')!.value;          //[value]=country.cca3

    //Setear frontera
    this.myForm.controls['frontiers'].setValue('');

    const countryFind = this.countriesByRegion
      .find( (country: SmallCountry) => country.cca3 === formSelectedValue );

      this.bordersByCountrySTR = (countryFind?.borders) as string[];


    /**VALIDAMOS-Y-CAMBIAMOS-LOS-"undefined"->POR-'' */
    // this.bordersByCountry = (
    //   // countryFind?.borders?.map( (frontier)=> (frontier !== undefined) ?frontier :'')
    //   countryFind?.borders?.map( (frontier)=> frontier ?? '')
    // ) as string[];

    /** ***************************************************** */
    /* ->TEST: FormularioHTML en <code>errors</code> */
    // this.myForm.get('frontiers')!.setValue( frontiersSTR );
  }


  //---------------------------------------------------------------------------------
  /**SOLUCION-#1 */
  private _removeValidators(field: string, validators: ValidatorFn | ValidatorFn[]): void {
    this.myForm.controls[field].removeValidators(validators);
    this._updateValueAndValidity(field);
  }
  private _addValidators(field: string, validators: ValidatorFn | ValidatorFn[]): void {
    this.myForm.controls[field].addValidators(validators);
    this._updateValueAndValidity(field)
  }
  private _updateValueAndValidity(field: string): void {
    this.myForm.controls[field].updateValueAndValidity();
  }

  /**SOLUCION-#2 */
  private _borderRequired(field: string, countries:SmallCountry[]): void {
    if ( !countries.length ) { //-> Si no hay borders, quita el validador
      this.myForm.controls[field]!.setValidators([]);
      this.myForm.controls[field]!.updateValueAndValidity();
    }
    if ( countries.length ) { //-> Si hay borders, agrega el validador
      this.myForm.controls[field]!.addValidators( [Validators.required] );
      this.myForm.controls[field]!.updateValueAndValidity();
    }
  }
  //---------------------------------------------------------------------------------


  onSave() {
    throw new Error('Method not implemented.');
    }
}

//---------------------------------------------------------------
//---------------------------------------------------------------
/*
  onRegionChanged(): void {
    this.myForm.get('continent')!.valueChanges
      .subscribe(
        (regionValue : Region) => {
          console.log( {region: regionValue} );
          this.countriesService.getCountriesByRegion(regionValue)
            .subscribe({
              next: (smallCountrys: SmallCountry[]) =>  {
                this.countries = smallCountrys;
              },
              error: error => console.error('Error:', error),
              complete: () => console.log('Completo')
            });
        }
      );
  }
*/

//---------------------------------------------------------------
//---------------------------------------------------------------
// import { Prueba } from '../../interfaces/pruebas.interface';

// const p: Prueba = new Prueba();
// p.show('Bryan');

//---------------------------------------------------------------
//---------------------------------------------------------------
// const myArray = [1, 2, 1, 3, 3, 1, 2, 1, 5, 1];
// const histograma: { [clave: number]: string } = {};

// // Contar la frecuencia de cada elemento en el array
// myArray.forEach((elemento: number) => {
//     if (!histograma[elemento]) {
//         histograma[elemento] = '*';
//     } else {
//         histograma[elemento] += '*';
//     }
// });

// // Imprimir el histograma
// for (const key in histograma) {
//     if (histograma.hasOwnProperty(key)) {
//         console.log(`${key}: ${histograma[key]}`);
//     }
// }
