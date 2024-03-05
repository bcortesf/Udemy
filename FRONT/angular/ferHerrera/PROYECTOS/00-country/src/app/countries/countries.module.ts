import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ByCapitalPageComponent } from './pages/by-capital-page/by-capital-page.component';
import { ByCountryPageComponent } from './pages/by-country-page/by-country-page.component';
import { ByRegionPageComponent } from './pages/by-region-page/by-region-page.component';
import { CountriesPageComponent } from './pages/country-page/country-page.component';
import { CountriesRoutingModule } from './countries-routing.module';



@NgModule({
  declarations: [
    ByCapitalPageComponent,
    ByCountryPageComponent,
    ByRegionPageComponent,
    CountriesPageComponent
  ],
  exports: [
    CountriesPageComponent
  ],
  imports: [
    CommonModule,
    CountriesRoutingModule //->Rutas-modulo-country
  ]
})
export class CountryModule { }
