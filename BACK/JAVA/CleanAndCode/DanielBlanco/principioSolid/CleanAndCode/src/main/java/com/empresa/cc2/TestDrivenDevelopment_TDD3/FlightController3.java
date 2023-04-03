/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc2.TestDrivenDevelopment_TDD3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FlightController3 {
    /**
     * https://carvajal.udemy.com/course/principios-solid-y-clean-code-escribe-codigo-de-calidad/learn/lecture/24922044?start=106#notes
     *  Nomenclatura:  GivenWhenThen
        - Given : una precondicion
        - When  : realizamos una acción
        - Then  : Pasa algo, resultados esperados
     */
    
          //referencia, vuelo
    private Map<String, Flight3> mapaVuelos;
    
    public FlightController3() {
        this.mapaVuelos = new HashMap<>();
    }
    
    
                    /*METHODS*/

    //Añadir vuelos
    public void addFlight(Flight3 vuelo) {
        this.isFlightExist(vuelo);
        
        String key = vuelo.getReferencia();
        this.mapaVuelos.put(key, vuelo);
    }

    //Buscar vuelo por referencia
    public Flight3 findFlightByReference(String reference){

        /*for (Map.Entry<String, Flight3> entry : mapaVuelos.entrySet()) {
            String key = entry.getKey();
            Flight3 valflight = entry.getValue();
            
            //                           equals: referencia a "Flight.class<boolean equals(Object obj)>"
            if (key.equals(reference)) {
                return valflight;
            }
        }*/
        
        Flight3 valflight = this.mapaVuelos.get(reference); //se obtiene vuelo directamente por la "KEY", sin recorrer con un for
        if (valflight == null) {
            throw new FlightNotFoundException3(" **No se encontro un vuelo con esa referencia** ");
        }
        return valflight;
    }
    
    public void isFlightExist(Flight3 vuelo) {
        Flight3 existingFlight = this.mapaVuelos.get( vuelo.getReferencia() ); //se obtiene vuelo directamente por la "KEY", sin recorrer con un for
        if (existingFlight != null) {
            throw new DuplicateFlightException3(" **Vuelo existente, no se agregara** ");
        }
        //return existingFlight; //null, no encontro el vuelo, no lanza exception
    }


    //Buscar vuelos por origen
    public List<Flight3> findFlightByOrigin(String origin) {return null;}

    //Buscar vuelos entre dos fechas
    //

    //Eliminar vuelos
    //



                        /*GETTERS && SETTERS*/

    public Map<String, Flight3> getMapaVuelos() {
        return mapaVuelos;
    }

    public void setMapaVuelos(Map<String, Flight3> mapaVuelos) {
        this.mapaVuelos = mapaVuelos;
    }
    
    
}
