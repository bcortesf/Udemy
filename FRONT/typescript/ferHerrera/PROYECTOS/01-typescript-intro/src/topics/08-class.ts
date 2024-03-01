/**FORMA1: PARA EXPORTAR */
export class Person1 {
    public name :string|undefined;
    public address :string|undefined;
    /*public auxiliar :string;*/ //ERROR: porque estoy diciendo que la propiedad siempre va a venir; y puede ser NULL

    constructor() {}
}
/**FORMA2: PARA EXPORTAR */
/*
    class Person1 {
        //Code...
    }
    export {
        Person1
    };
*/
/////////////////////////////////////
export class Person2 {
    public name? :string;
    public address? :string;

    constructor() {}
}
/////////////////////////////////////
/**DESPUES DE constructor(); LA SINTAXIS VA ASI:
     * PRIMERO: todos obligatorios y el ultimo opcional
     * FINALMENTE: al sobrecargar constructor con argumentos:
     *             - Replicar el "?" desde ultimo argumento -> hasta primer argumento
     *      constructor();
     *      constructor(param1:string,  param2:string,  param3:string,  param4:string,  param5?:string)
     *      constructor(param1:string,  param2:string,  param3:string,  param4?:string, param5?:string)
     *      constructor(param1:string,  param2:string,  param3?:string, param4?:string, param5?:string)
     *      constructor(param1:string,  param2?:string, param3?:string, param4?:string, param5?:string)
     *      constructor(param1?:string, param2?:string, param3?:string, param4?:string, param5?:string)
     *   */
export class Person3 {
    public name :string;
    public address :string;

    constructor();
    constructor(name  :string, address? :string)
    constructor(name? :string, address? :string) {
        // Implement your logic based on the provided parameters
        if (name !== undefined) {
            console.log('name !== undefined', name !== undefined);
        }
        this.name = name ?? 'BryanCFz'; //?? : Es indefinido o no existe. Asignar valor-default'BryanCFz'
        this.address = address ?? 'Calle falsa 123';

    }
}

const ironman3 :Person3 = new Person3();
const shushi3 :Person3 = new Person3('Shushi');
const minnie3 :Person3 = new Person3('Minnie', 'casita CFz');
console.log(ironman3);
console.log(shushi3);
console.log(minnie3);

/////////////////////////////////////
export class Person4a {
    public name :string;
    public address :string;
    constructor(name :string, address :string) {
        this.name = name;
        this.address = address;
    }
}
export class Person4b {
    /** Este constructor con argumentos "public", es equivalente a:  class<Person4a>
     *  Evitando definir los atributos  externamente;
     */
    constructor(
        public name :string,
        public address :string = 'valor-defecto No Addres'
    ) {}
}

/////////////////////////////////////
export class Hero extends Person4b {
    constructor(
        public alterEgo :string, //nombreSuperHeroe
        public age :number,
        public realName :string,
        public colorHero :string
    ) {
        // super(realName);
        super(realName, 'Marvel');
    }
}
const ironMan :Hero = new Hero('Iron Man', 45, 'Tony Starck', 'rojo-dorado');
console.log(ironMan);

/////////////////////////////////////
export class Hero2 {
    public person: Person4b;
    constructor(
        public alterEgo :string, //nombreSuperHeroe
        public age :number,
        public realName :string,
        public colorHero :string
    ) {
        this.person = new Person4b(realName);
    }
}
const spiderMan :Hero2 = new Hero2('Spider-Man', 28, 'Peter Parker', 'rojo');
console.log(spiderMan, '======>'.concat(spiderMan.person.name));

/////////////////////////////////////
/**VENTAJAS
 * Por mas que agrege nuevas proiedades a la clase<Person4b>,
 * seguira funcionando la clase<Hero3> y no sera afectada
 */
export class Hero3 {
    constructor(
        public alterEgo :string, //nombreSuperHeroe
        public age :number,
        public realName :string,
        public colorHero :string,
        public person: Person4b
    ) {}
}
const steven :Person4b = new Person4b('Steve GR');
const captainAmerica :Hero3 = new Hero3(
    'Captain-America', 34, 'Steven Gran Rogers', 'azul'
    ,steven);
console.log(captainAmerica);