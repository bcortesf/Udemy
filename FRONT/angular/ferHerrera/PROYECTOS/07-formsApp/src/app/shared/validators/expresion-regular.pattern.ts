import { EmailValidator } from "@angular/forms";

/**
 * PROBAR-EXPERESION "->Directa" en:
 * https://regexr.com/
 */
export enum Patterns {
  //NameAndLastname = /^\s*(\b[a-zA-Z]+\b\s*){1,2}\s*$/;    //NORMAL
  NameAndLastname   = '^\\s*(\\b[a-zA-Z]+\\b\\s*){1}\\s*$', //ESCAPANDO-CARACTER-POR-SINTAXIS-LENGUAJE
  CantBeStrider = ``,

  isOneWord = '^[A-Za-z]+$',
  /**
   * https://es.javascript.info/regexp-escaping
   *     '/^[A-Za-z]+(   \   s[A-Za-z]+){0,1}$/'
   */
  isTwoWord = '^[A-Za-z]+(\\s[A-Za-z]+){0,1}$', //->ESCAPANDO-CARACTER-'\'-POR-SINTAXIS-LENGUAJE
  email = '^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$'
}
