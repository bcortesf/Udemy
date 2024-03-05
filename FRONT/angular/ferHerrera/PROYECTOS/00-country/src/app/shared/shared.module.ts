import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { AboutPageComponent } from './pages/about-page/about-page.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { RouterModule } from '@angular/router';
import { ContactPageComponent } from './pages/contact-page/contact-page.component';
import { CountryModule } from '../countries/countries.module';



@NgModule({
  declarations: [
    AboutPageComponent,
    ContactPageComponent,
    HomePageComponent,
    SidebarComponent,
  ],
  exports: [
    // AboutPageComponent,
    // HomePageComponent,
    // ContactPageComponent,
    SidebarComponent
  ],
  imports: [
    CommonModule,
    RouterModule, //->RUTA-PRINCIPAL
    CountryModule //->RUTAS-HIJAS
  ]
})
export class SharedModule { }
