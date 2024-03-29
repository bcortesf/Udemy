import { Injectable } from '@angular/core';
import { Country, Region, SmallCountry } from '../interfaces/country.interfaces';
import { HttpClient } from '@angular/common/http';
import { Observable, map, of, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CountriesService {

  private _baseURL: string = 'https://restcountries.com/v3.1';

  private _regions: Region[] = [
    Region.Africa, Region.Americas, Region.Asia,
    Region.Europe, Region.Oceania
  ]

  constructor(private http: HttpClient) { }


  /**
   * Por si alguien modifica en un componente a "regions"
   *   -No va a modificar el arreglo original por REFERENCIA
   *   -Porque se pasa por COPIA en el [...SPREED]
   */
  get regions(): Region[] {
    return [ ...this._regions ];
  }



  /**
   * https://restcountries.com/#endpoints-region
   *
   * https://restcountries.com/v3.1/region/{region}
   * https://restcountries.com/v3.1/region/america
   * https://restcountries.com/v3.1/region/america?fields=name,ccn3,cca3,borders
   */
  getCountriesByRegion(region: Region) : Observable<SmallCountry[]> {
    if (!region) return of([]);

    const URL = `${this._baseURL}/region/${region}?fields=name,ccn3,cca3,borders`;
    return this.http.get<Country[]>(URL)
      .pipe(
        /**FORMA-1 */
        // map( (respCountrys :Country[]) => {
        //   const smallCountrys: SmallCountry[] = respCountrys;
        //   return smallCountrys;
        // }),

        /**FORMA-2 */
        // map(
        //   (respCountrys :Country[]) => (respCountrys as SmallCountry[])
        // ),

        /**FORMA-3 */
        map( (respCountrys :Country[]) =>  respCountrys
          .map((country :Country) => ({
              name: country.name,
              ccn3: country.ccn3,
              cca3: country.cca3,
              borders: country.borders ?? []
            }) as SmallCountry
          )
        )
        ,tap(
          (response: SmallCountry[]) => {
            console.log(response)
          }
        )
      );
  }


  /**
   * https://restcountries.com/#endpoints-code
   *
   * https://restcountries.com/v3.1/alpha/{code}
   * https://restcountries.com/v3.1/alpha/co
   * https://restcountries.com/v3.1/alpha/col
   * https://restcountries.com/v3.1/alpha/170
   * https://restcountries.com/v3.1/alpha/col?fields=name,ccn3,cca3,borders
   * Search by cca2, ccn3, cca3 or cioc country code
   */
  getCountryByAlphaCodeCCA3(alphaCodeCCA3: string): Observable<SmallCountry> {
    if (!alphaCodeCCA3) return of();

    const URL = `${this._baseURL}/alpha/${alphaCodeCCA3}?fields=name,ccn3,cca3,borders`;
    return this.http.get<Country>(URL)
      .pipe(
        // map( (respCountry: Country) => (respCountry as SmallCountry) )
        map( (respCountry: Country) =>
          ({
            name: respCountry.name,
            ccn3: respCountry.ccn3,
            cca3: respCountry.cca3,
            borders: respCountry.borders ?? []
          }) as SmallCountry
        )
      );
  }





  //-------------------------------------------------------------------
  //--------------------------------------------------------------------
  /**
   * Peticion backend que traiga las [Countries] por el <region>
   */
  getCountriesByRegion_VERSION1(region: Region) : SmallCountry[] {
    return [];
  }

  getCountriesByRegion_VERSION2(region: Region) : Observable<SmallCountry[]> {
    if (!region) return of([]); //->of = observable retorna arreglo vacio

    /**->TOD0S-LOS-CAMPOS:
     * https://restcountries.com/v3.1/region/america
    */
    // const URL = `${this._baseURL}/region/${region}`;

    /** -> POR-CAMPOS-ESPECIFICOS:
     * https://restcountries.com/v3.1/region/america?fields=name,ccn3,cca3,borders
     */
    const URL = `${this._baseURL}/region/${region}?fields=name,ccn3,cca3,borders`;
    return this.http.get<SmallCountry[]>(URL)
      .pipe(
        tap(
          (response: SmallCountry[]) => {
            console.log(response)
          }
        )
      );
  }

  getCountriesByRegion_VERSION3(region: Region) : Observable<SmallCountry[]> {
    if (!region) return of([]);

    const URL = `${this._baseURL}/region/${region}?fields=name,ccn3,cca3,borders`;
    return this.http.get<Country[]>(URL)
      .pipe(
        map( (respCountrys :Country[]) => {
          // return [];

          /**COPIAR PRIMER OBJETO DEL ARRAY */
          // const [ {name, ccn3, cca3, borders} ] = respCountrys;
          // const smallCountrys: SmallCountry[] = [{name, ccn3, cca3, borders}];

          /**COPIAR ARRAY SOLO CON LAS PROPIEDADES DE PARA "SmallCountry" */
          const smallCountrys: SmallCountry[] = respCountrys;
          return smallCountrys;
        }),
        tap(
          (response: SmallCountry[]) => {
            console.log(response)
          }
        )
      );
  }

}
