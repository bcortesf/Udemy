//->TIPOS
const batman :string = 'Bruce';
const superman :string = 'Clark';
const existe :boolean = false;


//->TUPLAS
const parejaHeroes :[string, string] = [batman, superman];
const villano :[string, number, boolean] = ['Lex Lutor' , 5, true]


//->ARREGLOS
const aliados :string[] = ['Mujer maravilla', 'Acuaman', 'San', 'Flash'];


//->ENUMERACIONES
enum SuperHeroStrength {
    Flash = 5,
    Superman = 100,
    Batman = 1,
    Acuaman = 0
}
const fuerzaFlash :SuperHeroStrength = SuperHeroStrength.Flash;
const fuerzaSuperman :SuperHeroStrength = SuperHeroStrength.Superman;
const fuerzaBatman :SuperHeroStrength = SuperHeroStrength.Batman;
const fuerzaAcuaman :SuperHeroStrength = SuperHeroStrength.Acuaman;
console.log({
    fuerzaFlash,
    fuerzaSuperman,
    fuerzaBatman,
    fuerzaAcuaman
});


//->RETORNO FUNCIONES
function activar_batiseñal() :string {
    return 'activada'
}
function pedirAyuda() :void {
    console.log('Auxilio!!!');
}


//->ASERCIONES DE TIPO
const poder :any = '100;'
const largoDelPoder :number = (poder as string).length;
console.log(largoDelPoder);


//->



