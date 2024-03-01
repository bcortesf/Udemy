import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  public title :string = 'Hola mundo';
  public persona :{} =  {
    id: 1,
    nombre: 'John',
    apellido: 'McKinley'
  };

}
