console.log('FUNCIONES BASICAS');

function addNumbers_basicVoid() :void { const a=1; console.log(a); }
function addNumbers2_basicUndefined() :undefined {return undefined;}

function addNumbers_basicNumber(a:number, b:number) :number {
    return a + b;
}
function addNumbers_basicString(a:number, b:number) :string {
    return `${a + b}`;
}


const fnSuma :number = addNumbers_basicNumber(5,3)

console.log('fnSuma:', fnSuma );
console.log('objSuma:', {fnSuma}, {'miFuncion': fnSuma} );
console.log('suma:', addNumbers_basicNumber(1,2) );

///////////////////////////////////////////////////////////
console.log('FUNCIONES FLECHA O FUNCION LAMBDA');
const addNumbers_ArrowVoid1 = ():void => {console.log('');};
const addNumbers_ArrowVoid2: void = addNumbers_basicVoid();

const addNumbersArrowNumber = (a:number, b:number) :number => {return a + b};
const addNumbersArrowString = (a:number, b:number) :string => {return `${ a + b }`};

const addNumbersArrowStringResult: string = addNumbersArrowString(1,2);

///////////////////////////////////////////////////////////

console.log('FUNCION CON PARAMETRO ESPECIFICADOS');
/*                 OBLIGATORIO,             OPCIONAL?,                      = VALOR-DEFECTO*/
function multiply(firstNumber :number, secondsNumber? :number, base :number = 2) {
    return firstNumber * base;
}

const multiplyResult1 :number = multiply(5);         //obligatorio                    -> <10>
const multiplyResult2 :number = multiply(5, 3);      //obligatorio, opcional          -> <10>
const multiplyResult3 :number = multiply(5, 10, 30); //obligatorio, opcional, default -> <150>
console.log('multiplyResult1', multiplyResult1);
console.log('multiplyResult2', multiplyResult2);
console.log('multiplyResult3', multiplyResult3);

console.log({fnSuma, addNumbersArrowStringResult, multiplyResult1});

///////////////////////////////////////////////////////////
console.log('FUNCION CON OBJETOS');
//heal:curar, character:personaje, amount:cantidad
interface Character {
    name :string;
    healthPoints: number; //puntos-vida
    showHealthPoints_Void :() => void; //=> <TIPO-RETORNO>{void,number,boolean,... etc}
    showHealthPoints_Return:() => string;
}

const healCharacter = (character: Character, amount: number): void => {
    character.healthPoints += amount;
};

const strider :Character = {
    name: "Aragon Strider",
    healthPoints: 50,
    showHealthPoints_Void(): void {
        console.log(`Puntos de vida ${this.healthPoints}`);
    },
    showHealthPoints_Return: function (): string {
        return `Puntos de vida ${this.healthPoints}`;
    }
};

console.log('Character:', strider);
//  OJO: UN METODO VOID, NO SE PUEDE IMPRIMIR, DENTRO DE UN  COSOLE.LOG()
console.log(strider.showHealthPoints_Return());
strider.showHealthPoints_Void();

healCharacter(strider, 50);
healCharacter(strider, 100);
console.log('Character:', strider);


/*De lo contrario saldria error porque ya existe la {interface "Character"} en: 01-typescript-intro\src\topics\02-object-interface.ts*/
export {};