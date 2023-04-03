// 2_Pokemon.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <string.h>


using namespace std;

//https://stackoverflow.com/questions/1415388/c-class-dependencies
class Pokemon;
class BolaFuego;
class FuegoPokemon;

/*CLASE PADRE*/
class Pokemon {
private:
    string nombre;
    float nivelPotenciaAtaque;
    int cantidadEstadoSalud; //0-100
    string color;

public:
    /*CONSTRUCTORS*/
    Pokemon() {
        nombre = "anonimo";
        nivelPotenciaAtaque = 50.0;
        cantidadEstadoSalud = 99; //0-100
        color = "transparente";
    }
    Pokemon(
        string nombre,
        float nivelPotenciaAtaque,
        int cantidadEstadoSalud,
        string color)
    {
        this->nombre = nombre;
        this->nivelPotenciaAtaque = nivelPotenciaAtaque;
        this->cantidadEstadoSalud = cantidadEstadoSalud; //0-100
        this->color = color;
    }
    /*DESTRUCTOR*/
    // ALT + 126 = ~
    ~Pokemon() {
        //cout << "EL POKEMON FUE GUARDADO EN LA POKEBOLA";
    }

    /*methods*/
    void saludar(string mensajePokemon) {
        cout << "\nHola Soy " << this->getNombre() << "\t. " << mensajePokemon;
    }

    void sanarSalud100() {
        this->cantidadEstadoSalud = 100;
    }

    void evolucionar(string nombreNuevo, string colorNuevo) {
        setNombre(nombreNuevo);
        setColor(colorNuevo);
        float potencia20Porciento =  this->nivelPotenciaAtaque + (this->nivelPotenciaAtaque * 0.20);
        setNivelPotenciaAtaque(potencia20Porciento);
    }

    void pokemonToString() {
        cout << "Nombre: " << this->nombre << "\tAtaque: " << this->nivelPotenciaAtaque
             << "\tSalud: " << this->cantidadEstadoSalud << "\tColor: " << this->color << endl;
    }

    /*GETTERS && SETTERS*/
    string getNombre() {
        return this->nombre;
    }
    float getNivelPotenciaAtaque() {
        return this->nivelPotenciaAtaque;
    }
    int getCantidadEstadoSalud() {
        return this->cantidadEstadoSalud;
    } //0-100
    string getColor() {
        return this->color;
    }

    void setNombre(string nombre) {
        this->nombre = nombre;
    }
    void setNivelPotenciaAtaque(float nivelPotenciaAtaque) {
        this->nivelPotenciaAtaque = nivelPotenciaAtaque;
    }
    void setCantidadEstadoSalud(int cantidadEstadoSalud) {
        this->cantidadEstadoSalud = cantidadEstadoSalud;
    } //0-100
    void setColor(string color) {
        this->color = color;
    }

};

/*CLASE HIJA*/
class AguaPokemon : public Pokemon {
private:
    int maxResistent;  //resistencia bajo el agua
    int submergedTime; //tiempo sumergido
    int capacidadTiempoSumergido;

public:
    /*CONSTRUCTORS*/
    AguaPokemon(int maxResistent, int submergedTime
        ,string nombre, string color, float nivelPotenciaAtaque
    ): Pokemon() {
        this->maxResistent = maxResistent;
        this->submergedTime = submergedTime;
        this->capacidadTiempoSumergido = 0;
        this->setNombre(nombre);
        this->setColor(color);
    }

    /*METHODS*/
    void respirarCogerAire() {
        int tiempoSumergido = 0;
        cout << "respirando para volver a sumergirme";
    }

    string tiempoAguantandoBajoAgua() {
        string pokemonRespira = (this->submergedTime <= this->capacidadTiempoSumergido)
            ? "tomar aire"
            : "el pokemon se ha asficciado :(";
        return pokemonRespira;
    }

    void aguaPokemonToString() {
        cout << "Resistencia: " << this->maxResistent << "\tsubmergedTime: " << this->submergedTime;
    }


    /*GETTERS && SETTERS*/
    int getMaxResistent() {
        return this->maxResistent;
    }
    int getSubmergedTime() {
        return this->submergedTime;
    }
    void setMaxResistent(int maxResistent) {
        this->maxResistent = maxResistent;
    }
    void setSubmergedTime(int submergedTime) {
        this->submergedTime = submergedTime;
    }

};



class FuegoPokemon : public Pokemon {
private:
    int maxTemperature;  //temperatura maxima
    int temperatureBall; //temperatura de la bola

public:

    BolaFuego* bolaFuego;

    /*CONSTRUCTORS*/
    FuegoPokemon(int maxTemperature, int temperatureBall
        , string nombre, string color, float nivelPotenciaAtaque
    ) : Pokemon() {
        this->maxTemperature = maxTemperature;

        this->temperatureBall = temperatureBall;
        
        //
        //armarBola();
        //

        this->setNombre(nombre);
        this->setColor(color);
    }

    /*METHODS*/
    void fuegoPokemonToString() {
        cout << "temperature: " << this->maxTemperature << "\ttemperatureBall: ";
    }

    void armarBola() {
        //BolaFuego bolaFuego { 123 };

        //BolaFuego bolaFuego(100);

        //BolaFuego bolaFuego = BolaFuego::setTemperatureBall(10);

        //BolaFuego* bolaFuego = new BolaFuego(23);

        /*BolaFuego* bolaFuego;
        bola = new BolaFuego(20);*/

        /*BolaFuego* bolaFuego;
        bola->setTemperatureBall(2);*/


        //this->bolaFuego.setTemperatureBall(this->temperatureBall);
    }
    void lanzarBola() {
        //cout << "lanzar bola: " << this->bolaFuego.getTemperatureBall() << " de temperatura";
    }


    /*GETTERS && SETTERS*/
    int getMaxTemperature() {
        return this->maxTemperature;
    }
    void setMaxResistent(int maxTemperature) {
        this->maxTemperature = maxTemperature;
    }

    int getTemperatureBall() {
        return this->temperatureBall;
    }
    void setTemperatureBall(int temperatureBall) {
        this->temperatureBall = temperatureBall;
    }

};

class BolaFuego {
public:
    int temperatureBall; //temperatura de la bola

public:
    /*CONSTRUCTORS*/
    BolaFuego() {
        this->temperatureBall = 0;
    }
    BolaFuego(int temperatureBall) {
        this->temperatureBall = temperatureBall;
    }

    /*GETTERS && SETTERS*/
    int getTemperatureBall() {
        return this->temperatureBall;
    }
    void setTemperatureBall(int temperatureBall) {
        this->temperatureBall = temperatureBall;
    }
};


void main()
{
    //std::cout << "Hello World!\n";
    Pokemon pok;
    pok.pokemonToString();
    pok.sanarSalud100();
    pok.pokemonToString();
    pok.evolucionar("Pikachu", "Amarillo");
    pok.pokemonToString();
    pok.saludar("Te ofrezco truenos y relampagos.");
    cout << "\n\n";
    //////////////////////////////////////
    AguaPokemon agupok(60, 200
        , "squarol", "azul", 80);
    agupok.pokemonToString();
    agupok.aguaPokemonToString();
    agupok.saludar("Te ofrezco chorros de agua por la jeta");
    cout << "\n\n";
    
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
