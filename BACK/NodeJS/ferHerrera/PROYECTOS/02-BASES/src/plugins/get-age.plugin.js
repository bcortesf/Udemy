/**
 * * --------------------------------------------------------------
 * IMPLEMENTADO EN:
 *      PROYECTOS\02-BASES\src\js-foundation\05-factory-function.js
 * ----------------------------------------------------------------
 *
 * PATRON-ADAPTADOR:
 * El dia que cambie la implementacion por otro paquete de otro tercero.
 * Solo se debe cambiar:                      require('get-age'):
 *  - por el paquete nuevo de otro tercero:   require('nuevo-paquete-tercero')
 *
 * https://www.npmjs.com/package/get-age
 */
const  getAgePlugin = require('get-age');
/**
 * @param {*} birthday :string
 * @returns :numero de años
 */
const getAge_PLGN =  (birthday) => {
    if (!birthday) {
        // return null
        return new Error('birthday is required');
    }
    return getAgePlugin(birthday)
};


module.exports = {
    getAge_PLGN
};