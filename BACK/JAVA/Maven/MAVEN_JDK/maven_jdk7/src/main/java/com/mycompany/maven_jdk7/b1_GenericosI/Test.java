/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk7.b1_GenericosI;

import com.mycompany.entitysRecords.Persona;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author BryanCFz
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk7.GenericosI".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        claseGenericaSimple();
    }
    public static void  claseGenericaSimple() {
        ClaseGenerica<Persona>       claseGenerica1 = new ClaseGenerica<>( new Persona(1, "uno", null) );
        ClaseGenerica<String>        claseGenerica2 = new ClaseGenerica<>( "baeldung.com");
        ClaseGenerica<List<String>>  claseGenerica3 = new ClaseGenerica<>( Arrays.asList(new String[]{"foo", "bar"}) );
        ClaseGenerica<List<Persona>> claseGenerica4 = new ClaseGenerica<>( 
                Arrays.asList(new Persona[]{new Persona(1, "uno", null), new Persona(2, "dos", null)}) 
        );
        claseGenerica1.MostrarTipoDeObjetoImplementado();
        claseGenerica2.MostrarTipoDeObjetoImplementado();
        claseGenerica3.MostrarTipoDeObjetoImplementado();
        claseGenerica4.MostrarTipoDeObjetoImplementado();
    }
}
