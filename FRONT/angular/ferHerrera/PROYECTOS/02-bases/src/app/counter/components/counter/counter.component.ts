import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-counter',
  templateUrl: './counter.component.html',
  styleUrl: './counter.component.css'
})

export class CounterComponent implements OnInit {
  public counter :number = 10;

  constructor() { }
  ngOnInit() { }


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
