const {http} = require('../plugins/http-client.plugin');

/**
 * PATRON ADAPTER
 */
const findPokemonById_ =   async(id) => {
    const pokemonURL = `https://pokeapi.co/api/v2/pokemon/${ id }`;

    const  pokemonDATA = await http.get(pokemonURL);
    // const responseSERVICE = await fetch(pokemonURL);
    // const pokemonDATA = await responseSERVICE.json();

    return String(pokemonDATA.name);
}

const findPokemonById_AXIOS =   async(id) => {
    const pokemonURL = `https://pokeapi.co/api/v2/pokemon/${ id }`;

    const  pokemonDATA = await http.get_npmAxios(pokemonURL);
    return String(pokemonDATA.name);
}



module.exports = {
    findPokemonById_,
    findPokemonById_AXIOS
};