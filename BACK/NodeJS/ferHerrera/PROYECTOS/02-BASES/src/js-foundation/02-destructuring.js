console.log('destructuring');
console.log(process.env.PORT ?? 3000);

//->DESESTRUCTURACION: Escoger varibles que necesite de todoo el objeto
// destructuring();
depuracionErrores();



function destructuring() {
    const {USERDOMAIN, USERNAME, USERPROFILE} = process.env;
    console.log(USERDOMAIN, USERNAME, USERPROFILE);
    console.log({USERDOMAIN, USERNAME, USERPROFILE});
    console.table({USERDOMAIN, USERNAME, USERPROFILE});
    //
    const characters = ['Flash', 'Superman', 'Batman'];
    const [flash, superman, batman] = characters;
    console.log({flash, superman, batman});
    //
    const [_, __, batm] = characters;
    console.log({_, __, batm}, batm);
    const [, , bn] = characters;
    console.log({bn});
}
function depuracionErrores() {
    const characters = ['Flash', 'Superman', 'Green Lantern', 'Batman'];
    const [ , , , batman] = characters; //PONER-AQUI:PUNTO-DEPURACION

    console.log(batman);
}