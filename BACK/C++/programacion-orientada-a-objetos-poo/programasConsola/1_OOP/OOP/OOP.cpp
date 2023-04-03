// OOP.cpp : Este archivo contiene la función "main". La ejecución del programa comienza y termina ahí.
//

#include <iostream>
#include <string.h>
using namespace std;


class athlete {
//public:         //Reconocera desde otra clase externa reconocera todo: los atributos
private:        /**VIENE ASI POR DEFECTO*/
    string estaVariableNoseHereda = "Esta variable NO se heresa, por ser privada";
protected:        /*Desde clases heredadas solo reconoce los atributos, pero no lo reconoce desde el main u otra clase */
    int power;
    int speed;
    char name[15];
    float phone = 999999;

public:   //Al llamarlo desde otra clase solo reconocera: los constructores y los metodos
    /*CONSTRUCTORS*/
    //->sin_atributos
    athlete() {
        this->power = 100;
        this->speed = 0;
        strcpy_s(this->name, "Anonimo"); //Destination, source
        this->phone = 0;
    }
    //->con_atributos
    athlete(int energia, int velocidad, char nombre[15], float telefono) {
        this->power = energia;
        this->speed = velocidad;
        strcpy_s(this->name, nombre);
        this->phone = telefono;
    }
    /*DESTRUCTORES*/
    //se ejecuta de forma automatica, la virgulilla  en ASCII: ALT + 126 = ~
    ~athlete() { cout << name << ": ha sido destruido" << endl; }



    /*METHODS*/
    void upSpeed() {
        this->speed++;
        this->power--;
    }

    /*SOBREESCRITURA-METODO*/
    virtual void sobreEscribirMetodo() {
        cout << "sentencias originales en padre sin sobreescribir";
    }


    /*SETTERS  &&  GETTERS*/
    int   getPower() { return this->power; }
    int   getSpeed() { return this->speed; }
    char* getName()  { return this->name;  }
    float getPhone() { return this->phone; }

    
    void  setPower(int power) { this->power = power; }
    void  setSpeed(int speed) { this->speed = speed; }
    void  setNombre(char nombre[15]) { 
        strcpy_s(this->name, nombre);
    }


    void atletaToString() {
        cout << "Atleta name: " << name << "\t";
        cout << "Atleta power: " << power << "\t";
        cout << "Atleta speed: " << speed << endl;
    }
    
};

//Herencia
class footBallPlayer : public athlete {
private:
    char team[15];
    char position[3];
    int goals = 0; //conteo de goles
    char sponsor[15]; //patrocinador {adidas, nike, rebook}

public:
    /*CONSTRUCTORS*/
    footBallPlayer() {
        strcpy_s(team, "sin equipo");
        strcpy_s(position, "0");
        goals = 0;
        strcpy_s(sponsor, "sin patrocinador");
    }
    
    /*Crea un FootBallPlayer con los atributos , del padre constructor "athlete()", -> sin_atributos: {100,0,Anonimo}*/
    footBallPlayer(char team[15], char position[3], int goals, char sponsor[15]) : athlete() {
        strcpy_s(this->team, team);
        strcpy_s(this->position, position);
        this->goals = goals;
        strcpy_s(this->sponsor, sponsor);
    }

    footBallPlayer(char team[15], char position[3], int goals, char sponsor[15]
        ,int energia, int velocidad, char nombreAtleta[15], float telefono
    ) {
        strcpy_s(this->team, team);
        strcpy_s(this->position, position);
        this->goals = goals;
        strcpy_s(this->sponsor, sponsor);
        //padre athlete
        this->power = energia;
        this->speed = velocidad;
        strcpy_s(this->name, nombreAtleta);
        this->phone = telefono;
    }

    void footBallPlayerToString() {
        cout << "Equipo: " << team << "\t";
        cout << "Posicion: " << power << "\t";
        cout << "Patrocinador: " << sponsor << "\t";
        cout << "Goles: " << goals << endl;
    }

    /*GETTERS && SETTERS*/
    char* getTeam() {
        return this->team;
    }
    void setTeam(char team[15]) {
        strcpy_s(this->team, team);
    }

    /*SOBRECARGA-overLoad*/
    void upGoals() {
        this->goals++;
    }
    void upGoals(int goals) {
        this->goals += goals;
    }

