interface AudioPlayer {
    audioVolume :number;
    songDuration :number;
    song :string;
    details :Details;
}
interface Details {
    author :string;
    year :number;
}

const audioPlayer :AudioPlayer = {
    audioVolume: 90,
    songDuration: 272,
    song: "Lay all your love on me",
    details: {
        author: "Abba",
        year: 2008
    }
};

/**DESTRUCTURACION DE OBJETOS: Descompone el objeto en variables */
console.info('->DESTRUCTURACION DE ARRAYS');
const {song, songDuration:duration, details} = audioPlayer
console.log(song, duration, details);


/**OBTENIENDO VALOR DE UN ARRAY */
const dragonBallz: string[] = ['Goku', 'Vegeta', 'Broly'];

const Gohan :string = dragonBallz[3] || 'No hay personaje' ;
    console.log('Personaje 2:', dragonBallz[2] || 'No hay personaje');
    console.log('Personaje 3:', Gohan);
/**DESTRUCTURACION DE ARRAYS: Descompone el array en variable */
const [pers1, pers2, picoro]: string[] = ['Goku', 'Vegeta', 'Picoro'];
console.log( 'Personaje:',
    {
        pers1,
        pers2,
        picoro
    }
);

const [, , picorom]: string[] = ['Goku', 'Vegeta', 'Picoro'];
console.log( 'Personaje:',
    {
        picorom
    }
);

const [, , naruto = 'No existe en dragon ball']: string[] = ['Goku', 'Vegeta'];
console.log( 'Personaje:',
    {
        naruto
    }
);



//https://stackoverflow.com/questions/33397430/object-destructuring-solution-for-long-arrays/33397569#33397569
export {};