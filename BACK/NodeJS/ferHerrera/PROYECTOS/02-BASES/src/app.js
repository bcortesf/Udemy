// console.log('hola mundo desde app.js')
//----------------------------------------

/**SYLLABUS ~ TEMARIO */
// N01_export_imports();
// N02_destructuring();
// N03_callbacks();
N04_arrowFunctions();




/**FUNCTIONS */
function N01_export_imports() {
    console.log('IMPORTS-EXPORTS');
    require('./js-foundation/01-template'); //->Ejecutar todo el archivo
}
function N02_destructuring() {
    require('./js-foundation/02-destructuring');
}
function N03_callbacks() {
    // require('./js-foundation/03-callbacks.js');

    //->DESTRUCTURACION
    const {
        findUserById_void,
        encontrarUsuarioPorId_vacio,
        findUserById_CALLBACK
    } = require('./js-foundation/03-callbacks.js');

    //->FUNCIONES-SIMPLES
    // findUserById_void(1);
    // encontrarUsuarioPorId_vacio(2);

    /**
     * **FUNCION-CALLBACK**
     *      ->funcion que devuelve dos valores ~ <ERROR, OK-DATA>
     */
    const id = 1;
    findUserById_CALLBACK(id, function (error, okData) {
        if (error) {
            throw new Error( error );
        }
        console.log('DESDE "APP.js"');
        console.log(okData);
    });
}
function N04_arrowFunctions() {
    //->DESTRUCTURACION
    const {
        findUserById_CALLBACK
    } = require('./js-foundation/04-arrowfunctions.js');

    /**
     * **FUNCION-CALLBACK**
     *      ->funcion que devuelve dos valores ~ <ERROR, OK-DATA>
     */
    const id = 1;
    findUserById_CALLBACK(id, (error, okData) => {
        if (error) {
            throw new Error( error );
        }
        console.log('DESDE "APP.js"');
        console.log(okData);
    });
}
function N05_() {
    require('./js-foundation/0-.js');
}
function N06_() {
    require('./js-foundation/0-.js');
}
function N07_() {
    require('./js-foundation/0-.js');
}
function N08_() {
    require('./js-foundation/0-.js');
}
function N09_() {
    require('./js-foundation/0-.js');
}
function N10_() {
    require('./js-foundation/0-.js');
}
function N1_() {
    require('./js-foundation/1-.js');
}
function N1_() {
    require('./js-foundation/1-.js');
}