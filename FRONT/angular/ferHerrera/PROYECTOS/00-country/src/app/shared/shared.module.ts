import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { AboutPageComponent } from './pages/about-page/about-page.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { RouterModule } from '@angular/router';
import { ContactPageComponent } from './pages/contact-page/contact-page.component';
import { SearchBoxComponent } from './components/search-box/search-box.component';
import { LoadingSpinnerComponent } from './components/loading-spinner/loading-spinner.component';




@NgModule({
  declarations: [
    AboutPageComponent,
    ContactPageComponent,
    HomePageComponent,
    SidebarComponent,
    SearchBoxComponent,
    LoadingSpinnerComponent
  ],
  exports: [
    /**LOS COMPONENTES:
     *  - AboutPageComponent, HomePageComponent, ContactPageComponent,...ETC
     *  * NO SE EXPORTAN PORQUE ESTAN:
     *  *    - LLAMADOS  EN: src\app\shared\components\sidebar\sidebar.component.html
     *  *    - ENRUTADOS EN: src\app\app-routing.module.ts
      */
    SidebarComponent

    /**USADO EN MODULOS "countries/{by-capital, by-country, by-region}"  */
    ,SearchBoxComponent
    /**USADO EN MODULO "countries/country-table"  */
    ,LoadingSpinnerComponent
  ],
  imports: [
    CommonModule,
    RouterModule, //->Angular(Routes,RouterLink..etc)
  ]
})
export class SharedModule { }