    /*sobreescribiendo-override metodoPadre*/
    void sobreEscribirMetodo() override {
        cout << "sentencias modificadas en hijo sobreescrito";
    }

};

//Herencia
class swimmer : public athlete {
private:
    int goldMedal = 0;
    int silverMedal = 0;
    int bronzeMedal = 0;
    char style[15] = "";

public:
    swimmer() : athlete() {
        this->goldMedal = 0;
        this->silverMedal = 0;
        this->bronzeMedal = 0;
    }
};


///////////
void loadAthlete(athlete* atleta) {
    atleta->setPower(100);
}
///////////


void main()
{
    //std::cout << "Hello World!\n";
    //practica_Numero1();
    
    //SIN APUNTADOR: se destruye el objeto al final de la ejecucion del programa de forma automatica
    char nombre[15];
    strcpy_s(nombre, "Bolt");
    athlete atleta1(200, 35, nombre, 1234); //power, speed, name, phone
    atleta1.atletaToString();
    atleta1.upSpeed();
    atleta1.atletaToString();
    atleta1.setSpeed(41);
    atleta1.atletaToString();
    atleta1.setPower(100);
    atleta1.atletaToString();

    //CON APUNTADOR: yo debo controlar cuando destruyo el objeto porque existira en memoria siempre
    cout << "\n";
    strcpy_s(nombre, "M. Phelps");
    athlete *atletaApuntador = new athlete(30,15, nombre, 30577);
    atletaApuntador->atletaToString();              
    delete atletaApuntador;

    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////
    cout << endl;
    char team[15]; char position[3]; int goals = 0; char sponsor[15];
    strcpy_s(team, "BRAZIL");
    strcpy_s(position, "FW"); //delantero
    strcpy_s(sponsor, "Adidas");
    strcpy_s(nombre, "pele");
    

   /* footBallPlayer pele(team, position, goals, sponsor);
    pele.setNombre(nombre);
    pele.atletaToString();
    pele.footBallPlayerToString();
    cout << endl;*/

    footBallPlayer pele(team, position, goals, sponsor, 34, 12, nombre, 30577);
    pele.atletaToString();
    pele.footBallPlayerToString();
    pele.upGoals();
    pele.footBallPlayerToString();
    pele.upGoals(2);
    pele.footBallPlayerToString();
    //polimorfismo para cualquier clase hija
    loadAthlete(&pele);
    pele.atletaToString();
    pele.footBallPlayerToString();
    cout << endl;
    //comportamiento de la sobreescritura de metodo
    pele.sobreEscribirMetodo();
    cout << endl;

    
}







void practica_Numero1() {
    char nombre[15];
    athlete atleta1(200, 35, nombre, 1234); //power, speed, name, phone

    cout << "velocidad inicial: " << atleta1.getSpeed() << endl;
    atleta1.upSpeed();
    cout << "velocidad incrementada en 1: " << atleta1.getSpeed() << endl;
    atleta1.setSpeed(15);
    cout << "velocidad constante: " << atleta1.getSpeed() << endl;

    cout << "\n";
    strcpy_s(nombre, "Usain ");
    strcat_s(nombre, atleta1.getName());
    cout << nombre << endl;

    strcpy_s(nombre, "At.UsainBolt");
    atleta1.setNombre( nombre );
    cout << atleta1.getName() << endl;
}

// CTRL + K + C             CTRL + K + U
// Ejecutar programa: Ctrl + F5 o menú Depurar > Iniciar sin depurar
// Depurar programa: F5 o menú Depurar > Iniciar depuración

// Sugerencias para primeros pasos: 1. Use la ventana del Explorador de soluciones para agregar y administrar archivos
//   2. Use la ventana de Team Explorer para conectar con el control de código fuente
//   3. Use la ventana de salida para ver la salida de compilación y otros mensajes
//   4. Use la ventana Lista de errores para ver los errores
//   5. Vaya a Proyecto > Agregar nuevo elemento para crear nuevos archivos de código, o a Proyecto > Agregar elemento existente para agregar archivos de código existentes al proyecto
//   6. En el futuro, para volver a abrir este proyecto, vaya a Archivo > Abrir > Proyecto y seleccione el archivo .sln
