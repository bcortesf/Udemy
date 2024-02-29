/**
 * https://pokeapi.co/
 * https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0
 * https://pokeapi.co/api/v2/pokemon/1
 */

/**
 * 
 */
//-------------------------------------------------------------
/**
 * ESTA PROMESA TIENE CALLBACK(1,2), pero solo retornaria
 *      -CALL-BACK-1:  return id;
 */
const findPokemonById_ =   /*CALL-BACK-1*/(id) => {
    const url = `https://pokeapi.co/api/v2/pokemon/${ id }`;

    fetch(url).then( /*CALL-BACK-2*/(response) => {

        response.json().then( (pokemon) => {
            return pokemon
        });

    });

    return `Pokemon-ABCDEFGH-ID<${id}>`;
}
// module.exports = findPokemonById;
//-------------------------------------------------------------
//-------------------------------------------------------------
/**
 * PROMESA mediante callback
 */
const findPokemonById_callback_promise =   /*CALL-BACK-1*/(id, callback1) => {
    const pokemonURL = `https://pokeapi.co/api/v2/pokemon/${ id }`;

    fetch(pokemonURL).then( /*CALL-BACK-2*/(responseSERVICE) => {

        responseSERVICE.json().then( (pokemonDATA) => {
            //->1.paso la DATA al "callback1"
            return callback1(pokemonDATA);
        });

    });
}
//-------------------------------------------------------------
//-------------------------------------------------------------
/**
 * PROMESA-ENCADENADAS mediante callback
 */
const findPokemonById_callback_chainPromise =   (id, callback1) => {
    const pokemonURL = `https://pokeapi.co/api/v2/pokemon/${ id }`;

    fetch(pokemonURL)
        .then( (responseSERVICE) => responseSERVICE.json() )
        .then( (pokemonDATA) => callback1(pokemonDATA) );
        // .then( (responseSERVICE) => {
        //     return responseSERVICE.json();
        // })
        // .then( (pokemonDATA) => {
        //     return callback1(pokemonDATA)
        // });
}
//-------------------------------------------------------------
//-------------------------------------------------------------
/**
 * PROMESA-ENCADENADAS
 */
const findPokemonById_chainPromise =   (id) => {
    const pokemonURL = `https://pokeapi.co/api/v2/pokemon/${ id }`;

    return fetch(pokemonURL)
        .then( (responseSERVICE) => responseSERVICE.json() )
        .then( (pokemonDATA) => pokemonDATA )
    ;
}
//-------------------------------------------------------------
//-------------------------------------------------------------
/**
 * PROMESA-ENCADENADAS - CON ERROR
 */
const findPokemonById_chainPromise_Error =   (id) => {
    const pokemonURL = `https://pokeapi.co/api/v2/pokemon/${ id }`;

    return fetch(pokemonURL)
        .then( (responseSERVICE) => responseSERVICE.json() )
        .then(() => { throw new Error('Pokemon no existe') })
        .then( (pokemonDATA) => pokemonDATA.name )
    ;
}




module.exports = {
    findPokemonById_callback_promise,     //->tiene CALLBACK
    findPokemonById_callback_chainPromise,//->tiene CALLBACK

    findPokemonById_chainPromise,
    findPokemonById_chainPromise_Error
};