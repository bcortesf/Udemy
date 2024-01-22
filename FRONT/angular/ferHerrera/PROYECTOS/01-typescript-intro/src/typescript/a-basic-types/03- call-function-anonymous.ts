/**FUNCIONES AUTO-INVOCADAS */
    console.warn('FUNCIONES AUTO-INVOCADAS');
    (() => {
        console.log('SIN-PARAMETROS', 'Funcion auto-invocada');
    })();
    ((value : string) => {
        console.log('ARGUMENTOS', value.toUpperCase());
    })('mayuscula');

/**FUNCION ANONIMA */
    console.warn('FUNCIONES ANONIMAS');
    const names = ['Tom', 'MinniE', 'PajaroS'];

    names.forEach((value: string) => {
        console.log(value.toLowerCase());
    })
    names.forEach(function (value: string) {
        console.log(value.toUpperCase());
    });
/**FUNCIONES ANONIMA + PARAMETROS EN FUNCION CUSTOMIZADA */
console.warn('FUNCIONES ANONIMA + PARAMETROS EN FUNCION CUSTOMIZADA');
    names.forEach(convertToUpperCase);                                              //EJECUCION-FUNCION
    function convertToUpperCase(value: string, index: number, array: string[]) {    //DECLARACION-FUNCION
        const literalObject = {
            dataConvert: value.toUpperCase().concat('---').concat( index.toString()),
            index,
            originArray : array
        };
        console.log(literalObject);
    }


/**C */
console.warn('..');



export {};