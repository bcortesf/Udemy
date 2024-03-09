import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, catchError, delay, map, of, tap, throwError } from 'rxjs';
import { Capital } from '../interfaces/capital.interface';
import { Country } from '../interfaces/country.interface';
import { Region } from '../interfaces/region.interface';
import { CountryFilteredCode } from '../interfaces/country-filtered-code.interface';
import { CacheStore } from '../interfaces/cache-store.interface';
import { RegionType } from '../interfaces/region.type';

/** https://angular.io/guide/providers
 * La diferencia entre (providedIn: root, providedIn: platform, providedIn: any)
 * es la forma en que se proporciona una instancia de un servicio
 * y cómo se comparte esa instancia entre los componentes y módulos en una aplicación.
 *
 * providedIn: root: Singleton, una única instancia para toda la aplicación.
 * providedIn: platform: Crea una instancia única para cada plataforma en la que se ejecute la aplicación.
 * providedIn: any: Transitorio, crea una nueva instancia para cada componente que lo solicite.
 *
 * Su uso depende de la lógica de negocio y los requisitos de la aplicación.
 * Normalmente y por default:
 *  providedIn: root =>
 *    - La opción más común y recomendada para la mayoría de las aplicaciones,
 *      ya que proporciona una única instancia global que puede ser compartida y reutilizada eficiente en toda la aplicación.
 *      Las otras opciones pueden ser útiles en casos específicos donde se necesite tener diferentes instancias del servicio según la plataforma o el componente que lo solicite.
 */
@Injectable({providedIn: 'root'})
export class SearchService {
  private apiURL: string = 'https://restcountries.com/v3.1';

  public cacheStore: CacheStore = {
    byCapital: {term: '', capitals: []},
    byCountry: {term: '', countries: []},
    byRegion:  {regionSelected: '', regions: []}
  };

  constructor(private http: HttpClient) {}
  /////////////////////////////////////////////////////////////
  /**
   * SI EXISTE UN METODO QUE RETORNE UN OBSERVABLE;
   * Y LA RESPUESTA RETORNADA SE REPIDE MAS DE DOS VES
   * EJEMPLO
   *  - Si tuviera DOS-METODOS que devuelven un arrego(Capital[]) */
  private getCapitalHttpRequest(URL: string) : Observable<Capital[]> {
    return this.http.get<Capital[]>(URL).pipe(
      catchError(() => of([]) ),
      // delay(2000)//->1.obtiene-informacion-por-get,  2.hace-un-delay-para-entregar-respuesta
    );
  }
  searchCapitalByFilter(term: string) : Observable<Capital[]> {
    // https://restcountries.com/v3.1/capital/san
    const URL: string = `${this.apiURL}/capital/${term}`;
    return this.getCapitalHttpRequest(URL)
      .pipe(
        /*->almacenar en  "variables-singleton" con servicio configurado: {providedIn: 'root'}*/
        tap( (capitals: Capital[]) => this.cacheStore.byCapital = {term, capitals} )
      );
  }
    //  tap( (capitals: Capital[]) => this.cacheStore.byCapital = {term: term, capitals:capitals} )

    //  tap( (capitals: Capital[]) => {
    //    this.cacheStore.byCapital.capitals = capitals;
    //    this.cacheStore.byCapital.term = term;
    //  })

  /////////////////////////////////////////////////////////////
  searchCountryByFilter(term: string) : Observable<Country[]> {
    // https://restcountries.com/v3.1/name/costa
    const URL: string = `${this.apiURL}/name/${term}`;
    return this.http.get<Country[]>(URL).pipe(
      tap( (countries: Country[]) => this.cacheStore.byCountry = {term, countries} ),
      catchError((errorService: HttpErrorResponse) => {
        return throwError( ()=> errorService);
      })
    );
  }

  searchRegionByFilter(termRegion: RegionType) : Observable<Region[]> {
    // https://restcountries.com/v3.1/region/america
    const URL: string = `${this.apiURL}/region/${termRegion}`;
    return this.http.get<Region[]>(URL).pipe(
      tap( (regions: Region[]) => this.cacheStore.byRegion = {regionSelected:termRegion, regions}),
      catchError((errorService: HttpErrorResponse) => {
        return throwError( ()=> errorService);
      })
    );
  }

  ///////////////////////////////////////////////////////////////////////////////
  searchCountryByAlphaCode(term: string) : Observable<CountryFilteredCode|null> {
    // https://restcountries.com/v3.1/alpha/col
    const URL: string = `${this.apiURL}/alpha/${term}`;
    return this.http.get<CountryFilteredCode[]>(URL).pipe(
      map( (countryFilteredCodes:CountryFilteredCode[]) =>
        (countryFilteredCodes.length > 0) ? countryFilteredCodes[0]: null
      ),
      catchError( ()=> of(null) )
    );
  }
  searchCountryByAlphaCode_v2(term: string) : Observable<CountryFilteredCode[]> {
    // https://restcountries.com/v3.1/alpha/col
    const URL: string = `${this.apiURL}/alpha/${term}`;
    return this.http.get<CountryFilteredCode[]>(URL).pipe(
      catchError((errorService: HttpErrorResponse) => {
        return throwError( ()=> errorService);
      })
    );
  }
  ///////////////////////////////////////////////////////////////////////////////



  /**------------------------------------------------------------
   * ------------------------------------------------------------
   * ------------------------------------------------------------
  */
  /**VERSION.2.1 */
  searchCapitalByFilter_v21(term: string) : Observable<Capital[]> {
    const URL: string = `${this.apiURL}/capital/${term}`;
    return this.http.get<Capital[]>(URL).pipe(
      catchError((errorService: HttpErrorResponse) => of([]))
    );
  }
  /**VERSION.2.2 */
  searchCapitalByFilter_v22(term: string) : Observable<Capital[]> {
    const URL: string = `${this.apiURL}/capital/${term}`;
    return this.http.get<Capital[]>(URL).pipe(
      catchError((errorService: HttpErrorResponse) => {
        return of([]);
      })
    );
  }
  /**VERSION3.3 */
  searchCapitalByFilter_v33(term: string) : Observable<Capital[]> {
    const URL: string = `${this.apiURL}/capital/${term}`;
    return this.http.get<Capital[]>(URL).pipe(
      tap((countries :Capital[]) => {
        console.log('TAP1: implementa alguna-logica-1', countries);
      }),
      map((countries :Capital[]) => []) //devolver y transformar data a: un array vacio
      ,tap((countries :Capital[]) => {
        console.log('TAP2: implementa alguna-logica-2', countries);
      })
    );
  }

}
