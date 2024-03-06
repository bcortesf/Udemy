import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, catchError, map, of, tap, throwError } from 'rxjs';
import { Capital } from '../interfaces/capital';
import { Country } from '../interfaces/country';
import { Region } from '../interfaces/region';

@Injectable({providedIn: 'root'})
export class SearchService {

  private apiURL: string = 'https://restcountries.com/v3.1';

  constructor(private http: HttpClient) { }

  /**VERSION.1 */
  searchCapitalByFilter(term: string) : Observable<Capital[]> {
    // https://restcountries.com/v3.1/capital/san
    const URL: string = `${this.apiURL}/capital/${term}`;
    return this.http.get<Capital[]>(URL).pipe(
      catchError((errorService: HttpErrorResponse) => {
        return throwError( ()=> errorService);
      })
    );
  }

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
