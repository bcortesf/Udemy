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


function findUserById_void(id) {
    const userFound = users.find(
        function(user) { //callback
            return user.id === Number(id);
        }
    );
    console.log('DESDE "callback.js"');
    console.log({userFound});
    console.log({ususarioEncontrado: userFound});
}
function findUserById_return(id) {
    return users.find(
        function(user) {
            return user.id === Number(id);
        }
    );
}

/* EJECUCION-EN-CLASE
findUserById_void(2);
const userFound = findUserById_return(2);
console.log('return:', userFound);
*/


/**
 * @param {*} id idUsuario a buscar
 * @param {*} fnCallback(<ERROR>, <OK-DATA>)
 */
function findUserById_CALLBACK(id, fnCallback) {
    console.log('OBTENER logica-metodo desde "callback.js"');
    const userFound = users.find(
        function(user) { //funcion-anonima
            return user.id === Number(id);
        }
    );


    //->IMPLEMENTACIÓN DE LOGICA:  FUNCION-CALLBACK(<ERROR>, <OK-DATA>)
    /*<ERROR>*/
    if (!userFound) {
        return fnCallback(`USUARIO no encontrado con id ${id}, :(`, null);
    }
    /*<OK-DATA>*/
    return fnCallback(null, //->null= <ERROR>
        userFound
    )
}


module.exports = {
    findUserById_void,
    encontrarUsuarioPorId_vacio: findUserById_void,
    findUserById_CALLBACK
}