/**UN DECORADOR:
 *  Es una simple y comun funcion y se puede poner en:
 *  - Encima de [clase],[atributo],[metodo]
 * */

//function classDecorator<T extends { new (...args:any[]): {} }>(
function classDecorator<T extends new (...args:any[]) => {}>(
    constructor: T
) {
    return class extends constructor {
        newProperty = 'New Property';
        hello = 'override - classDecorator';
    }
}


/////////////////////////////////////////
/////////////////////////////////////////
@classDecorator
export class SuperClass {
    public miProperty :string = 'Abc123';
    //->ACCEDIENDO A VARIABLE DEL DECORADOR
    public hello: string = 'VALOR-ANULADO';

    print() :void {
        console.log('Hola Mundo');
    }
}

const superClass :SuperClass = new SuperClass();
console.log('DEFINICION-CLASE', SuperClass);
console.log(' INSTANCIA-CLASE', superClass);

console.log('property-decorator', superClass.hello);
console.log('property-class', superClass.miProperty);
superClass.print();

