/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk7.b5_StackColas;

import com.mycompany.entitys.comparable.Persona_impComparable;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author BryanCFz
 */
public class Test3_Deque {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk7.b5_StackColas.Deque".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        /**
         * "LIFO y FIFO"    :es mixto de  una PILA y una COLA
         * 
         * Para el metodo SEARCH:
         *  - Se necesita de una clase <Comparable>
         *  - Sobreescrir los metodos (Equal, hascode)
         *    EJ: pilas.search(personaImpComparable)
         */
        
        //----------------------------------------------------------------------
        dequeString();
        //----------------------------------------------------------------------
        
        /*
        https://www.youtube.com/watch?v=LQF0PhlHx54&list=PLvimn1Ins-43qPXR3gBcxwe7tydxZtsON&index=19
        Deque<Persona_impComparable> colas = getDequePersonaComparable();
        showDequePersonaComparable(colas);
        
        System.out.println("------------------------");
        System.out.println("\nFIFO:  EL PRIMER  USUARIO EN ATENDER ES");
        System.out.println(colas.peek());
        System.out.println("------------------------");
        
        attendDequePersonaComparable(colas);
        */
    }
    
    public static void dequeString() throws InterruptedException {
        Deque<String> colas = new ArrayDeque<>();
        colas.add("1-Bryan");
        colas.add("2-Mito");
        colas.add("3-Code");
        
        System.out.println("GUARDADO DE ELEMENTOS");
        for (String pila : colas) {
            System.out.println(pila);
        }
        
        System.out.println("------------------------");
        //F:    

        System.out.println("\nEL PRIMER USUARIO ES:");
        System.out.println(colas.peek());                      //->mostrar primer elemento              :"1-Bryan"
        System.out.println("\nEL PRIMER USUARIO REMOVIDO ES:");
        System.out.println(colas.poll());                      //->mostrar y eliminar primer elemento   :"1-Bryan"
        System.out.println("\nEL PRIMER USUARIO REMOVIDO ES:");
        System.out.println(colas.pop());                       //->Remueve y retorna primer elemento    :"2-Mito"
        colas.addFirst("1-MitoCode");
        System.out.println("------------------------");
        
        for (String pila : colas) {
            System.out.println(pila);                          //                                       :{"1-MitoCode", "3-Code"}
        }
    }

    private static Deque<Persona_impComparable> getDequePersonaComparable() {
        Deque<Persona_impComparable> colas = new ArrayDeque<>();
        colas.offer(new Persona_impComparable(1, "1-Bryan", 28, "CL"));
        colas.offer(new Persona_impComparable(4, "4-Mitocode", 27, "CO"));
        colas.offer(new Persona_impComparable(3, "3-Mito", 25, "AR"));
        colas.offer(new Persona_impComparable(2, "2-Code",26, "MX"));
        colas.offer(new Persona_impComparable(4, "4-Mitocode", 29, "CO"));
        return colas;
    }

    private static void showDequePersonaComparable(Deque<Persona_impComparable> colas) {
        for (Persona_impComparable cola : colas) {
            System.out.println(cola);
        }
    }
}
