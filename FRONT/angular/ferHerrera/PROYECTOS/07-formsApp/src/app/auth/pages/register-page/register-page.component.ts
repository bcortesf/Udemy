import { Component, OnChanges, SimpleChanges } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { cantBeStrider_FormControl, emailPattern, findByWord_strider, validFrmCtrl_formatNameLastname } from '../../../shared/validators/helpers.validators';
import * as customValidators                                                                            from '../../../shared/validators/helpers.validators';
import { ValidatorsService } from '../../../shared/services/validators.service';
import { EmailValidatorService } from '../../../shared/services/email-validator.service';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrl: './register-page.component.css'
})
export class RegisterPageComponent {

  public myform: FormGroup = this.fb.nonNullable.group(
    {
      // namee: ['', [Validators.required, validFrmCtrl_formatNameLastname], []],                                                    //:helper.validator ->funcion-constante
      // namee: ['', [Validators.required, Validators.pattern(customValidators.firstNameAndLastnamePattern)], []],                   //:helper.validator ->constante
      namee: ['', [Validators.required, Validators.pattern(this.validatorsService.firstNameAndLastnamePattern)], []],                //:service          ->metodo-singleton

      // email: ['', [Validators.required,  Validators.pattern(emailPattern)], []],                                                  //:helper.validator ->constante
      // email: ['', [Validators.required,  Validators.pattern(customValidators.emailPattern)], []],                                 //:helper.validator ->constante
      // email: ['', [Validators.required,  Validators.pattern(this.validatorsService.emailPattern)], []],                           //:helper.validator ->constante
      // email: ['', [Validators.required,  Validators.pattern(this.validatorsService.emailPattern)], [new EmailValidatorService]],  //:email.service    ->nueva inicializacion-asincrona
      email: ['', [Validators.required,  Validators.pattern(this.validatorsService.emailPattern)], [this.emailValidatorService]],    //:email.service    ->unica inializacion-singleton-asincrona

      // username: ['', [Validators.required, cantBeStrider_FormControl], []],                                                       //:helper.validator ->funcion-constante
      username: ['', [Validators.required, this.validatorsService.cantBeStrider_FormControl], []],

      password: ['', [Validators.required, Validators.minLength(6)], []],
      password2: ['', [Validators.required], []],
    },
    {
      validators: [
        //->Los validadores pasan como argumento implicito:
        //-> - A todos los campos del formulario
        this.validatorsService.isFieldOneEqualsFieldTwo('password', 'password2')
      ]
    }
  );

  constructor(private fb: FormBuilder
    , private validatorsService: ValidatorsService
    , private emailValidatorService: EmailValidatorService
  ){}


  onSave(): void {
    if (this.myform.invalid) {
      this.myform.markAllAsTouched();
      return;
    }

    console.log(this.myform.controls);
  }

  isValidField(field :string): boolean | null {
    // TOD: obtener validacion desde un servicio
    return this.validatorsService.isValidfield(this.myform, field);
  }


}

// ---------------------------------------------------
/**TEST-FAST */
const isStringStrider:boolean = findByWord_strider
  ( 'hola strider como estas' );
// console.log( isStringStrider );
// ---------------------------------------------------
