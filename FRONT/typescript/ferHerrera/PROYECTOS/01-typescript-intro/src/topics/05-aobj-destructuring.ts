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

/**FORMA TRADICIONAL */
console.info('->FORMA TRADICIONAL');
    console.log('song:', audioPlayer.song);
    console.log('author:', audioPlayer.details.author);

////////////////////////////////////////////////////////////////////
/**DESTRUCTURACION DE OBJETOS: Descompone el objeto en variables */
console.info('->DESTRUCTURACION DE OBJETOS');
const song :string = 'New song'; //CONFLICTO

//OTRA FORMA: DESTRUCTURANDO EN DISTINTAS LINEAS
//-> const {song, details} = audioPlayer;
const { song:renameAnotherSong, songDuration:duration } = audioPlayer; //RENOMBRAR <song>, para que no genere "CONFLICTO.LINE-30"; renombrar <songDuration> por gusto
const {author, year} = audioPlayer.details;
    console.log('{...}',
        {
            'songRN:'   :renameAnotherSong, //->console.log('song:', song);
            'duration:' :duration,
            'author:'   :author,
            'year:'    :year
        }
    );

//OTRA FORMA: DESTRUCTURANDO EN UNA MISMA LINEA
const {
    song:song2,
    songDuration:duration2,
    details: {
        author:author2 //RENOMBRAR PARA EVITAR CONFLICTO, LINEA.35
    }
} = audioPlayer;

////////////////////////////////////////////////////////////////////
/**ESTRUCTURAR VARIABLES EN UN OBJETO */
const objetoNuevo: {
    renameAnotherSong: string; //<AudioPlayer>
    duration: number;          //<AudioPlayer>
    author: string;            //<Details>
} = {renameAnotherSong, duration, author};
console.log('objetoNuevoEstructurado', objetoNuevo);



////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////
            /**PRUEBAS-OBJETO NUEVO  A LA ANTIGUA */
const audioPlayerNewObject:{song :string, author :string} = {song: audioPlayer.song, author: audioPlayer.details.author};
console.log('audioPlayerNewObject',audioPlayerNewObject);
////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////

export {};