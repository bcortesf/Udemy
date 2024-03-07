import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { SearchService } from '../../services/countries.service';
import { CountryFilteredCode } from '../../interfaces/country-filtered-code';
import { HttpErrorResponse } from '@angular/common/http';
import { map, switchMap, tap } from 'rxjs';

@Component({
  selector: 'country-country-page',
  templateUrl: './country-page.component.html',
  styleUrl: './country-page.component.css'
})
export class CountriesPageComponent implements OnInit {

  public paramCodeId: string | undefined;

  public countryFilteredCode: CountryFilteredCode | null = null;

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private service: SearchService
    ) {}

    //->Crear-una-propiedad en base a un objeto
    get translations() {
      return Object.values(this.countryFilteredCode!.translations);
    }

  ngOnInit(): void {
    // switchMap( ({id}) => this.service.searchCountryByAlphaCode(id) )

    // switchMap( (params:Params) => this.service.searchCountryByAlphaCode(params['id']) ),
    // map( (params:Params) => {
    //   this.paramCodeId = params['id'];
    //   return params;
    // }),

    /**FORMA #1 */ //this.paramCodeId = params['id'] as string;
    this.activatedRoute.params.pipe(
      tap( (params)=> this.paramCodeId= String(params['id'])),
      switchMap( (params:Params) => this.service.searchCountryByAlphaCode(params['id']) )
    )
    .subscribe((data: CountryFilteredCode | null) => {
      if (!data) {
        return this.router.navigateByUrl('');
      }
      // return //->CON LOADING
      return this.countryFilteredCode = data;
    });


    /**FORMA #2 */
    // this.activatedRoute.params.pipe(
    //   switchMap( (params:Params) => this.service.searchCountryByAlphaCode_v2(params['id']) )
    // )
    // .subscribe({
    //   next: (data: CountryFilteredCode[]) => {
    //     this.countryFilteredCode = data[0];
    //     console.log(this.countryFilteredCode);

    //   },
    //   error: (errorResp: HttpErrorResponse) => {
    //     console.error('No-existe', errorResp);
    //     this.countryFilteredCode = null;
    //   },
    //   complete: () => { /*console.info('¡termina servicio con exito!')*/ }
    // });


    /**FORMA #1 */
    // this.activatedRoute.params.subscribe((params:Params) => {
    //   console.log({params});
    //   this.paramCodeId = params['id'] as string;

    //   this.searchCountryByAlphaCode_v2(this.paramCodeId);
    // })
  }

  /**term = termino-de-busqueda */
  searchCountryByAlphaCode_v2(term: string) :void {
    this.service.searchCountryByAlphaCode_v2(term).subscribe({
      next: (data: CountryFilteredCode[]) => {
        this.countryFilteredCode = data[0];
        console.log(this.countryFilteredCode);

      },
      error: (errorResp: HttpErrorResponse) => {
        console.error('No-existe', errorResp);
        this.countryFilteredCode = null;
      },
      complete: () => { /*console.info('¡termina servicio con exito!')*/ }
    });
  }

}
