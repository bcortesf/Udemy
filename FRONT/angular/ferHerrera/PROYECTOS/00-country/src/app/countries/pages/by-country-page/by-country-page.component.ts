import { Component } from '@angular/core';
import { Country } from '../../interfaces/country';
import { SearchService } from '../../services/countries.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'country-by-country-page',
  templateUrl: './by-country-page.component.html',
  styleUrl: './by-country-page.component.css'
})
export class ByCountryPageComponent {

  countries: Country[] = [];


  constructor(private service: SearchService){}

  /**term = termino-de-busqueda */
  searchByCountry(term: string) :void {
    console.log('OUTPUT_DESDE_PADRE<BY-COUNTRY>:');
    console.log({term});
    this.service.searchCountryByFilter(term).subscribe({
      next: (data: Country[]) => {
        this.countries = data;
        console.log({countries: this.countries});
      },
      error: (errorResp: HttpErrorResponse) => {
        console.error(errorResp);
        this.countries = [];
      },
      complete: () => { /*console.info('¡termina servicio con exito!')*/ }
    });
  }

}
