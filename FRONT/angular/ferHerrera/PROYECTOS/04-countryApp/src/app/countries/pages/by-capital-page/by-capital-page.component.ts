import { Component, OnInit } from '@angular/core';
import { SearchService } from '../../services/countries.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Capital } from '../../interfaces/capital.interface';

@Component({
  selector: 'country-by-capital-page',
  templateUrl: './by-capital-page.component.html',
  styleUrl: './by-capital-page.component.css'
})
export class ByCapitalPageComponent implements OnInit {

  isLoading:boolean= false;
  capitals: Capital[] = [];
  error: {message:string, status:number} = {message:'', status:0};

  //->hijo<search-box.component>
  public propiedadValue: string = '';

  constructor(private service: SearchService){}

  ngOnInit(): void {
    this.capitals = this.service.cacheStore.byCapital.capitals;
    this.propiedadValue = this.service.cacheStore.byCapital.term;
  }

  /**term = termino-de-busqueda */
  searchByCapital(term: string) :void {
    this.isLoading = true;
    this.service.searchCapitalByFilter(term).subscribe({
      next: (data: Capital[]) => {
        //Si es valido  ó  si existe error; entra aqui
        console.log('OUTPUT_DESDE_PADRE<BY-CAPITAL>:', {term});
        this.capitals = data;  //----
        console.log({countries: this.capitals});
      },
      error: (errorResp: HttpErrorResponse) => {
        console.log('ERROR CAPITAL');

        this.capitals = [];
        this.error = errorResp.error;
        console.error( {
          errorResp,
          errorsin: errorResp.error,
          countries: this.capitals
        });
      },
      complete: () => { /*console.info('¡termina servicio con exito!')*/
        this.resetError();
        this.isLoading = false;
      }
    });
  }


  resetError() {
    this.error = {message:'', status:0};
  }
}
