/**NEVER
 * Funcion que debe terminar en un error
 */

const ERROR_REQUIRED = () :never => {
    const msj = 'SIEMPRE TERMINO EN ERROR';
    throw new Error(msj);
}
// ERROR_REQUIRED();


//////////////////////////////////////////
const error = (isError: boolean, msjError :string) :never|string => {
    if (isError) {
        throw new Error(msjError);
    }
    return 'Exitoso'
}
console.log( error(false, 'No muestra este mensaje y no hay error') );
console.log( error(true, 'MENSAJE ERROR') );