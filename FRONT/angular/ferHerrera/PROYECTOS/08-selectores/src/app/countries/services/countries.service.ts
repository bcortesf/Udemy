import { Injectable } from '@angular/core';
import { Region } from '../interfaces/country.interfaces';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CountriesService {

  private _regions: Region[] = [
    Region.Africa, Region.Americas, Region.Asia,
    Region.Europe, Region.Oceania
  ]

  constructor(private http: HttpClient) { }


  get regions(): Region[] {
    /**
     * Por si alguiien modifica en un componente a "regions"
     *   -No va a modificar el arreglo original por REFERENCIA
     *   -Solo modifica el arreglo cpiado por VALOR
     */
    return [ ...this._regions ];
  }
}
