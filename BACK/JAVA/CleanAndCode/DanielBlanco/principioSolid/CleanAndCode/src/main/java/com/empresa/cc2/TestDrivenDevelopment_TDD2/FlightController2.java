/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc2.TestDrivenDevelopment_TDD2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class FlightController2 {
    /**
     * https://carvajal.udemy.com/course/principios-solid-y-clean-code-escribe-codigo-de-calidad/learn/lecture/24922044?start=106#notes
     *  Nomenclatura:  GivenWhenThen
        - Given : una precondicion
        - When  : realizamos una acción
        - Then  : Pasa algo, resultados esperados
     */
    
    private List<Flight2> listaVuelos = new ArrayList<>();
    
        
                    /*METHODS*/

    //Añadir vuelos
    public void addFlight(Flight2 vuelo) {
        this.listaVuelos.add(vuelo);
    }

    //Buscar vuelo por referencia
    public Flight2 findFlightByReference(String reference){

        for (Flight2 flight : listaVuelos) {
            //                         equals: referencia a "Flight.class<boolean equals(Object obj)>"
            if (flight.getReferencia().equals(reference)) {
                return flight;
            }
        }
        throw new FlightNotFoundException2("No se encontro un vuelo cone sa referencia");
    }


    //Buscar vuelos por origen
    public List<Flight2> findFlightByOrigin(String origin) {return null;}

    //Buscar vuelos entre dos fechas
    //

    //Eliminar vuelos
    //



                        /*GETTERS && SETTERS*/
    /**
     * @return the listaVuelos
     */
    public List<Flight2> getListaVuelos() {
        return listaVuelos;
    }

    /**
     * @param listaVuelos the listaVuelos to set
     */
    public void setListaVuelos(List<Flight2> listaVuelos) {
        this.listaVuelos = listaVuelos;
    }
    
}
