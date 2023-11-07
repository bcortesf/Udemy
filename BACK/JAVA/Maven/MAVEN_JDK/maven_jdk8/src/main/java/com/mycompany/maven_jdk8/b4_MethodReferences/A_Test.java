/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk8.b4_MethodReferences;

import com.mycompany.entitys.Interface.IPersona;
import com.mycompany.entitysRecords.Persona;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 * //throw new UnsupportedOperationException("Not supported yet.");
 * @author BryanCFz
 */
public class A_Test {
    
    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk8.b4_MethodReferences".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        /**
         * https://www.google.com/search?q=java+8+metodo+por+referencia&oq=java+8+metodo+por+refe&gs_lcrp=EgZjaHJvbWUqBwgBECEYoAEyBggAEEUYOTIHCAEQIRigATIHCAIQIRigATIHCAMQIRigAdIBCDU0MzRqMGo3qAIAsAIA&sourceid=chrome&ie=UTF-8&bshm=rimc/1#vhid=iysnqWDVGOPVtM&vssid=l
         * https://emanuelpeg.blogspot.com/2017/12/referencia-metodos-en-java-8.html
         *  implementar referencias a métodos:
         *      - métodos estáticos
         *      - métodos instancia
         *      - métodos constructores.
         */
        A_Test r = new A_Test();

        System.out.println("=================================================");
        System.out.println("->REFERENCIAR METODO STATIC ");
        r.operar(); //-> llama al metodo: Test.referenciarMetodoStatic();
        
        System.out.println("=================================================");
        System.out.println("->REFERENCIAR METODO INSTANCIA; OBJETO ARBITRARIO - metodos de objetos primitivos o librerias java  ");
        //->REFERENCIAR METODO INSTANCIA; DE UN OBJETO, DE UNA CLASE PARTICULAR
        r.referenciarMetodoInstanciaObjetoArbitrario();
        
        System.out.println("=================================================");
        System.out.println("->REFERENCIAR METODO INSTANCIA; OBJETO PARTICULAR - instancia de objeto clase personalizada");
        A_IOperacion operacion = r::referenciarMetodoInstanciaObjetoParticular;
        operacion.saludar();
        
        System.out.println("=================================================");
        System.out.println("->REFERENCIAR METODO CONSTRUCTOR ");
        r.referenciarMetodoConstructor();
        
        System.out.println("=================================================");
        
        System.out.println("=================================================");
    }
    
    public void operar() {
        System.out.println("+ Con {expresion-lambda}: OPERADOR \"->\"");
                               //saludar()
        A_IOperacion operacion =      ()      -> A_Test.referenciarMetodoStatic();  //Declara la funcion
        operacion.saludar();                                                        //Ejecuta la funcion
        
        ////////////////////////////////////////////////////////////////////////
        System.out.println("+ Con {metodo-referencia}: OPERADOR \"::\"");
        /** Reemplazo de la <expresion-lambda> de {IOperacion operacion1} por un <metodo-referencia()> */        
        A_IOperacion operacionA = A_Test::referenciarMetodoStatic;                  //Declara la funcion
        operacionA.saludar();                                                       //Ejecuta la funcion

    }
    private static void referenciarMetodoStatic() {
        System.out.println("\t-> Metodo referido static \n");
    }

    private void referenciarMetodoInstanciaObjetoArbitrario() {
        String nombres[] = {"Mitocode", "Code", "Bryan"};
        
        boolean esJAVA8 = true;
        if (!esJAVA8) {
            System.out.println("esJAVA -> 7");
            Arrays.sort(nombres, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
        }
        // https://youtu.be/FkW4B6pOA1s?list=PLvimn1Ins-419yVe5iPfiXrg4mZJl5kLS&t=498
        if (esJAVA8) {
            System.out.println("esJAVA -> 8");
            //->lambda
            //Arrays.sort(nombres, (String o1, String o2) -> o1.compareTo(o2));
            
            /**
             * -CLASE::metodo
             * compareTo: es un metodo de la "instancia" que viene de la variable <String.nombres>
             */
            Arrays.sort(nombres, String::compareTo);
        }
        
        System.out.println(Arrays.toString(nombres));
    }
    private void showListStrings(String list[]) {
        for (String string : list) {
            System.out.println(string);
        }
    }

    private void referenciarMetodoInstanciaObjetoParticular() {
        /**
         * -CLASE::metodo   ~~ Persona::compareTo
         * compareTo: es un metodo de la "instancia" que viene de la variable <Persona>
         */
        System.out.println("metodo particular");
    }

    private void referenciarMetodoConstructor() {
        boolean esJAVA8 = true;
        if (!esJAVA8) {
            System.out.println("esJAVA -> 7");
            
            IPersona iper = new IPersona() {
                @Override
                public Persona Crear(int id, String nombre, String direccion) {
                    return new Persona(id, nombre, direccion);
                }
            };
            
            Persona persona = iper.Crear(1, "nombre", "direccion");
            System.out.println(persona);
        }
        // https://www.youtube.com/watch?v=FkW4B6pOA1s&list=PLvimn1Ins-419yVe5iPfiXrg4mZJl5kLS&t=661s
        if (esJAVA8) {
            System.out.println("esJAVA -> 8");
            //->lambda
            //                 mismos-nombres-interfaz ->          
            IPersona iperLam = (id, nombre, direccion) -> new Persona(id, nombre, direccion);
            Persona personaLamda = iperLam.Crear(1, "nombre", "direccion");
            
            //->metodo-referencia
            IPersona iperMet = Persona::new;
            Persona personaMRef1 = iperLam.Crear(2, "nombreB", "direccioB");
            Persona personaMRef2 = iperLam.Crear(3, "nombreC", "direccioC");
            
            List<Persona> list = Arrays.asList(
                    personaLamda,
                    personaMRef1,
                    personaMRef2
            );
            
            System.out.println(personaLamda);
            System.out.println("\nLista personas:");
            System.out.println(Arrays.toString(list.toArray()) );
        }
        
        
    }
}
