import { FormControl } from "@angular/forms";

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


/**
 * 'strider': es un usuario
 * @param control
 * @returns
 */
export const cantBeStrider_FormControl = (control: FormControl) => {
  const value: string = (control.value as string).trim().toLowerCase();
  const isNickStrider = findByWord_strider(value);
  if ( isNickStrider ) {
    return {
      isStrider: true,
      user: 'En la base de datos, el usuario "strider", ya existe. ¡Escriba otro nick!'
    };
  }

  //-> No existen errores ~~ El usuario es valido y no existe en BD
  return null

}
