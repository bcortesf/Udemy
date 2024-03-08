import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, catchError, delay, map, of, tap, throwError } from 'rxjs';
import { Capital } from '../interfaces/capital';
import { Country } from '../interfaces/country';
import { Region } from '../interfaces/region';
import { CountryFilteredCode } from '../interfaces/country-filtered-code';

@Injectable({providedIn: 'root'})
export class SearchService {

  private apiURL: string = 'https://restcountries.com/v3.1';

  constructor(private http: HttpClient) { }

  /////////////////////////////////////////////////////////////
  /**
   * SI EXISTE UN METODO QUE RETORNE UN OBSERVABLE;
   * Y LA RESPUESTA RETORNADA SE REPIDE MAS DE DOS VES
   * EJEMPLO
   *  - Si tuviera DOS-METODOS que devuelven un arrego(Capital[]) */
  private getCapitalHttpRequest(URL: string) : Observable<Capital[]> {
    // const URL: string = `${this.apiURL}/capital/san`;
    return this.http.get<Capital[]>(URL).pipe(
      catchError(() => of([]) ),
      delay(2000)//->1.obtiene-informacion-por-get,  2.hace-un-delay-para-entregar-respuesta
    );
  }
  searchCapitalByFilter(term: string) : Observable<Capital[]> {
    // https://restcountries.com/v3.1/capital/san
    const URL: string = `${this.apiURL}/capital/${term}`;
    return this.getCapitalHttpRequest(URL);
  }

  /////////////////////////////////////////////////////////////
  searchCountryByFilter(term: string) : Observable<Country[]> {
    // https://restcountries.com/v3.1/name/costa
    const URL: string = `${this.apiURL}/name/${term}`;
    return this.http.get<Country[]>(URL).pipe(
      catchError((errorService: HttpErrorResponse) => {
        return throwError( ()=> errorService);
      })
    );
  }

  searchRegionByFilter(term: string) : Observable<Region[]> {
    // https://restcountries.com/v3.1/region/america
    const URL: string = `${this.apiURL}/region/${term}`;
    return this.http.get<Region[]>(URL).pipe(
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
