/** IMPORTANDO PAQUETES
 *  https://www.npmjs.com/package/uuid
 *  https://www.npmjs.com/package/get-age
 *              */
const {
    v4: uuidv4, v1: bryan_uuidv1,
    NIL , parse: uuidParse
} = require('uuid');

    console.log( {uuidv4: uuidv4(), bryan_uuidv1: bryan_uuidv1()} );
    // console.log(NIL);
const bytes = uuidParse('6ec0bd7f-11c0-43da-975e-2a8ad9ebae0b');
    // console.log(bytes);

//---------------------------------------------------------------------
//---------------------------------------------------------------------
/** Funcion tradicional que, DEVUELVE-UN-OBJETO
 *          DESTRUCTURING<person>            */
const buildPersonN =  ({name, birthday}) => {
    let getAge = require('get-age');
    return {
        // id: new  Date().getTime(),
        // id: crypto.randomUUID,       //->pure-javaScript
        id: uuidv4(),
        name: name,
        birthday,                       //->IGUAL-A = (birthday:birthday)
        age: getAge( birthday )
        // age: getAge( new Date(birthday).toLocaleString() )
        // age: new Date().getFullYear() - new Date(birthday).getFullYear()
    }
};
const  personN = {name: 'Nanita', birthday: '1935-01-10'};
const  NANITA = buildPersonN(personN);
console.log(NANITA);
//---------------------------------------------------------------------
//---------------------------------------------------------------------
/** Funcion tradicional que, DEVUELVE-UN-OBJETO
 *          DESTRUCTURING<get-age.plugin>            */

/**ENVIAR IMPORTACIONES A UN ARCHIVO DE BARRIL */
    // const { get_uuidv4_PLGN } = require('../plugins/get-id.plugin');
    // const { getAge_PLGN } = require('../plugins/get-age.plugin');
/**IMPORTAR DESDE ARCHIVO DE BARRIL~PRINCIPAL */
const {
    get_uuidv4_PLGN,
    getAge_PLGN
} = require('../plugins'); //IGUAL-A: require('../plugins/index');

const buildPersonB =  ({name, birthday}) => {
    return {
        id: get_uuidv4_PLGN(),
        name: name,
        birthday,
        age: getAge_PLGN( birthday )
    }
};
// const  personB = {name: 'Bryan', birthday: '2013-12-24'};
// const  BRYAN = buildPersonB(personB);
// console.log(BRYAN);


//---------------------------------------------------------------------
//---------------------------------------------------------------------
/**
     * Es una <funcion> que, FABRICA<UNA-FUNCION>
     */
const makeFunctionBuild =  () => {
    //->Es una funcion<makeFunctionBuild> que, ...
    return  /*FABRICA<UNA-FUNCION>*/() => {
        return {
            //->logica-funcion-fabricada
        }
    }
};


const makeFunctionBuildPerson =    ({get_uuidv4_PLGN, getAge_PLGN}) => {
    //makePerson  ó  makePerson({name, birthday})
    return ({name, birthday}) => {

        return {
            id: get_uuidv4_PLGN(),
            name: name,                 //*
            birthday,
            age: getAge_PLGN( birthday )//*
        }
    }
}




module.exports = {
    makeFunctionBuildPerson
};

