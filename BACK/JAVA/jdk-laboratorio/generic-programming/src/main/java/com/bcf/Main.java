package com.bcf;

import com.bcf.generic_a.Caja;
import com.bcf.generic_a.CajaDoble;
import com.bcf.generic_a.Persona;

import java.text.MessageFormat;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /**
         * CAJA SIMPLE
         */
        System.out.println("***CAJA-SIMPLE**");
        // Creamos una caja para guardar un ENTERO
        Caja<Integer> cajaEntera = new Caja<>(10);
        int numero = cajaEntera.obtenerContenido();
        System.out.println("Numero: " + numero);

        // Creamos una caja para guardar una CADENA
        Caja<String> cajaCadena = new Caja<>("Bryan");
        String saludo = cajaCadena.obtenerContenido();
        System.out.println("Saludo: " + saludo);

        // Creamos una caja para guardar un OBJETO-TIPO-[<PERSONA>]
        Caja<Persona> cajaPersona = new Caja<>( new Persona(1, "Shushi") );
        Persona persona = cajaPersona.obtenerContenido();
        System.out.println(
                MessageFormat.format("Persona: {0}_{1}", persona.getId(), persona.getNombre())
        );

        /**
         * CAJA DOBLE
         */
        System.out.println("\n***CAJA-DOBLE**");
        // Creamos una caja-doble para guardar un (ENTERO y STRING)
        CajaDoble<Integer, String> cajaMixta = new CajaDoble<>(10, "HOLA");
        numero = cajaEntera.obtenerContenido();
        saludo = cajaCadena.obtenerContenido();
        System.out.println(
                MessageFormat.format("Numero: {0}  -  Saludo:{1}", numero, saludo)
        );

        // Creamos una caja-doble para guardar un (OBJETO-TIPO-[<PERSONA>],  OBJETO-TIPO-[<PERSONA>])
        CajaDoble<Persona, Persona> cajaPersonas = new CajaDoble<>(
                new Persona(1, "Shushi"),
                new Persona(2, "Minnie")
        );
        Persona persona1 = cajaPersonas.getContenido1();
        Persona persona2 = cajaPersonas.getContenido2();
        System.out.println(
                MessageFormat.format("Persona1: {0}-{1}  -  Persona2: {2}-{3}",
                        persona1.getId(), persona1.getNombre(),
                        persona2.getId(), persona2.getNombre()
                )
        ); 
    }
}