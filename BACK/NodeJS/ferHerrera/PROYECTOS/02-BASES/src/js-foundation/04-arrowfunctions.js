const users = [
    {
        id: 1,
        name: 'John Doe'
    },
    {
        id: 2,
        name: 'Jane Doe'
    }
];


/**
 * @param {*} id idUsuario a buscar
 * @param {*} fnCallback(<ERROR>, <OK-DATA>)
 */
const findUserById_CALLBACK =  (id, fnCallback) => {
    console.log('OBTENER logica-metodo desde "callback.js"');
    const userFound = users.find(
        //->Funcion-arrow-anonima
        // (user) => { return user.id === Number(id); }
        (user) => user.id === Number(id)
    );


    //->IMPLEMENTACIÓN DE LOGICA:  FUNCION-CALLBACK(<ERROR>, <OK-DATA>)
    /*<ERROR>*/
    return !userFound
        ? fnCallback(`USUARIO no encontrado con id ${id}, :(`, null) /*<ERROR>*/
        : fnCallback(null, userFound);                               /*<OK-DATA>*/
}


module.exports = {
    findUserById_CALLBACK
}