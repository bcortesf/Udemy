import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CounterComponent } from './components/counter/counter.component';



@NgModule({
  /** -> RUTA:          01-bases\src\app\counter
   * Declaracion de componentes contenidos
   * que solo podran ser usados dentro del SCOPE ó RUTA
   */
  declarations: [
    CounterComponent
  ],
  /** (Componentes y Modulos) que pueden ser consumidos fuera de la RUTA
   * ->EJEMPLO:
   *    -Todos los COMPONENTES de este MODULO."CounterModule", se consumen:
   *        - desde el MODULO"AppModule" ~~ imports: [CounterModule]
   */
  exports: [
    CounterComponent
  ],
  imports: []
})
export class CounterModule { }
