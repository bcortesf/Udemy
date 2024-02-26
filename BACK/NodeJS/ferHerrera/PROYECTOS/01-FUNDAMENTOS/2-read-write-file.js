/**
 * https://nodejs.org/en/learn/asynchronous-work/overview-of-blocking-vs-non-blocking
 */

/**IMPORTS */
const fileSystem = require('fs'); //require('node:fs') //->si el proyecto es otro framework

/**LOGIC */
const data = fileSystem.readFileSync('./README.md', 'utf8');

//->REPLACE AND WRITING
const newDataWrite = data.replace(/React/ig, 'Angular');
fileSystem.writeFileSync('README-Angular.md', newDataWrite);
//->READ
const newdataRead = fileSystem.readFileSync('./README-Angular.md', 'utf8');
console.log(newdataRead);