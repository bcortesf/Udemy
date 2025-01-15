/**
 * PATRON-ADAPTADOR
 * - mediante un objeto se implementa los metodos htttp
 *
 * https://www.npmjs.com/package/axios
 */

const axios = require('axios');


const  httpClientPlugin = {
    get:   async(URL) => {
        const responseSERVICE = await fetch(URL);
        return await responseSERVICE.json();
        // const DATA = await responseSERVICE.json();
    },
    get_npmAxios:   async(URL) => {
        try {
            // console.log( await axios.get(URL) );
            // const responseSERVICE = await axios.get(URL);
            // return responseSERVICE.data;

            const {data} = await axios.get(URL);
            return data;
        } catch (error) {
            console.log('error-AXIOS', error);
            return error;
        }
    },

    post:   async(URL, body) => {},
    put:   async(URL, body) => {},
    delete:   async(URL, body) => {}
}


module.exports = {
    http: httpClientPlugin
};