/**CASTEOS A OBJETO */
    console.warn('CASTEOS A OBJETO');
    let avenger :any = true;
    avenger = 'Dr Strange'; //:any
    console.log( (avenger as string).charAt(0) );
    avenger = 150.3029045;
    console.log( (<number>avenger).toFixed(2) );
    console.log( (Number(avenger)).toFixed(2) );


export {};