import { Component, OnInit } from '@angular/core';
import { Country } from '../../interfaces/country.interface';
import { SearchService } from '../../services/countries.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'country-by-country-page',
  templateUrl: './by-country-page.component.html',
  styleUrl: './by-country-page.component.css'
})
export class ByCountryPageComponent implements OnInit {

  countries: Country[] = [];
  isLoading:boolean= false;

  //->hijo<search-box.component>
  public propiedadValue: string = '';


  constructor(private service: SearchService){}

  ngOnInit(): void {
    this.propiedadValue = this.service.cacheStore.byCountry.term;
    this.countries = this.service.cacheStore.byCountry.countries;
  }


  /**term = termino-de-busqueda */
  searchByCountry(term: string) :void {
    console.log('OUTPUT_DESDE_PADRE<BY-COUNTRY>:', {term});
    this.isLoading = true;
    this.service.searchCountryByFilter(term).subscribe({
      next: (data: Country[]) => {
        this.countries = data;
        console.log({countries: this.countries});
      },
      error: (errorResp: HttpErrorResponse) => {
        console.error(errorResp);
        this.countries = [];
        this.isLoading = false;
      },
      complete: () => { /*console.info('¡termina servicio con exito!')*/
        this.isLoading = false;
      }
    });
  }

}
