    /** ************IMPORTS-JAVASCRIPT************ **/

/**En "package.json" despues de "version" definir:    "type": "commonjs"
 */
//->T.COMPLETO: importar todas las variables
const templateExports = require('./01-template-javascript');
//->T.DESESTRUCTURADO: importar con desestructuracion, mismo-nombre-de "module.exports = {..}"
const { emailTemplateJavascript } = require('./01-template-javascript');

    /** ************LOGICA************ **/
    console.log(templateExports.emailTemplateJavascript);
    console.log(emailTemplateJavascript);


// ------------------------------------------------------------------------------------------


    /** ************IMPORTS-NODE************ **/

/**En "package.json" despues de "version" definir:    "type": "module"
 */
//->MODERN-DESESTRUCTURADO: importar con desestructuracion, mismo-nombre-de "export {..}"
// import { emailTemplateNode } from './js-foundation/01-template-node.mjs';

    /** ************LOGICA************ **/
    // console.log(emailTemplateNode);