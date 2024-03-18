import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'reactive-basic-page',
  templateUrl: './basic-page.component.html',
  styleUrl: './basic-page.component.css'
})
export class BasicPageComponent {
  //->Producto(nombre,precio,#existencia-stock)
  productBegin = {
    name: '',
    price: 0,
    inStorage: 0
  }

  constructor(private fb: FormBuilder) {}


  //-------------------------------------------------------------------------------------
                          /**CREAR FORMULARIO CON: <FORM-GROUP> */

  //->Implica definir para cada atributo un 'FormControl'
  public myform1: FormGroup = new FormGroup({
    /**
     * FormControl(<'valor-default'>,<validacionSincrona>,<validacionAsincrona>)
     * FormControl(<'valor-default'>,<[validacionesSincronas]>,<[validacionesAsincronas]>)
     */
    name: new FormControl('', [], []),
    price: new FormControl(0, [], []),
    inStorage: new FormControl(0, [], [])
  });

  //-------------------------------------------------------------------------------------
                          /**CREAR FORMULARIO CON: <FORM-BUILDER> */

  //->La sintaxis es mas bonita, mas corta por atributo
  public myForm2: FormGroup = this.fb.nonNullable.group(
    {
      //    [<'valor-default'>,<[validacionesSincronas]>,<[validacionesAsincronas]>]
      name: ['', [Validators.required, Validators.minLength(3)], []],
      price: [0, [Validators.required, Validators.min(0)], []],
      inStorage: [0, [Validators.required, Validators.min(0)], []]
    }
  );


  //->ESTABLECER UN OBJETO CON: ERRORES-FORMULARIO
      /**FORMA-TRADICIONAL */
  // validationMessages: {
  //   [key: string]: {[key: string]:string}
  // }
  validationMessages: ValidationMessages
  = {
    name: {
      required: 'El nombre es requerido',
      minlength: 'El nombre debe ser mayor a 3 caracteres'
      // minlength: `El nombre debe ser mayor a ${this.myForm2.controls['name'].errors!['minlength'].requiredLength || {}} caracteres`
    },
    price: {
      required: 'El precio es requerido',
      min: 'El precio debe ser mayor a 0'
    },
    inStorage: {
      required: 'La existencia es requerida',
      min: 'El precio debe ser mayor a 0'
    }
  }



  //->VALIDAR: CAMPO-VALIDO (ERRORES-FORMULARIO)
  isValidField(field: string): boolean | null {
    /**
     * this.myForm2.controls[field].errors
     * si  : si tiene errores los muestra
     * sino: es null
     */
    return this.myForm2.controls[field].errors
      && this.myForm2.controls[field].touched;

  }
  //->OBTENER: MENSAJE-DEL-CAMPO (ERRORES-FORMULARIO)
  getMessageByFieldError(field: string): any {
    const obj = this.myForm2.controls[field].errors as Object ?? 'ok';
    const firstKey:string = Object.keys(obj)[0];
    return this.validationMessages[field][firstKey];
  }


  //-------------------------------------------------------------------------------------
                          /**CREAR FORMULARIO CON: <FORM-ARRAY> */
  //-------------------------------------------------------------------------------------

  onSave():void {
    console.log(this.myForm2);
    if (this.myForm2.invalid){
      this.myForm2.markAllAsTouched();
      return;
    }

    this.showLogForm2();

    //--------------------------------
    // this.resetForm();
    this.resetFormByNameControlField();
    console.log('reset', this.myForm2.value);

  }

  resetForm(): void {
    this.myForm2.reset();
  }
  resetFormByNameControlField(): void {
    this.myForm2.reset(
          /**FORMA: INDEPENDIENTE */
      // { //-><key-nombre-control>: <valor>
      //   price: 10,
      //   inStorage: 0
      // }

          /**FORMA: OBJETO */
      this.productBegin
    );
  }

  showLogForm2(): void {
    console.log('Formulario válido, datos:', {
      valid: this.myForm2.valid,
      pristine: this.myForm2.pristine,
      touched: this.myForm2.touched,
      value: this.myForm2.value,
      precio: this.myForm2.value['price'],
      Producto: this.myForm2.value['name'],
    });
  }

}

interface ValidationMessages {
  [key: string]: {
    [key: string]: string;
  };
}
