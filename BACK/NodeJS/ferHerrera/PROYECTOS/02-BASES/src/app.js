// console.log('hola mundo desde app.js')
//----------------------------------------

/**SYLLABUS ~ TEMARIO */
// N01_export_imports();
// N02_destructuring();
// N03_callbacks();
// N04_arrowFunctions();
N05_factoryFunction();




/**FUNCTIONS */
function N01_export_imports() {
    console.log('IMPORTS-EXPORTS');
    require('./js-foundation/01-template'); //->Ejecutar todo el archivo
}
function N02_destructuring() {
    require('./js-foundation/02-destructuring');
}
function N03_callbacks() {
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
function N05_factoryFunction() {
    /** Es una <funcion> que, FABRICA<UNA-FUNCION> */
    const makeBuildFunction =  () => {
        //->Es una funcion<makeBuildFunction> que, ...
        return  /*FABRICA<UNA-FUNCION>*/() => {
            return {
                //->logica-funcion-fabricada
            }
        }
    };

    //.................................................
    const {
        get_uuidv4_PLGN,
        getAge_PLGN
    } = require('./plugins/index.js');

    //->"makeFunctionBuildPerson" Funcion-para-crear:
    //->    -Nuevas instancias o objetos de tipo persona
    const {makeFunctionBuildPerson} = require('./js-foundation/05-factory-function.js');
    const makePerson = makeFunctionBuildPerson({get_uuidv4_PLGN, getAge_PLGN});

    const personB = {name: 'Bryan', birthday: '2013-12-24'};
    const BRYAN= makePerson(personB);

    console.log(BRYAN);
}
function N06_() {
    require('./js-foundation/0-');
}
function N07_() {
    require('./js-foundation/0-');
}
function N08_() {
    require('./js-foundation/0-');
}
function N09_() {
    require('./js-foundation/0-');
}
function N10_() {
    require('./js-foundation/0-');
}
function N1_() {
    require('./js-foundation/1-');
}
function N1_() {
    require('./js-foundation/1-');
}