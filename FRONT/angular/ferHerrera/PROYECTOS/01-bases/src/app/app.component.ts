import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  public title :string = 'Hola mundo';
  public counter :number = 10;
  public persona :{} =  {
    id: 1,
    nombre: 'John',
    apellido: 'McKinley'
  };

  increaseBy(value: number) :void {
    if (this.counter === 0) return;
    this.counter += value;
  }

  resetCounter(){
    this.counter = 10;
  }

  //---------------------------------------
  //---------------------------------------
  calculate(type: string, value: number) :void {
    //->1.Establece logica
    const operations :Operations = {
      increment: () => {
        this.counter += value;
      },
      decrement: () => {
        if (this.counter === 0) return;
        this.counter += value;
      }
    };

    //->2.Ejecuta logica
    const operation = operations[type];
    (operation)
      ? operation()
      : console.error(`Type of invalid operation: ${type}`);
  }
}
interface Operations {
    [type: string]: () => void;
}
