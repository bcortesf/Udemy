import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { cantBeStrider_FormControl, findByWord_strider } from '../../../shared/validators/validators-helpers-functions';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrl: './register-page.component.css'
})
export class RegisterPageComponent {

  public myform: FormGroup = this.fb.nonNullable.group({
    namee: ['', [Validators.required], []],
    email: ['', [Validators.required], []],
    username: ['', [Validators.required, cantBeStrider_FormControl], []],
    password: ['', [Validators.required, Validators.minLength(6)], []],
    password2: ['', [Validators.required], []],
  });

  constructor(private fb: FormBuilder){}

  onSave(): void {
    if (this.myform.invalid) {
      return;
    }
  }

  isValidField(): boolean | null {
    // TODO: obtener validacion desde un servicio
    return null;
  }


}

// ---------------------------------------------------
/**TEST-FAST */
const isStringStrider:boolean = findByWord_strider
  ( 'hola strider como estas' );
console.log( isStringStrider );
// ---------------------------------------------------
