//->IMPORTACIONES-ANGULAR
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

//->IMPORTACIONES-DE-TERCEROS
// import { TercerosModule } from '@terceros/terceros.component';

//->IMPORTACIONES-NUESTRAS
import { HeroComponent } from './hero/hero.component';
import { ListComponent } from './list/list.component';



@NgModule({
    /** -> RUTA:          01-bases\src\app\heroes
   * Declaracion de componentes contenidos
   * que solo podran ser usados dentro del SCOPE ó RUTA
   */
  declarations: [
    HeroComponent,
    ListComponent
  ],
  /** (Componentes y Modulos) que pueden ser consumidos fuera de la RUTA
   * ->EJEMPLO:
   *    -Todos los COMPONENTES de este MODULO."HeroModule", se consumen:
   *        - desde el MODULO"AppModule" ~~ imports: [HeroModule]
   */
  exports: [
    HeroComponent,
    ListComponent
  ],
  imports: [
    CommonModule
  ]
})
export class HeroModule { }
