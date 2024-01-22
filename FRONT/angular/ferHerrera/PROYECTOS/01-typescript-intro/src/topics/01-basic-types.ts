let name :string = 'Strider';

let hpPoints :number|string = 95;
hpPoints = 'FULL';

let bcfPoints :number|'bryan' = 89;
bcfPoints = 'bryan';    //solo acepta string 'bryan'
// bcfPoints = 'camilo';//error

const isAlive :boolean = true;

console.table({
    name, hpPoints, bcfPoints, isAlive
})

console.log(
    {
        name, hpPoints, bcfPoints, isAlive
    }
);




export{}