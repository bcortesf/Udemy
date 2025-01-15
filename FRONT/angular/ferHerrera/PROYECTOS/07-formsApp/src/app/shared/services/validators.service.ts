import { Injectable } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, ValidationErrors } from '@angular/forms';


/**
 * Centralizar tod0 lo que va a nuestras validaciones personalizadas en:
 * src\app\shared\validators\helpers.validators.ts
 */
@Injectable({
  providedIn: 'root'
})
export class ValidatorsService {
  /**VALIDACIONES CAMPOS FORMULARO */

  public firstNameAndLastnamePattern: string = '([a-zA-Z]+) ([a-zA-Z]+)';
  public emailPattern: string = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";

  //-> @param control   :control.value = 'strider': es un usuario
  public cantBeStrider_FormControl = (control: FormControl): ValidationErrors | null => {
    const value: string = (control.value as string).trim().toLowerCase();
    const isNickStrider = this.findByWord_strider(value);
    //->Retornar un objeto error
    if ( isNickStrider ) {
      return {
        isStrider: true,
        user: 'En la base de datos, el usuario "strider", ya existe. ¡Escriba otro nick!'
      };
    }
    //-> No existen errores ~~ El usuario es valido y no existe en BD
    return null
  }


  public isFieldOneEqualsFieldTwo(field1: string, field2: string) {
    /** Promesa()  ó  Observable(Emite,Resuelve-valores)
     * formGroup: parametro que amarra al formulario 'myform' en "register-page.component"
     */
    return (formGroup: AbstractControl): ValidationErrors | null => {
      const fieldValue1 = formGroup.get(field1)?.value;         //->['password']
      const fieldValue2 = formGroup.get(field2)?.value;         //->['password2']

      const field2Errors = formGroup.get(field2)?.errors;


      //ERROR-CONTRASEÑAS: no son iguales
      if (fieldValue1 !== fieldValue2) {
        formGroup.get(field2)?.setErrors( { notEqual: true } ); //-><nivel(INPUT)> ~~ ['password2']
        return { notEqual: true }                               //-><nivel(FORMULARIO)>
      }

      //----------------FORMA-#1------------------------------------------------
      /* Remover-todos-los-errores;  pero afecta a otras validaciones propias */
      // formGroup.get(field2)?.setErrors(null);
      //----------------FORMA-#2------------------------------------------------
      // if (formGroup.get(field2)?.hasError('notEqual')) {
      //   delete formGroup.get(field2)?.errors?.['notEqual']
      //   formGroup.get(field2)?.updateValueAndValidity();
      // }
      //----------------FORMA-#3------------------------------------------------
      delete formGroup.get(field2)?.errors?.['notEqual'];
      //------------------------------------------------------------------------

      //-> si los dos campos son iguales: LA FUNCION LIMPIA LA VALIDACION
      return null;
    }
  }


  /**--------------------------------------------------------------------------------- */
  /**--------------------------------------------------------------------------------- */
  /**FORMULARIO-GENERICO */

  //->VALIDAR: CAMPO-VALIDO (ERRORES-FORMULARIO)
  public isValidfield(form: FormGroup, field: string): boolean | null {
    return form.controls[field].errors
      && form.controls[field].touched;
  }


  /**--------------------------------------------------------------------------------- */
  /**--------------------------------------------------------------------------------- */
  private findByWord_strider = (string: string): boolean => {
    return this.stringContainsWord(string, 'strider');
  }

  /**
   * GENERICA: busca si una palabra esta contenida en un texto
   * @param string  :strings digitado por usuario
   * @param word    :palabra contenida
   * @returns
   */
  private stringContainsWord = (string: string, word: string): boolean => {
    //Crear patron regex usando una variable
    const patronRegex: RegExp = new RegExp(`\\b${word}\\b`);
    // Verificar si la cadena contiene la palabra 'mundo'
    return patronRegex.test(string);
  }
  /**--------------------------------------------------------------------------------- */
}
