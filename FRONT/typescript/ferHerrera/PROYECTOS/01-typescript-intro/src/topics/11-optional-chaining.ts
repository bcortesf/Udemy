export interface Passenger {
    name :string;
    children? :string[];
}

/**Para agregar propiedades faltantes un click sobre "passenger1",
 * oprimir comando:         CTRL + .
*/
// const passenger1 :Passenger = {};

const passenger1 :Passenger = {
    name: 'Xiaomi'
};
const passenger2 :Passenger = {
    name :'Google',
    children :['Youtube', 'Gmail', 'Maps', ]
};

/************************************************************************ */
/**
 * OPTIONAL CHAINING  ~"??"~  encadenamiento opcional
 * - Hacer referencia a un valor "??" opcional
 *
 * NOT NULL ASSERTION OPERATOR  ~"!"~  REQUIRED
 */
const printChildren =   (passenger: Passenger) => {
    const {name} = passenger; //DESTRUCTURACION-ATTR[name]
    const howManyChildren = passenger.children?.length || 0;

    console.log(name.concat(' :tiene ')
        .concat(String(howManyChildren)).concat(' hijos')
    );
}
printChildren(passenger1);
printChildren(passenger2);


console.log('');
const returnChildrenNumber =   (passenger: Passenger) :number => {
    //const howManyChildren = passenger.children!.length; //!: VALOR REQUERIDO
    const howManyChildren = passenger.children?.length ?? 0;
    return howManyChildren;
}
console.log(passenger1.name
    .concat(' :tiene ')
    .concat(String(returnChildrenNumber(passenger1)))
    .concat(' hijos')
);
console.log(passenger2.name
    .concat(' :tiene ')
    .concat(String(returnChildrenNumber(passenger2)))
    .concat(' hijos')
);