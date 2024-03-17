import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomePageComponent } from './shared/pages/home-page/home-page.component';
import { AboutPageComponent } from './shared/pages/about-page/about-page.component';
import { ContactPageComponent } from './shared/pages/contact-page/contact-page.component';

const routes: Routes = [
  // { path: 'home',  component: HomePageComponent },

  // {
  //   path: '',
  //   component: HomePageComponent
  // },

  /***************************
   * SHARED
   * OJO: src\app\shared\pages
   * *************************/
  {
    path: 'about',
    component: AboutPageComponent
  },
  {
    path: 'contact',
    component: ContactPageComponent
  },

  /** ***********************************************
   * COUNTRIES: pertenece a otro MODULO
   * OJO: src\app\country
   * Carga mediante: carga-perezosa
   * ************************************************/
  {
    path: 'countries',
    loadChildren: () => import('./countries/countries.module')
      .then( (m) => m.CountryModule)
  },


  {
    //->Cualquier ruta que no se encuentre; Redirigir url "home"
    // redirectTo: '' = redirectTo: 'home'
    path: '**',
    redirectTo: 'countries'
    // redirectTo: 'countries/by-capital'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
