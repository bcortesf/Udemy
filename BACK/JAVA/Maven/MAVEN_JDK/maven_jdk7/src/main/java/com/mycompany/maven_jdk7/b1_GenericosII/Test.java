/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk7.b1_GenericosII;


import com.mycompany.entitysRecords.Persona;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author BryanCFz
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk7.GenericosII".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        /**
         * Con los Genericos, su proposito es
         * 1.Proveer seguridad en tipos "(type safety)"
         * 2.Evitar casteos
         */

        List<Object> lista = new ArrayList();
        lista.add("a");
        lista.add(1);
        lista.add(true);
        for (Object object : lista) {
            System.out.println(object);
        }        
        String texto = (String)lista.get(0);
        System.out.println("De lista<Object> casteo a -> String :" + texto);
        

        System.out.println("\n\n****************");
        claseGenericaMultiple();
        System.out.println("\n\n****************");
        ListaCon_claseGenericaMultiple();
        
    }
    
    public static void  claseGenericaMultiple() {
        Persona       persona  = new Persona(0, "alguien", null);
        List<Persona> lista    = Arrays.asList(new Persona[]{new Persona(1, "uno", null), new Persona(2, "dos", null)});
        Boolean       esActivo = true;
        
        ClaseGenericaMultiple<Persona,List<Persona>,Integer, Boolean> claseGenerica_multiple = new 
            ClaseGenericaMultiple<>(persona, lista, 1013, esActivo);
        
        claseGenerica_multiple.MostrarTipoDeObjetoImplementado();
    }
    /**
     * Tener multiples objetos, dentro de una lista
     * ufff severooooo
     */
    public static void  ListaCon_claseGenericaMultiple() {
        Persona       personaA1  = new Persona(1, "Mamita"  , "calle falsa 123");
        Persona       personaA2  = new Persona(2, "Nanita"  , "calle falsa 123");
        ///////
        Persona       personaB1  = new Persona(3, "Papito"  , "carrera verdad 45");
        Persona       personaB2  = new Persona(4, "Abuelito", "carrera verdad 45");
        
        double totalPatrimonioFamilias = 0.0;
        
        List<ClaseGenericaMultiple<Integer,Double,Persona,Persona>> lista = new ArrayList<>();
        lista.add( new ClaseGenericaMultiple<>(1, 2200.0, personaA1, personaA2) );
        lista.add( new ClaseGenericaMultiple<>(2, 2300.0, personaB1, personaB2) );
        
        
        for (ClaseGenericaMultiple<Integer,Double,Persona,Persona> claseGenerica_multiple : lista) {
            System.out.println("->" + claseGenerica_multiple.toString());
            claseGenerica_multiple.MostrarTipoDeObjetoImplementado(); //MostrarTipo
            if (claseGenerica_multiple.esObjetoPersona()) {
                System.out.println("  #FAMILIA-" + claseGenerica_multiple.getObjetoK());
                List<Persona> familia = claseGenerica_multiple.getPersonas();
                for (Persona persona : familia) {
                    System.out.println("\t" + persona.toString() );
                }
                System.out.println("\tUbicacion  :" + claseGenerica_multiple.getObjetoT());
                totalPatrimonioFamilias += claseGenerica_multiple.getObjetoT();
            } else {
                System.out.println("->soy instancia de otra clase");
                claseGenerica_multiple.MostrarTipoDeObjetoImplementado();
            }
            System.out.println("\n");
        }
        System.out.println("¡El patrimonio es " + totalPatrimonioFamilias + " en total de las familias!");
    }
}
