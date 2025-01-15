/**
 * https://pokeapi.co/
 * https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0
 * https://pokeapi.co/api/v2/pokemon/1
 */

/**
 * PROMESA SIN CONTROL PARA LLEVAR LOGICAS
 */
const findPokemonById_old =   (id) => {
    const pokemonURL = `https://pokeapi.co/api/v2/pokemon/${ id }`;

    return fetch(pokemonURL)
        .then( (responseSERVICE) => responseSERVICE.json() )
        .then( (pokemonDATA) => pokemonDATA.name )
    ;
}
//-------------------------------------------------------------
/**
 * ASYNC-AWAIT
 * ASYNC: codigo bloqueante que no continua, HASTA RESOLVER EN ORDEN DE CODIGO:
 *      *1. Se resuelva el -> fetch(pokemonURL);
 *      *2. Se resuelva el -> responseSERVICE.json();
 */
const findPokemonById =   async(id) => {
    const pokemonURL = `https://pokeapi.co/api/v2/pokemon/${ id }`;

    const responseSERVICE = await fetch(pokemonURL);
    const pokemonDATA = await responseSERVICE.json();

    // throw new Error('Pokemon no existe');
    return String(pokemonDATA.name);
}




module.exports = {
    findPokemonById
};