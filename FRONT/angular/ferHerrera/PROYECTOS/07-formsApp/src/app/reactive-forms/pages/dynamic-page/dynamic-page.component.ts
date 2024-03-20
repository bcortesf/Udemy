import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ValidationMessages } from '../../interfaces/index.interface';

@Component({
  selector: 'app-dynamic-page',
  templateUrl: './dynamic-page.component.html',
  styleUrl: './dynamic-page.component.css'
})
export class DynamicPageComponent {

  /**
   * ->Manera-tradicional
        public myform2 = new FormGroup({
          favoriteGames: new FormArray([])
        });
   *
   */


  /**CONTROL-INDEPENDIENTE: Agregar-favorito */
  public newFavoriteControlGlobal: FormControl = new FormControl( '', [Validators.required] );

  //---------------------------------------------------------------
  /**FORMULARIO-GENERAL */
  public myForm: FormGroup = this.fb.nonNullable.group({
    namee: ['', [Validators.required, Validators.minLength(3)], []],
    favoriteGames: this.fb.array([
      ['Metal Gear', Validators.required],
      ['Crash Bash', Validators.required]
    ])
  });

    //->ESTABLECER UN OBJETO CON: ERRORES-FORMULARIO
      /**FORMA-TRADICIONAL */
  // validationMessages: {
  //   [key: string]: {[key: string]:string}
  // }
  validationMessages: ValidationMessages
  = {
    namee: {
      required: 'El nombre es requerido',
      minlength: 'El nombre debe ser mayor a 3 caracteres' //->OJO: poner-mismo-numero-de-Validators.minLength(3)
    },
    favoriteGames: {
      required: 'El precio es requerido'
    }
  }

  constructor(private fb: FormBuilder ) {}

  get favoriteGames() {
    // return this.myForm.controls['favoriteGames'] as FormArray;
    return this.myForm.get('favoriteGames') as FormArray;
  }

  onSubmit(): void {
    if (this.myForm.invalid) {
      this.myForm.markAllAsTouched();
      return;
    }
    console.log('data-save:', this.myForm.value);

    this.myForm.reset();

    /**FORMA1: RESET */
    this.myForm.setControl(
      'favoriteGames',
      this.fb.array([
        ['', Validators.required]
      ])
    );

    // this.favoriteGames.clear(); //BORRA-TODOS
  }

  onDeleteFavorite(index: number): void {
    this.favoriteGames.removeAt(index);
  }
  onAddFavorite__REFERENCIA_LOCAL(favoriteGame: string): void {
    // Create a new FormControl for the favorite game
    const newFavoriteControlLocal = new FormControl(favoriteGame);
    newFavoriteControlLocal.addValidators(Validators.required);
    this.favoriteGames.push( newFavoriteControlLocal );
  }
  onAddFavorite__FORM_CONTROL(): void {
    console.log('new-favorite-data: ', this.newFavoriteControlGlobal.value);
    if (this.newFavoriteControlGlobal.invalid) return;
    const newGameValue = this.newFavoriteControlGlobal.value;

    /*->FORMA-1: sino trabajara con formBuilder, seria: */
    this.favoriteGames.push(
      this.fb.control(
        newGameValue, Validators.required
      )
    );
    // ->Borrar-campo-digitado-del-control
    this.newFavoriteControlGlobal.reset();

    // ------------------------------------------------------
    /*->FORMA-2: sino trabajara con formBuilder, seria: */
    // this.favoriteGames.push(
    //   new FormControl( newGameValue, Validators.required )
    // );
    //->Borrar-campo-digitado-del-control
    // this.newFavoriteControlGlobal.reset();

    // ------------------------------------------------------
    /*->FORMA-3: mantiene lo escrito en el input: */
    // this.favoriteGames.push( this.newFavoriteControlGlobal );
    // ------------------------------------------------------
  }


  //->VALIDAR: CAMPO-VALIDO (ERRORES-FORMULARIO)
  isValidField(field: string): boolean | null {
    /**
     * this.myForm.controls[field].errors
     * si  : si tiene errores los muestra
     * sino: es null
     */
    return this.myForm.controls[field].errors
      && this.myForm.controls[field].touched;
  }
  //->VALIDAR: ARRAY-VALIDO (ERRORES-FORMULARIO)
  isValidFieldInArray(formArray: FormArray, index: number): boolean | null {
    return formArray.controls[index].errors
      && formArray.controls[index].touched;
  }


  //->OBTENER: MENSAJE-DEL-CAMPO (ERRORES-FORMULARIO):2
  getFieldError(field: string): string | null {
    if (!this.myForm.controls[field]) return null;

    //->fieldErrors = [required, minLength, min, max, email, pattern, ...etc]
    const fieldErrors = this.myForm.controls[field].errors ?? {};
    for (const keyValidation of Object.keys(fieldErrors)) {
      switch (keyValidation) {
        case 'required': case 'min':
          return this.validationMessages[field][keyValidation];

        case 'minlength': {
          const requiredLength = fieldErrors['minlength']['requiredLength'];
          this.validationMessages[field][keyValidation] = `El ${field} debe ser mayor a ${requiredLength} caracteres`;
          return this.validationMessages[field][keyValidation];
        }
      }
    }
    return null;
  }

}
