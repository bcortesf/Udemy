//lord of the rings - 'señor de los anillos'
let skillsL :string[] = ['Bash', 'Counter', 'Healing'];


//multiple type array
let skillsM :(string|number|boolean|string[])[]
    = ['Bash',1, 'Counter', 'Healing', true, skillsL];
let skills1 :{} = {};

let skills2 :{esActivo: boolean}  = {'esActivo':true};
let skills3 :{vara :string; varb :number;}  = {vara:'a', varb:1};

let skills4 :{
    skills3: { //existente
        vara :string;
        varb :number;
    }
    fieldA: {  //inventado
        vara :string;
        varb :number;
    }
}  //existente,     inventado
    = {skills3,     'fieldA':{vara :'', varb :1} }


interface Character {
    name :string;
    hp :number;
    skills :string[];
    hometown :string;

    //'?' valor opcional
    power1 ?:string;            //no se requiere poner inicializacion
    power2 :string | undefined; //obliga a poner undefined la inicializacion
}
const strider: Character = {
    name: 'Strider', hp: 100, skills: ['Bash', 'Counter'],
    hometown: "",
    power2: undefined
};
console.table(strider);
