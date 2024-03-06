import { Component } from '@angular/core';
import { Region } from '../../interfaces/region';
import { SearchService } from '../../services/countries.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'country-by-region-page',
  templateUrl: './by-region-page.component.html',
  styleUrl: './by-region-page.component.css'
})
export class ByRegionPageComponent {

  regions: Region[] = [];

  constructor(private service: SearchService){}

  /**term = termino-de-busqueda */
  searchByRegion(term: string) :void {
    console.log('OUTPUT_DESDE_PADRE<BY-REGION>:');
    console.log({term});
    this.service.searchRegionByFilter(term).subscribe({
      next: (data: Region[]) => {
        this.regions = data;
        console.log({regions: this.regions});
      },
      error: (errorResp: HttpErrorResponse) => {
        console.error(errorResp);
        this.regions = [];
      },
      complete: () => { /*console.info('¡termina servicio con exito!')*/ }
    });
  }

}
