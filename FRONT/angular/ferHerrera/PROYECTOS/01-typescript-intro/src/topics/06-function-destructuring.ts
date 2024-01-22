/**Calcular el impuesto sobre los productos */
interface Product {
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


//
const shoppingCar :Product[] = [phone, tablet];
const tax = 0.19 //->impuesto

interface TaxCalculationOptions {
    tax: number;
    products :Product[];
}

///////////////////////////////////////////////////////////////////////
function taxCalculation( options: TaxCalculationOptions ): number[] {
    let totalPrice :number = 0;
    let resultTax :number[] = [];

    options.products.forEach( (p:Product) => {
        const prodResult :string = `Producto:${p.description}, Valor:${p.price}, Tax:${options.tax}, taxProduct:${p.price + (p.price*tax)}`;
        console.log(prodResult);
        totalPrice += p.price; //------
        resultTax.push( p.price + (p.price*tax) );
    });

    console.log('totalPrice', totalPrice);
    return resultTax;
}


//->result_a2: aplicaremos DESTRUCTURACION en "result_a2"
const result :number[] = taxCalculation({
    tax: tax,
    products: shoppingCar
});

console.log('ResultTaxProducts1:', result);



//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
                /**PRUEBAS, HACER CASO OMISO */

function taxCalculation2( options: TaxCalculationOptions ): number {
    return options.products.reduce((acumulator :number, currentItem :Product) => {
        return acumulator + (currentItem.price + (currentItem.price*tax))
    },0);
}
function taxCalculation3( options: TaxCalculationOptions  ): number[] {
    const total: number =  options.products.reduce((acumulator :number, currentItem :Product) =>
        acumulator += currentItem.price
    ,0);
    return [total, (total*options.tax)]
}

const  options : TaxCalculationOptions = {
    tax, // = tax: tax,     "Porque EcmacScript6, sabe que se llama igual la variable"
    products: shoppingCar
};
const result2 = taxCalculation(options);


console.log('ResultTaxProducts1_a2:', result2);
console.log('ResultTaxProducts2:', taxCalculation2(options));
console.log('ResultTaxProducts3:', taxCalculation3(options));
//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
export {};