/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.empresa.cc2.TestDrivenDevelopment_TDD123;

import com.empresa.cc2.TestDrivenDevelopment_TDD1.Flight1;
import com.empresa.cc2.TestDrivenDevelopment_TDD1.FlightController1;
import com.empresa.cc2.TestDrivenDevelopment_TDD2.Flight2;
import com.empresa.cc2.TestDrivenDevelopment_TDD2.FlightController2;
import com.empresa.cc2.TestDrivenDevelopment_TDD2.FlightNotFoundException2;
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
public class FlightController2Test {
       
    @BeforeAll
    public static void setUpClass() {}
    
    @AfterAll
    public static void tearDownClass() {}
    
    @AfterEach
    public void tearDown() {}
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////  
    
    private  FlightController2 flightController;
    
    public FlightController2Test() {
    }
    
    @BeforeEach
    public void setUp() {
        this.flightController = new FlightController2();
    }
  
    /**
     * FlightController1Test
 GIVEN : un controlador vacio, de vuelos
 WHEN  : se añada un vuelo, al controlador de vuelos
 THEN  : la funcion "Buscar vuelos por referencia" devuelve el vuelo
 
 https://stackoverflow.com/questions/1873995/run-a-single-test-method-with-maven
 C:\Users\brycorfe\OneDrive - Carvajal S.A\Documentos\NetBeansProjects\CleanAndCode>mvn test
 C:\Users\brycorfe\OneDrive - Carvajal S.A\Documentos\NetBeansProjects\CleanAndCode>mvn test -Dtest=FlightController1Test
 * 
 C:\Users\brycorfe\OneDrive - Carvajal S.A\Documentos\NetBeansProjects\CleanAndCode>mvn test -Dtest=FlightController2Test#exepcionVuelo
     */
    @Test
    public void givenEmptyFlightController_whenFlightAdded_thenGetByReferencesReturnsFlight() {
        //GIVEN: precondiciones
        LocalDate date =  LocalDate.parse("2022-06-21");
        LocalTime time = LocalTime.parse("10:30:15");
        Flight2 vuelo1 = new Flight2("1", LocalDateTime.of(date, time), "Bogotá D.C", "Cartagena");
        Flight2 vuelo2 = new Flight2("2", LocalDateTime.of(date, time), "Bogotá D.C", "Cartagena");
        //WHEN: accion
        this.flightController.addFlight(vuelo1);
        this.flightController.addFlight(vuelo2);
        //THEN: resultado esperado
        assertEquals(vuelo1,  this.flightController.findFlightByReference("1") );
    }
    @Test
    public void exepcionVuelo() {
        /*
        //GIVEN: precondiciones
        LocalDate date =  LocalDate.parse("2022-06-21");
        LocalTime time = LocalTime.parse("10:30:15");
        Flight3 vuelo1 = new Flight3("1", LocalDateTime.of(date, time), "Bogotá D.C", "Cartagena");
        Flight3 vuelo2 = new Flight3("2", LocalDateTime.of(date, time), "Bogotá D.C", "Cartagena");
        //WHEN: accion
        this.flightController.addFlight(vuelo1);
        this.flightController.addFlight(vuelo2);
        */
        
        //THEN: resultado esperado
        assertThrows(FlightNotFoundException2.class, () -> {
            this.flightController.findFlightByReference("8");
        });
    }
    
    

    //->Añadir vuelos
    //->Buscar vuelos por referencia

    //->Buscar vuelos por origen

    //->Buscar vuelos entre dos fechas

    //->Eliminar vuelos
    
}
