// https://dev.to/duxtech/tipos-de-objetos-console-en-javascript-parte-i-5ajb
let namee :string = "Bryan";
let last_name :string = "CFz";

/**1. console.log(), el más usado por excelencia
Para mensajes generales de registro de información. Es posible imprimir varios valores separados por comas. */
console.log(`Hola, soy ${namee} ${last_name}`);
console.log({namee, last_name}, {"nombre":namee, "apellido":last_name}, {});

/**2. console.warn()
Muestra un mensaje de advertencia. */
console.warn("Base de datos no respaldada, cuidado!");

/**3. console.info()
Muestra un mensaje de información. */
console.info("Usuario creado satisfactoriamente.");

/**4. console.error()
Muestra un mensaje de error. */
console.error("No se pudo eliminar el registro");