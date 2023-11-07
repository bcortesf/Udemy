/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk7.b5_StackColas;

import com.mycompany.entitys.comparable.Persona_impComparable;
import com.mycompany.maven_jdk7.*;
import java.util.Stack;

/**
 *
 * @author BryanCFz
 */
public class Test1_Stack {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk7.b5_StackColas.Stack".toUpperCase());
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
//        stackString();
        //----------------------------------------------------------------------
        
        
        // https://www.youtube.com/watch?v=UqngUzpnQyw&list=PLvimn1Ins-43qPXR3gBcxwe7tydxZtsON&t=502s
        Stack<Persona_impComparable> pilas = getStackPersonaComparable();
        showStackPersonaComparable(pilas);
        
        System.out.println("------------------------");
        //LIFO: Cuenta del ultimo hasta primer registro
        Persona_impComparable personaImpComparable = new Persona_impComparable(2, "2-Code",27, "MX");
        System.out.println("\nBUSCAR USUARIO :: ESTA EN LA POSICION [" + pilas.search(personaImpComparable) + "]"); //-1, si no lo encuentra

        System.out.println("\nEL ULTIMO USUARIO ES");
        System.out.println(pilas.peek());
        System.out.println("------------------------");
        
        attendStackPersonaComparable(pilas);
    }
    
    public static void stackString() throws InterruptedException {
        Stack<String> pilas = new Stack<>();
        pilas.push("1-Mitocode");
        pilas.push("2-Mito");
        pilas.push("3-Code");
        pilas.push("4-Bryan");
        
        System.out.println("GUARDADO DE ELEMENTOS");
        for (String pila : pilas) {
            System.out.println(pila);
        }
        
        System.out.println("------------------------");
        //LIFO: Cuenta del ultimo hasta primer registro
        System.out.println("\nBUSCAR USUARIO :: ESTA EN LA POSICION [" + pilas.search("2-Mito") + "]"); //-1, si no lo encuentra

        System.out.println("\nEL ULTIMO USUARIO ES");
        System.out.println(pilas.peek());
        System.out.println("------------------------");
        
        System.out.println("\nATENCION-CLIENTES-MODO:\t".concat("\"LIFO\" {LastIn  - FirstOut}"));
        while (!pilas.isEmpty()) {
            System.out.println("Atendiendo a:\t" + pilas.pop() );
            //->Simulaciuon de atencion
            Thread.sleep(1000);
        }
    }

    private static Stack<Persona_impComparable> getStackPersonaComparable() {
        Stack<Persona_impComparable> pilas = new Stack<>();
        pilas.push(new Persona_impComparable(4, "4-Mitocode", 25, "CO"));
        pilas.push(new Persona_impComparable(3, "3-Mito", 26, "AR"));
        pilas.push(new Persona_impComparable(2, "2-Code",27, "MX"));
        pilas.push(new Persona_impComparable(1, "1-Bryan", 28, "CL"));
        return pilas;
    }

    private static void showStackPersonaComparable(Stack<Persona_impComparable> pilas) {
        for (Persona_impComparable pila : pilas) {
            System.out.println(pila);
        }
    }

    private static void attendStackPersonaComparable(Stack<Persona_impComparable> pilas) throws InterruptedException {
        System.out.println("\nATENCION-CLIENTES-MODO:\t".concat("\"LIFO\" {LastIn  - FirstOut}"));
        while (!pilas.isEmpty()) {
            System.out.println("Atendiendo a:\t" + pilas.pop() );
            //->Simulaciuon de atencion
            Thread.sleep(1000);
        }
    }
}
