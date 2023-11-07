/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk8.b10_AnotacionesDeRepeticion;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * https://www.youtube.com/watch?v=6RF-mdZpRSk&list=PLvimn1Ins-419yVe5iPfiXrg4mZJl5kLS&index=13
 * https://blog.idrsolutions.com/java-8-repeating-annotation-explained-in-5-minutes/
 * @author BryanCFz
 */
public class Test {
    
    //@Retention(RetentionPolicy.CLASS) //por-defecto :no existe ninguno
    @Retention(RetentionPolicy.RUNTIME) //por-logica  :compilacion de logica programada
    public @interface Lenguajes_PADRE {
        //->PADRE
        Lenguaje_hijo[] value() default{};
    }
    @Repeatable(value = Lenguajes_PADRE.class) //interfaz padre, que contendra al hijo
    public @interface Lenguaje_hijo {
        //->HIJO
        String value();
    }
    ///////////////////////////////
    
    //-> JAVA-1.7
    /*@Lenguajes_PA({
        @Lenguaje_hi("Java"),
        @Lenguaje_hi("SpringBoot")
    })*/
    
    //-> JAVA-1.8
    @Lenguaje_hijo("Java")
    @Lenguaje_hijo("SpringBoot")
    public interface LenguajeProgramacion {
    }

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk8.b10_AnotacionesDeRepeticion".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        //API-REFLECTIONS: se basa en clases
        Lenguaje_hijo[] arrayLenguaje = LenguajeProgramacion.class.getAnnotationsByType(Lenguaje_hijo.class);
        System.out.println("La cantidad de anotaciones de lenguajes es: " + arrayLenguaje.length);
        
        
        System.out.println("\n->1.LOS LENGUAJES SON:");
        for (Lenguaje_hijo lenguaje_hijo : arrayLenguaje) {
            System.out.println(lenguaje_hijo.value());
        }
        
        //----------------------------------------------
        System.out.println("\n->2.LOS LENGUAJES SON:");
        Lenguajes_PADRE lengPADRE = LenguajeProgramacion.class.getAnnotation(Lenguajes_PADRE.class);
        for (Lenguaje_hijo lengHIJO : lengPADRE.value()) {
            System.out.println(lengHIJO.value());
        }
    }
}
