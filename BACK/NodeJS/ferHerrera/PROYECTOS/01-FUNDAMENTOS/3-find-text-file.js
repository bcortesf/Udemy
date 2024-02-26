/**
 * https://nodejs.org/en/learn/asynchronous-work/overview-of-blocking-vs-non-blocking
 */

/**IMPORTS */
const { log } = require('console');
const fileSystem = require('fs'); //require('node:fs') //->si el proyecto es otro framework

/**LOGIC */
const content = fileSystem.readFileSync('./README.md', 'utf8');
const wordCount = content.split(' '); //almacenar palabras y quitar espacios

const reactWordCount1 = wordCount.filter(
    // (word) => word.toLowerCase() === "react"    //->solo-palabra-"react"
    (word) => word.toLowerCase().includes("react") //->palabra-o-texto-contenga-"react"
).length;
const reactWordCount2 = content.toLowerCase().split('react').length-1;
const reactWordCount3 = (content.match(/react/gi) ?? []).length; //->gi: insensitive-case

console.log('cantidad-palabras:', wordCount.length);
console.log('react1-cantidad-palabras:', reactWordCount1);
console.log('react3-cantidad-palabras:', reactWordCount3);

