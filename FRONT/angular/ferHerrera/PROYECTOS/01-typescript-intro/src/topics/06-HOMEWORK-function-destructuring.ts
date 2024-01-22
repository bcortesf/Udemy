/**Calcular el impuesto sobre los productos */
export interface Product {
    description :string;
    price: number;
}
//
    const phone :Product = {
        description: "Nokia 1100",
        price: 150.0
    };
    const tablet :Product = {
        description: "iPad Air",
        price: 250.0
    };


interface TaxCalculationOptions {
    tax: number;
    products :Product[];
}

///////////////////////////////////////////////////////////////////////
                            /**DESTRUCTURANDO :3*/
export function taxCalculation_otraFormaDESTRUCTURAR( options : TaxCalculationOptions): [number, number] {
    const {products, tax} = options;

    let total :number = 0;

    products.forEach( ({price}) => {
        total += price;
    });
    return [total, (total*tax)];
}

    // function taxCalculation( {products, tax} : TaxCalculationOptions): [number, number] {
export function taxCalculation( {products} : TaxCalculationOptions): [number, number] {
    let total :number = 0;

    products.forEach( ({price}) => {
        total += price;
    });
    return [total, (total*tax)];
}

//
const shoppingCar :Product[] = [phone, tablet];
export const tax = 0.15 //->impuesto

///////////////////////////////////////////////////////////////////////
//DESTRUCTURACION
const [total, taxTotal] = taxCalculation({
    products: shoppingCar,
    tax: tax
});

console.log('Iva, Productos:', {tax, shoppingCar});
console.log('Destructuracion:', {total, taxTotal}); //[total, (total+iva)]


// export {
//     Product
// };