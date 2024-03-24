import { FormControl, ValidationErrors } from "@angular/forms";
import { Patterns } from "./expresion-regular.pattern";

/**-------------------------------------------------------------------- */
/**
 * GENERICA: busca si una palabra esta contenida en un texto
 * @param string  :strings digitado por usuario
 * @param word    :palabra contenida
 * @returns
 */
const stringContainsWord = (string: string, word: string): boolean => {
  //Crear patron regex usando una variable
  const patronRegex: RegExp = new RegExp(`\\b${word}\\b`);
  // Verificar si la cadena contiene la palabra 'mundo'
  return patronRegex.test(string);
}

export const findByWord_strider = (string: string): boolean => {
  return stringContainsWord(string, 'strider');
}
/**-------------------------------------------------------------------- */


/**
 * 'strider': es un usuario
 * @param control
 * @returns
 */
export const cantBeStrider_FormControl = (control: FormControl): ValidationErrors | null => {
  const value: string = (control.value as string).trim().toLowerCase();
  const isNickStrider = findByWord_strider(value);
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

export const validFrmCtrl_formatNameLastname = (control: FormControl): ValidationErrors | null => {
  const value: string = (control.value as string).trim().toLowerCase();
  //Crear patron regex usando una variable
  /** "frase correcta"            :VALIDO
   *  "frase correcta incorrecto" :INVALIDO
   * const regex = /^[A-Za-z]+(\s[A-Za-z]+){0,1}$/;              //->VARIABLE-DIRECTA: (antepone al inicio'/' y final'/')
   * const regex = new RegExp('^[A-Za-z]+(\\s[A-Za-z]+){0,1}$'); //ESCAPAR EL '\', Y OMITE (inicio'/' y final'/')
   */
  const regex: RegExp = new RegExp(Patterns.isTwoWord);

  // Verificar si la cadena cumple con dos palabras cualquiera: 'hola mundo'
  const isTwoWord: boolean = regex.test(value);
  if ( !isTwoWord ) {
    //->Retornar un objeto error
    return {
      IsItExactly2Words: false,
      nameLasname: 'Solo escriba primer nombre y primer apellido. (debe ser dos palabras)'
    };
  }
  //-> No existen errores ~~ El usuario es valido y no existe en BD
  return null
}



export const firstNameAndLastnamePattern: string = '([a-zA-Z]+) ([a-zA-Z]+)';
/**
 * .[a-z]{2,4} : 2-letras - hasta 4Letras (despues del punto final o del punto del dominio)
 */
export const emailPattern: string = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";
