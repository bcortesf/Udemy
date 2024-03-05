import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomePageComponent } from './shared/pages/home-page/home-page.component';
import { AboutPageComponent } from './shared/pages/about-page/about-page.component';
import { ContactPageComponent } from './shared/pages/contact-page/contact-page.component';

const routes: Routes = [
  // { path: 'home',  component: HomePageComponent },

  /***************************
   * SHARED
   * OJO: src\app\shared\pages
   * *************************/
  {
    path: '',
    component: HomePageComponent
  },
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
   * ************************************************/
  {
    path: 'countries',
    component: ContactPageComponent
  },


  {
    //->Cualquier ruta que no se encuentre; Redirigir url "home"
    path: '**',
    redirectTo: 'home'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: [],
  providers: [],
})
export class AppRoutingModule { }
