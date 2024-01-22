/**
 * https://www.typescriptlang.org/docs/handbook/enums.html
 */


///////////////////////////////////////
enum AudioLevel {
    min,    //pos[0]
    medium, //pos[1]
    max     //pos[2]
}
let currentAudio = AudioLevel.medium;
console.log(AudioLevel);
console.log(currentAudio);


///////////////////////////////////////
enum Direction {
    Up = "UP",
    Down = "DOWN",
    Left = "LEFT",
    Right = "RIGHT",
}
let currentdirection = Direction.Left;
console.log(currentdirection);


///////////////////////////////////////
enum OperatorTypes {
    plus = 'sumar',
    less = 'restar',
    bad = 'mala'
}
function operationA(numberA: number, numberB: number,
    receivedOperator: OperatorTypes) {
    if (receivedOperator == OperatorTypes.plus) {
        return numberA + numberB;
    }
    if (receivedOperator == OperatorTypes.less) {
        return numberA - numberB;
    }
}
    console.log( operationA(3, 2, OperatorTypes.plus) ?? 0 );
    console.log( operationA(3, 2, OperatorTypes.less) ?? 0 );
    console.log( operationA(3, 2, OperatorTypes.bad) ?? 0 );


function operationB(numberA: number, numberB: number,
    receivedOperator: OperatorTypes.plus | OperatorTypes.less) {
    if (receivedOperator == OperatorTypes.less) {
        return numberA - numberB;
    }
    if (receivedOperator == OperatorTypes.plus) {
        return numberA + numberB;
    }
}
    console.log( operationB(5, 3, OperatorTypes.plus) );
    console.log( operationB(5, 3, OperatorTypes.less) );


export{};