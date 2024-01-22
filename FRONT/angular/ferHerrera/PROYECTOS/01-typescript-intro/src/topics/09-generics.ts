/**USANDO GENERICOS DE JAVASCRIPT - LEGACY */
console.warn('USANDO GENERICOS DE JAVASCRIPT - LEGACY');


export function whatsMyType_LEGACY(param :any) :any {
    return param;
}

const  amIString_OLD = whatsMyType_LEGACY('Hola mundo');
const  amIBoolean_OLD = whatsMyType_LEGACY(true);
const  amINumber_OLD = whatsMyType_LEGACY(89);
const  amDate_OLD = whatsMyType_LEGACY(new Date());
const  amIArray_OLD = whatsMyType_LEGACY(['a','b']);
const  amIObject_OLD = whatsMyType_LEGACY({fieldA:'Aaa',fieldB:'Bbb'});
console.log(typeof amIString_OLD);      console.log(typeof amIBoolean_OLD);
console.log(typeof amINumber_OLD);      console.log(typeof amDate_OLD);
console.log(typeof amIArray_OLD);       console.log(typeof amIObject_OLD);


//->NO MUESTRA LOS METODOS PORQUE LA VARIABLE SE CONVIERTE DE TIPO<OBJECT>
//->Hay que adivinar que tipo de metodos contiene internos y puede causar errores
// console.log(amIString_OLD.);

/////////////////////////////////////////////////////////////////////
/**USANDO GENERICOS DE TYPESCRIPT - NEW */
console.warn('USANDO GENERICOS DE TYPESCRIPT - NEW');


export function whatsMyType<T>(param :T) :T {
    return param;
}

const  amIString = whatsMyType('Hola mundo');
const  amIBoolean = whatsMyType(true);
const  amDate = whatsMyType(new Date());
const  amIArray = whatsMyType(['a','b']);
const  amIObject = whatsMyType({fieldA:'Aaa',fieldB:'Bbb'});
console.log(typeof amIString);      console.log(typeof amIBoolean);
console.log(typeof amDate);         console.log(typeof amIArray);
console.log(typeof amIObject);

//->Podemos ver los metodos sin perder el tipo de dato, mediante la funcion generica
console.log(amIString.concat(' USANDO GENERICOS'));
amIArray.push('c')
console.log(amIString.split(' '));
console.log(amIArray.join('-'));

/**FORZAR TIPO ENVIADO A UNA FUNCION GENERICA Y QUE NO ACEPTE OTROS TIPOS DE DATOS */
console.info('FORZAR TIPO ENVIADO A UNA FUNCION GENERICA Y QUE NO ACEPTE OTROS TIPOS DE DATOS');
const  amIArray_REQUIRED_OK    = whatsMyType<number[]>([1,2,3,4,5]);
// const  amIArray_REQUIRED_ERROR = whatsMyType<number[]>('Hola mundo');