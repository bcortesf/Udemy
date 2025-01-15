// console.log('hola mundo desde app.js')
//----------------------------------------

/**SYLLABUS ~ TEMARIO */
// N01_export_imports();
// N02_destructuring();
// N03_callbacks();
// N04_arrowFunctions();
// N05_factoryFunction();
// N06_promise();
// N07_promiseAsyncAwait();
// N08_fetchAPI_PatronAdapter();
N09_LOGGERS_NODE();



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
    // ! Referencia a la función Factory: makeFunctionBuildPerson
    // ! makeFunctionBuildPerson tiene INYECCION-DEPENDENCIAS en los parametros
    const {makeFunctionBuildPerson} = require('./js-foundation/05-factory-function.js');
    const makePerson = makeFunctionBuildPerson({get_uuidv4_PLGN, getAge_PLGN});

    const personB = {name: 'Bryan', birthday: '2013-12-24'};
    const BRYAN= makePerson(personB);

    console.log(BRYAN);
}
function N06_promise() {
    // const findPokemonById_ = require('./js-foundation/06-promise.js');
    // console.log(findPokemonById_); //comprobar que es una funcion
    // console.log(findPokemonById_(11));


    const {
        findPokemonById_callback_promise,     //->tiene CALLBACK
        findPokemonById_callback_chainPromise,//->tiene CALLBACK
        findPokemonById_chainPromise,
        findPokemonById_chainPromise_Error
    } = require('./js-foundation/06-promise.js');

    /** ->2. En la function-arrow poner:
     * *   - La misma cantidad de parametros de "callback1"
     */
    findPokemonById_callback_promise(1, (pokemonDATA)=> {
        // console.log({nombrePokemon: pokemonDATA.name,  pokemonDATA});
    });

    findPokemonById_callback_chainPromise(1, (pokemonDATA)=> {
        // console.log({nombrePokemon: pokemonDATA.name,  pokemonDATA});
    });

    findPokemonById_chainPromise(1)
        .then((pokemonDATA)=> {
            // console.log({nombrePokemon: pokemonDATA.name,  pokemonDATA});
        })
    ;

    findPokemonById_chainPromise_Error(1)
        .then((namePokemon)=> {
            console.log({namePokemon});
        })
        .catch((error) => console.error(`ERROR: ${error}`))
        .finally(() => console.log('Finalmente'))
    ;

}
function N07_promiseAsyncAwait() {
    const {
        findPokemonById
    } = require('./js-foundation/07-promise-async-await.js');

    findPokemonById(1)
        .then((namePokemon)=> {
            console.log({namePokemon});
        })
        .catch((error) => console.error(`Porfavor intente de nuevo - ${error}`))
        .finally(() => console.log('Finalmente'))
    ;
}
function N08_fetchAPI_PatronAdapter() {
    const {
        findPokemonById_,
        findPokemonById_AXIOS
    } = require('./js-foundation/08-FetchAPI-patronAdapter.js');

    findPokemonById_(4)
        .then((namePokemon)=> {
            // console.log({namePokemon});
        })
        .catch((error) => console.error(`Porfavor intente de nuevo - ${error}`))
        // .finally(() => console.log('Finalmente_'))
    ;

    findPokemonById_AXIOS(1)
        .then((namePokemon)=> {
            console.log({namePokemon});
        })
        .catch((error) => console.error(`Porfavor intente de nuevo - ${error}`))
        .finally(() => console.log('Finalmente_AXIOS'))
    ;
}
function N09_LOGGERS_NODE() {
    // require('./js-foundation/0-');
    /**
     * https://www.npmjs.com/package/winston
     * MANEJOR DE LOGGER'S
     *  - Para revisar trazas y logs, en entorno de desarrollo
     *      + Con le fin de no cargar PRODUCCION con ""console.log('')""
     */
    // const { findPokemonById_AXIOS
    // } = require('./js-foundation/08-FetchAPI-patronAdapter.js');

    // findPokemonById_AXIOS(1)
    //     .then((namePokemon)=> {
    //         console.log({namePokemon});
    //     })
    //     .catch((error) => console.error(`Porfavor intente de nuevo - ${error}`))
    //     .finally(() => console.log('Finalmente_AXIOS'))
    // ;


    // https://www.npmjs.com/package/winston
    const { buildLogger } = require('./plugins');//->index.js
    const logger = buildLogger('app.js');
    logger.log('hola mundo; \n   + usando npm.lib<winston> en un logger');
    logger.error('Esto es algo malo');


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