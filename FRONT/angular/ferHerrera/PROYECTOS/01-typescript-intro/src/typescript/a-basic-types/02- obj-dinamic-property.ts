/**CREAR PROPIEDADES DINAMICAS */
    console.warn('CREAR PROPIEDADES DINAMICAS');
    let obj: any = {x: 0};
    obj.newProperty = 100;
    const n: number = obj;
    console.log({obj, n});

export {};