/**
 * * --------------------------------------------------------------
 * IMPLEMENTADO EN:
 *      PROYECTOS\02-BASES\src\js-foundation\05-factory-function.js
 * ----------------------------------------------------------------
 *
 * PATRON-ADAPTADOR:
 * El dia que cambie la implementacion por otro paquete de otro tercero.
 * Solo se debe cambiar:                      require('uuid'):
 *  - por el paquete nuevo de otro tercero:   require('nuevo-paquete-tercero')
 *
 * https://www.npmjs.com/package/uuid
 */

const { v4: uuid_v4 } = require('uuid');

/**
 * PATRON ADAPTADOR
 *  - se adapta el tipo de retorno en un unico archivo, donde solo cambio el paquete a otra libreria de un tercero
 * @returns : se retorna : <uuid_v4()> ó <crypto.randomUUID()>
 */
const get_uuidv4_PLGN =  () => {
    return uuid_v4();
    // return crypto.randomUUID()
}


module.exports = {
    get_uuidv4_PLGN
}