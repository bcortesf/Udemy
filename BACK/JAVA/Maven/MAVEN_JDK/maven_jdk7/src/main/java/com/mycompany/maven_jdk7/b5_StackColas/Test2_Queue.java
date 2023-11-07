/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk7.b5_StackColas;

import com.mycompany.entitys.comparable.Persona_impComparable;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author BryanCFz
 */
public class Test2_Queue {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk7.b5_StackColas.Queue".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        /**
         * "LIFO"    :LastIn  - FirstOut {Ultimo-en-entrar  --> Primero-en-salir}  pilas
         * "FIFO"    :FirstIn - FirstOut {Primero-en-entrar --> Primero-en-salir}  colas
         * 
         * Para el metodo SEARCH:
         *  - Se necesita de una clase <Comparable>
         *  - Sobreescrir los metodos (Equal, hascode)
         *    EJ: pilas.search(personaImpComparable)
         */
        
        //----------------------------------------------------------------------
//        queueString();
        //----------------------------------------------------------------------
        
        
        // https://www.youtube.com/watch?v=RkjdlvTY03s&list=PLvimn1Ins-43qPXR3gBcxwe7tydxZtsON&index=18
        Queue<Persona_impComparable> colas = getQueuePersonaComparable();
        showQueuePersonaComparable(colas);
        
        System.out.println("------------------------");
        System.out.println("\nFIFO:  EL PRIMER  USUARIO EN ATENDER ES");
        System.out.println(colas.peek());
        System.out.println("------------------------");
        
        attendQueuePersonaComparable(colas);

    }
    
    public static void queueString() throws InterruptedException {
        Queue<String> colas = new PriorityQueue<>();
        colas.offer("1-Mitocode");
        colas.offer("2-Mito");
        colas.offer("3-Code");
        colas.offer("4-Bryan");
        
        System.out.println("GUARDADO DE ELEMENTOS");
        for (String pila : colas) {
            System.out.println(pila);
        }
        
        System.out.println("------------------------");
        //FIFO: Cuenta del ultimo hasta primer registro
//        System.out.println("\nBUSCAR USUARIO :: ESTA EN LA POSICION [" + colas. search("2-Mito") + "]"); //-1, si no lo encuentra

        System.out.println("\nEL PRIMER USUARIO ES");
        System.out.println(colas.peek());
        System.out.println("------------------------");
        
        System.out.println("\nATENCION-CLIENTES-MODO:\t".concat("\"FIFO\" {FirstIn  - FirstOut}"));
        while (!colas.isEmpty()) {
            System.out.println("Atendiendo a:\t" + colas.poll() );
            //->Simulaciuon de atencion
            Thread.sleep(1000);
        }
    }

    private static Queue<Persona_impComparable> getQueuePersonaComparable() {
        Queue<Persona_impComparable> colas = new PriorityQueue<>();
        colas.offer(new Persona_impComparable(1, "1-Bryan", 28, "CL"));
        colas.offer(new Persona_impComparable(4, "4-Mitocode", 27, "CO"));
        colas.offer(new Persona_impComparable(3, "3-Mito", 25, "AR"));
        colas.offer(new Persona_impComparable(2, "2-Code",26, "MX"));
        colas.offer(new Persona_impComparable(4, "4-Mitocode", 29, "CO"));
        return colas;
    }

    private static void showQueuePersonaComparable(Queue<Persona_impComparable> colas) {
        for (Persona_impComparable cola : colas) {
            System.out.println(cola);
        }
    }

    private static void attendQueuePersonaComparable(Queue<Persona_impComparable> colas) throws InterruptedException {
        System.out.println("\nATENCION-CLIENTES-MODO:\t".concat("\"FIFO\" {FirstIn  - FirstOut}"));
        while (!colas.isEmpty()) {
            System.out.println("Atendiendo a:\t" + colas.poll() );
            //->Simulaciuon de atencion
            Thread.sleep(1000);
        }
    }
}
