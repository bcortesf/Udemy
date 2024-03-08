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
  isLoading:boolean= false;

  constructor(private service: SearchService){}

  /**term = termino-de-busqueda */
  searchByCapital(term: string) :void {
    this.isLoading = true;
    this.service.searchCapitalByFilter(term).subscribe({
      next: (data: Capital[]) => {
        //Si es valido  ó  si existe error; entra aqui
        console.log('OUTPUT_DESDE_PADRE<BY-CAPITAL>:');
        console.log({term});
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
