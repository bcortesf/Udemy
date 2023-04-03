/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.empresa.cc2.TestDrivenDevelopment_TDD123;

import com.empresa.cc2.TestDrivenDevelopment_TDD1.Flight1;
import com.empresa.cc2.TestDrivenDevelopment_TDD1.FlightController1;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *  Controlador de vuelo:
      - Añadir vuelos
      - Buscar vuelos por referencia
      - Buscar vuelos por origen
      - Buscar vuelos entre dos fechas
      - Eliminar vuelos
  
 *  https://carvajal.udemy.com/course/principios-solid-y-clean-code-escribe-codigo-de-calidad/learn/lecture/24922044?start=106#notes
 *  Nomenclatura:  GivenWhenThen
        - Given : una precondicion
        - When  : realizamos una acción
        - Then  : Pasa algo, resultados esperados

 * @author brycorfe
 */
public class FlightController1Test {
       
    @BeforeAll
    public static void setUpClass() {}
    
    @AfterAll
    public static void tearDownClass() {}
    
    @AfterEach
    public void tearDown() {}
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////  
    
    private  FlightController1 flightController;
    
    public FlightController1Test() {
    }
    
    @BeforeEach
    public void setUp() {
        this.flightController = new FlightController1();
    }
  
    /**
     * FlightController1Test
 GIVEN : un controlador vacio, de vuelos
 WHEN  : se añada un vuelo, al controlador de vuelos
 THEN  : la funcion "Buscar vuelos por referencia" devuelve el vuelo
 
 https://stackoverflow.com/questions/1873995/run-a-single-test-method-with-maven
 C:\Users\brycorfe\OneDrive - Carvajal S.A\Documentos\NetBeansProjects\CleanAndCode>mvn test
 C:\Users\brycorfe\OneDrive - Carvajal S.A\Documentos\NetBeansProjects\CleanAndCode>mvn test -Dtest=FlightController1Test
     */
    @Test
    public void givenEmptyFlightController_whenFlightAdded_thenGetByReferencesReturnsFlight() {
        //GIVEN: precondiciones
        LocalDate date =  LocalDate.parse("2022-06-21");
        LocalTime time = LocalTime.parse("10:30:15");
        Flight1 vuelo1 = new Flight1("1", LocalDateTime.of(date, time), "Bogotá D.C", "Cartagena");
        Flight1 vuelo2 = new Flight1("2", LocalDateTime.of(date, time), "Bogotá D.C", "Cartagena");
        //WHEN: accion
        this.flightController.addFlight(vuelo1);
        this.flightController.addFlight(vuelo2);
        //THEN: resultado esperado
        assertEquals(vuelo2,  this.flightController.findFlightByReference("2") );
    }

    //->Añadir vuelos
    //->Buscar vuelos por referencia

    //->Buscar vuelos por origen

    //->Buscar vuelos entre dos fechas

    //->Eliminar vuelos
    
}
