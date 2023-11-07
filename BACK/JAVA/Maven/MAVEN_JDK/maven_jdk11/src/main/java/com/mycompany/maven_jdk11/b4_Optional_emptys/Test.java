/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk11.b4_Optional_emptys;

import com.mycompany.entitysClass.Persona;
import java.util.Optional;

/**
 * https://www.youtube.com/watch?v=8ArG8VjIejs&list=PLvimn1Ins-41uwtb28Jj0Aw4gKV6FGsyH&t=41s
 * @author BryanCFz
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk11.b4_Optional_emptys".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        // 
        Test ts = new Test();
        ts.OptionalPersonas();
    }
    public void OptionalPersonas() {
        System.out.println("\n1. ->OptionalPersonas()");
        Persona personaReal  = new Persona(1, "Bryan");
        Persona personaVacia = new Persona();
        Persona personaNula  = null;
        
        showPersona("*personaReal*" , personaReal);
        showPersona("*personaVacia*", personaVacia);
        showPersona("*personaNula*" , personaNula);
    }
    public void showPersona(String tipoPersona, Persona persona) {
        System.out.println(tipoPersona);

        Optional<Persona> optionalPersona = Optional.ofNullable(persona);
        System.out.println("  Optional<Persona>       :" + optionalPersona);
            estaVacio(optionalPersona);
            estaPresente(optionalPersona);
            System.out.println();
    }
    private void estaVacio(Optional<Persona> optPersona) {
        System.out.println("    ->estaVacio() - JDK11");
        System.out.println("\tOptional<Persona>.empty :");
        if (optPersona.isEmpty()) {
            System.out.println("\t[11] Esta vacio");
        } else {
            System.out.println("\t[11] Esta lleno: " + optPersona.get());
        }
    }
    private void estaPresente(Optional<Persona> optPersona) {
        System.out.println("    ->estaPresente() - JDK8");
        System.out.println("\tOptional<Persona>.present:");
        if (!optPersona.isPresent()) {
            System.out.println("\t[8] Esta vacio");
        } else {
            System.out.println("\t[8] Esta lleno: " + optPersona.get());
        }
    }
}
