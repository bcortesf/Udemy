import { Component } from '@angular/core';
import { SearchService } from '../../services/countries.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Capital } from '../../interfaces/capital';

@Component({
  selector: 'country-by-capital-page',
  templateUrl: './by-capital-page.component.html',
  styleUrl: './by-capital-page.component.css'
})
export class ByCapitalPageComponent {

  capitals: Capital[] = [];
  error: {message:string, status:number} = {message:'', status:0};

  constructor(private service: SearchService){}

  /**term = termino-de-busqueda */
  searchByCapital(term: string) :void {
    console.log('OUTPUT_DESDE_PADRE<BY-CAPITAL>:');
    console.log({term});
    this.service.searchCapitalByFilter(term).subscribe({
      next: (data: Capital[]) => {
        this.capitals = data;
        console.log({countries: this.capitals});
      },
      error: (errorResp: HttpErrorResponse) => {
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
      }
    });
  }

  resetError() {
    this.error = {message:'', status:0};
  }
}
