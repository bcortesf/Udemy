import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
// import { CountriesRoutingModule } from './countries/countries-routing.module';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
    //-> 2.Importa el modulo que contiene "rutas" de navegacion
    // ,CountriesRoutingModule    ://->se omite, porque se carga mediante LAZY-LOADING en "app.routing.module"
    ,HttpClientModule //->peticionesHTTP en service
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
