/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.empresa.cc2.TestDrivenDevelopment_TDD123;

import com.empresa.cc2.TestDrivenDevelopment_TDD3.DuplicateFlightException3;
import com.empresa.cc2.TestDrivenDevelopment_TDD3.Flight3;
import com.empresa.cc2.TestDrivenDevelopment_TDD3.FlightController3;
import com.empresa.cc2.TestDrivenDevelopment_TDD3.FlightNotFoundException3;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
public class FlightController3Test {
       
    @BeforeAll
    public static void setUpClass() {}
    
    @AfterAll
    public static void tearDownClass() {}
    
    @AfterEach
    public void tearDown() {}
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////  
    
    private  FlightController3 flightController;
    
    public FlightController3Test() {
    }
    
    @BeforeEach
    public void setUp() {
        this.flightController = new FlightController3();
    }
  
    /**
     * FlightController1Test
 GIVEN : un controlador vacio, de vuelos
 WHEN  : se añada un vuelo, al controlador de vuelos
 THEN  : la funcion "Buscar vuelos por referencia" devuelve el vuelo
 
 https://stackoverflow.com/questions/1873995/run-a-single-test-method-with-maven
 C:\Users\brycorfe\OneDrive - Carvajal S.A\Documentos\NetBeansProjects\CleanAndCode>mvn test -Dtest=FlightController3Test
 C:\Users\brycorfe\OneDrive - Carvajal S.A\Documentos\NetBeansProjects\CleanAndCode>mvn test -Dtest=FlightController3Test#exepcionVuelo
     */
    @Test
    public void givenEmptyFlightController_whenFlightAdded_thenGetByReferencesReturnsFlight() {
        //->GIVEN: precondiciones
        LocalDate date =  LocalDate.parse("2022-06-21");
        LocalTime time = LocalTime.parse("10:30:15");
        Flight3 vuelo1 = new Flight3("1", LocalDateTime.of(date, time), "Bogotá D.C", "Cartagena");
        Flight3 vuelo2 = new Flight3("2", LocalDateTime.of(date, time), "Bogotá D.C", "Cartagena");
        //->WHEN: accion
        this.flightController.addFlight(vuelo1);
        this.flightController.addFlight(vuelo2);
        //->THEN: resultado esperado
            assertEquals(vuelo1,  this.flightController.findFlightByReference("1") );
            //assertEquals(vuelo1,  this.flightController.findFlightByReference("11") );  //FlightNotFoundException
            //assertEquals(vuelo2,  this.flightController.findFlightByReference("1") );     //object distinc (expect, was)
    }
    @Test
    public void exepcionVuelo() {     
        //->THEN: resultado esperado
        assertThrows(FlightNotFoundException3.class, () -> {
            this.flightController.findFlightByReference("8");
        });
    }
    
    /**
     * Al añadir un vuelo, ¿ya hay un vuelo con la misma "referencia"?; Salte una exception
     * givenFlightControlllerWithFlight_whenSameFlightAdded_thenThrowDuplicateFlightException3
     */
    @Test
    public void repeatFlight() {
        //->GIVEN
        LocalDate date =  LocalDate.parse("2022-06-21");
        LocalTime time = LocalTime.parse("10:30:15");
        Flight3 vueloOrign   = new Flight3("1", LocalDateTime.of(date, time), "Bogotá D.C", "Cartagena");
        Flight3 vueloCopy1   = new Flight3("1", LocalDateTime.of(date, time), "Bogotá D.C", "Cartagena"); 
        Flight3 vueloCopy5   = new Flight3("5", LocalDateTime.of(date, time), "Bogotá D.C", "Cartagena"); //ERROR - NO PASA TEST
        //->WHEN
        this.flightController.addFlight(vueloOrign);
        //->THEN
        assertThrows(DuplicateFlightException3.class, () -> {
            //this.flightController.addFlight(vueloOrign);   //TEST.OK
            this.flightController.addFlight(vueloCopy1);   //TEST.OK
            //this.flightController.addFlight(vueloCopy5);   //test.FAIL : la referencia "5", no se encuentra
        });
    }
    
    
    // https://github.com/danielblanco96/CleanCode-SOLID-Udemy/blob/main/CleanCode/4-tdd-example/src/test/java/tddexample/FlightControllerTest.java
            /*OK*/
    //->Añadir vuelos
    //->Buscar vuelos por referencia

            /*PENDIENTES*/
    //->Buscar vuelos por origen
    //->Buscar vuelos entre dos fechas
    //->Eliminar vuelos
    
}
