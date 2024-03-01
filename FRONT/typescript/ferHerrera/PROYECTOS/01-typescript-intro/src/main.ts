/*                     OBTENER-LIBRERIAS                   */
/* APLICAR ESTILOS Y COLORES ".css" A ESTA CLASE "main.ts" */
import './style.css'
/**
 * ___________________________________________________________________________
 * */
// import './topics/00-console-types'
// import './topics/01-basic-types'
// import './topics/02-object-interface'
// import './topics/03-basic-functions'
// import './topics/04-HOMEWORK-types'

// import './topics/05-aobj-destructuring'
// import './topics/05-arrays-destructuring'
// import './topics/06-function-destructuring'
// import './topics/06-HOMEWORK-function-destructuring'

// import './topics/07-import-export'
// import './topics/08-class'
// import './topics/09-generics'
// import './topics/10-decorators'
// import './topics/11-optional-chaining'
/**
 * ___________________________________________________________________________
 * */

// import './typescript/a-basic-types/01-cast-types'
// import './typescript/a-basic-types/02- obj-dinamic-property'
// import './typescript/a-basic-types/03- call-function-anonymous'
// import './typescript/a-basic-types/04-tuplas'
// import './typescript/a-basic-types/05-enums'
// import './typescript/a-basic-types/06-never-throw-error'
// import './typescript/a-basic-types/07-HOMEWORK'



import './typescript/b-functions/01-args-required'
import './typescript/b-functions/02-args-optional'    //PENDIENTE
import './typescript/b-functions/03-args-default'     //PENDIENTE
// import './typescript'
// import './typescript'
// import './typescript'
// import './typescript'
// import './typescript'
// import './typescript'
// import './typescript'
// import './typescript'
// import './typescript'
// import './typescript'
// import './typescript'


// console.log('saludo por consola');
document.querySelector<HTMLDivElement>("#saludo1")!.innerHTML = `
  hola Bcortesf1
`;

const app = document.querySelector<HTMLDivElement>("#saludo2")!;
app.innerHTML = `
  hola Bcortesf2
`;

// ----------------------------------------------------------
/* OBTENER-LIBRERIAS*/
// import typescriptLogo from './typescript.svg'
// import viteLogo from '/vite.svg'

/* OBTENER-FUNCION-CONTADOR  "setupCounter"*/
// import { setupCounter } from './counter.ts'


/* EJEMPLO-inicial-creacion-proyecto */
/*
document.querySelector<HTMLDivElement>('#app')!.innerHTML = `
  <div>
    <a href="https://vitejs.dev" target="_blank">
      <img src="${viteLogo}" class="logo" alt="Vite logo" />
    </a>
    <a href="https://www.typescriptlang.org/" target="_blank">
      <img src="${typescriptLogo}" class="logo vanilla" alt="TypeScript logo" />
    </a>
    <h1>Vite + TypeScript</h1>
    <div class="card">
      <!--       #counter       -->
      <button id="counter" type="button"></button>
    </div>
    <p class="read-the-docs">
      Click on the Vite and TypeScript logos to learn more
    </p>
  </div>
`

setupCounter(document.querySelector<HTMLButtonElement>('#counter')!)
*/

