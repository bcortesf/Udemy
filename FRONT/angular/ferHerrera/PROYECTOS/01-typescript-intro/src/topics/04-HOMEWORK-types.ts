console.log('04-homeworks-types');

/*
    ===== Código de TypeScript =====
*/
/**OPCION #1 */
interface SuperHero1 {
    name: string;
    age: number;
    address: {
        street: string;
        country: string;
        city: string;
    };
    showAddress1(): string;
    showAddress2 :() => string;
}

/**OPCION #2 */
interface SuperHero2 {
    name: string;
    age: number;
    address: Addresss; //
    showAddress1(): string;
    showAddress2 :() => string;
}
interface Addresss {
    street: string;
    country: string;
    city: string;
}

//
const superHeroe: SuperHero2 | SuperHero1 = {
    name: 'Spiderman',
    age: 30,
    address: {
        street: 'Main St',
        country: 'USA',
        city: 'NY'
    },
    showAddress1(): string {
        return this.name + ', ' + this.address.city + ', ' + this.address.country;
    },
    showAddress2: function (): string {
        return this.name + ', ' + this.address.city + ', ' + this.address.country;
    }
}

const address1 = superHeroe.showAddress1();
const address2 = superHeroe.showAddress2();
console.log( {address1, address2} );


export {};