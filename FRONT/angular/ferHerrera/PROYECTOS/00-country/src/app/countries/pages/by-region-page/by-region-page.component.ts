import { Component, OnInit } from '@angular/core';
import { Region } from '../../interfaces/region.interface';
import { SearchService } from '../../services/countries.service';
import { HttpErrorResponse } from '@angular/common/http';
import { RegionType } from '../../interfaces/region.type';



@Component({
  selector: 'country-by-region-page',
  templateUrl: './by-region-page.component.html',
  styleUrl: './by-region-page.component.css'
})
export class ByRegionPageComponent implements OnInit {

  public isLoading:boolean= false;
  public regions: Region[] = [];

  public selectedRegion?: RegionType;

  /**FORMA-1: DEFINICIO EXACTA POR TYPE */
  public regionTypes: RegionType[]
  = ['Africa', 'Americas', 'Asia', 'Europe', 'Oceania'];
  /**FORMA-2: DEFINICIO EXACTA POR STRINGS */
  // public regionStrings: ['Africa', 'Americas', 'Asia', 'Europe', 'Oceania']
  //  = ['Africa', 'Americas', 'Asia', 'Europe', 'Oceania'];


  constructor(private service: SearchService){}

  ngOnInit(): void {
    this.selectedRegion = this.service.cacheStore.byRegion.regionSelected;
    this.regions = this.service.cacheStore.byRegion.regions;
  }

  /**term = termino-de-busqueda */
  searchByRegion(termRegion: RegionType) :void {
    this.selectedRegion = termRegion;
    this.isLoading = true;
    this.service.searchRegionByFilter(termRegion).subscribe({
      next: (data: Region[]) => {
        this.regions = data;
        console.log({regions: this.regions});
      },
      error: (errorResp: HttpErrorResponse) => {
        console.error(errorResp);
        this.regions = [];
        this.isLoading = false;
      },
      complete: () => { /*console.info('¡termina servicio con exito!')*/
        this.isLoading = false;
      }
    });
  }

}
