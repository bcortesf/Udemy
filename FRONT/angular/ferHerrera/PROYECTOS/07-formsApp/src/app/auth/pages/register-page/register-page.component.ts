import { Component, OnChanges, SimpleChanges } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { cantBeStrider_FormControl, emailPattern, findByWord_strider, validFrmCtrl_formatNameLastname } from '../../../shared/validators/validators-helpers-functions';
import * as customValidators                                                                            from '../../../shared/validators/validators-helpers-functions';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrl: './register-page.component.css'
})
export class RegisterPageComponent implements OnChanges {

  public myform: FormGroup = this.fb.nonNullable.group({
    namee: ['', [Validators.required, Validators.pattern(customValidators.firstNameAndLastnamePattern)], []],

    // email: ['', [Validators.required,  Validators.pattern(emailPattern)], []],
    email: ['', [Validators.required,  Validators.pattern(customValidators.emailPattern)], []],

    username: ['', [Validators.required, cantBeStrider_FormControl], []],
    password: ['', [Validators.required, Validators.minLength(6)], []],
    password2: ['', [Validators.required], []],
  });

  constructor(private fb: FormBuilder){}
  ngOnChanges(changes: SimpleChanges): void {
    console.log('cambios: ', changes);
  }

  onSave(): void {
    console.log(this.myform.controls['namee']);

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
// console.log( isStringStrider );
// ---------------------------------------------------
