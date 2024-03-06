import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, catchError, of, throwError } from 'rxjs';
import { Country } from '../interfaces/country';

@Injectable({providedIn: 'root'})
export class SearchService {

  private apiURL: string = 'https://restcountries.com/v3.1';

  constructor(private http: HttpClient) { }

  /**VERSION.1 */
  searchCapitalByFilter(term: string) : Observable<Country[]> {
    const URL: string = `${this.apiURL}/capital/${term}`;
    return this.http.get<Country[]>(URL).pipe(
      catchError((errorService: HttpErrorResponse) => {
        return throwError( ()=> errorService);
      })
    );
  }

  /**VERSION.2.1 */
  searchCapitalByFilter_v21(term: string) : Observable<Country[]> {
    const URL: string = `${this.apiURL}/capital/${term}`;
    return this.http.get<Country[]>(URL).pipe(
      catchError((errorService: HttpErrorResponse) => of([]))
    );
  }
  /**VERSION.2.2 */
  searchCapitalByFilter_v22(term: string) : Observable<Country[]> {
    const URL: string = `${this.apiURL}/capital/${term}`;
    return this.http.get<Country[]>(URL).pipe(
      catchError((errorService: HttpErrorResponse) => {
        return of([]);
      })
    );
  }

}
