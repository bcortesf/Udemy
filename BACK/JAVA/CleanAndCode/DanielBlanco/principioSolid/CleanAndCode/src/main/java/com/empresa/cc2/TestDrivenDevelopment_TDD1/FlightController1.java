/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc2.TestDrivenDevelopment_TDD1;

import java.util.List;


public class FlightController1 {
    /**
     * https://carvajal.udemy.com/course/principios-solid-y-clean-code-escribe-codigo-de-calidad/learn/lecture/24922044?start=106#notes
     *  Nomenclatura:  GivenWhenThen
        - Given : una precondicion
        - When  : realizamos una acción
        - Then  : Pasa algo, resultados esperados
     */
    
    private Flight1 flight;
    
    public FlightController1() {
        this.flight = new Flight1();
    }

    //Añadir vuelos
    public void addFlight(Flight1 vuelo) {
        this.flight.addFlight(vuelo);
    }

    //Buscar vuelo por referencia
    public Flight1 findFlightByReference(String referencia) {
        return this.flight.getByReferenceReturnFlight(referencia);
    }    

    //Buscar vuelos por origen
    public List<Flight1> findFlightByOrigin(String origin) {
        return this.flight.getByOriginFlight(origin);
    }

    //Buscar vuelos entre dos fechas
    //

    //Eliminar vuelos
    //
    
}
