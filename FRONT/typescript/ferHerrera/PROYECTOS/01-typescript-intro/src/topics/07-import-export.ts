//{interfaz, funcion}
import {Product, taxCalculation, tax, taxCalculation_otraFormaDESTRUCTURAR} from "./06-HOMEWORK-function-destructuring";

const shoopingCar: Product[] = [
    {
        description: "Nokia 1100",
        price: 150.0
    },
    {
        description: "iPad Air",
        price: 250.0
    }
];

const [total, totalTax] = taxCalculation_otraFormaDESTRUCTURAR({
    products: shoopingCar,
    tax: tax //CONSTANTE:tax  ->from "./06-homeworks-function-destructuring";
});
console.log('Total-totalTax', {total, totalTax});
console.log('Tax', tax);

//////////////////////////////////////////////////////////////////////////////////////////////////////
/**PRUEBAS */
const tax_07 = tax; //CONSTANTE.tax  ->from "./06-homeworks-function-destructuring";
                //METODO .taxCalculation  ->from "./06-homeworks-function-destructuring";
const [total_TEST, totalTax_TEST] = taxCalculation(
    {   //OBJETOS.INTERFAZ<TaxCalculationOptions>{tax,products}  ->from "./06-homeworks-function-destructuring";
        tax: tax_07,
        products: shoopingCar
    }
);
console.log('TEST: Total-totalTax', {total_TEST, totalTax_TEST});
console.log('TEST: Tax', tax); //CONSTANTE:tax  ->from "./06-homeworks-function-destructuring";
//////////////////////////////////////////////////////////////////////////////////////////////////////
export {};