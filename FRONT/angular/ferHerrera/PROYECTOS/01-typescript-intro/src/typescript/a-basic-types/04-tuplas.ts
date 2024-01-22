/**SIEMPRE RECIBE DATOS EN EL ORDEN ESPECIFICADO POR TIPO DE DATO */
console.warn('SIEMPRE RECIBE DATOS EN EL ORDEN ESPECIFICADO POR TIPO DE DATO');

let heroOK: [string, number] = ['Dr Strange', 100];
    heroOK = ['Bryan',34];
    heroOK[0] = ''; heroOK[1] = 0;
let heroERROR: [string, number] = ['1-string', 2];
    // heroERROR = [2, '1-string']; //->ERROR-DE-TUPLA-POR-TIPOS
console.log({heroOK, heroERROR});


// const hero: [string, number] = ['Dr Strange', 100];


export {};