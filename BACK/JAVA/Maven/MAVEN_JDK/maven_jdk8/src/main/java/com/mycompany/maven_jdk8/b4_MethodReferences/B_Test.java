/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk8.b4_MethodReferences;

import java.util.Arrays;


/**
 * //throw new UnsupportedOperationException("Not supported yet.");
 * @author BryanCFz
 */
public class B_Test {
    
    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk8.b4_MethodReferences.B_Test".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        /**
         * https://www.google.com/search?q=java+8+metodo+por+referencia&oq=java+8+metodo+por+refe&gs_lcrp=EgZjaHJvbWUqBwgBECEYoAEyBggAEEUYOTIHCAEQIRigATIHCAIQIRigATIHCAMQIRigAdIBCDU0MzRqMGo3qAIAsAIA&sourceid=chrome&ie=UTF-8&bshm=rimc/1#vhid=iysnqWDVGOPVtM&vssid=l
         * https://emanuelpeg.blogspot.com/2017/12/referencia-metodos-en-java-8.html
         *  implementar referencias a métodos:
         *      - Referencia a un método de una instancia
         * 
         *      - métodos instancia
         *      - métodos constructores.
         */
        B_Test instancia = new B_Test();

        System.out.println("=================================================");
        System.out.println("->REFERENCIA A UN MÉTODO DE UNA INSTANCIA: ");
            System.out.println("Con expresion-lambda    \"->\"");
                                                   //-> { inst.display(tipoMetodoRef); };
                B_IDemo ia1 = (String tipoMetodoRef) -> instancia.displayMESSAGE(tipoMetodoRef); //Declara la funcion
                ia1.show("\t-> Metodo referido de instancia \n");              //Ejecuta la funcion

            System.out.println("Con method-references    \"::\"");
                B_IDemo ib2 = instancia::displayMESSAGE;                                         //Declara la funcion
                ib2.show(instancia.referenciarMetodoInstancia());              //Ejecuta la funcion
        
        System.out.println("=================================================");
        System.out.println("->REFERENCIA A UN MÉTODO ESTÁTICO: ");
//      B_IDemo ic1 = (String tipoMetodoRef) -> B_Test.displayStaticMESSAGE(tipoMetodoRef);       
        B_IDemo ic1 = B_Test::displayStaticMESSAGE;
        ic1.show( B_Test.referenciarMetodoStatic() );
        
        System.out.println("=================================================");
        System.out.println("->REFERENCIA A UN MÉTODO DE INSTANCIA DE UN OBJETO ARBITRARIO; DE UN TIPO PARTICULAR: ");
            String colors[] = {"pink", "orange", "black", "red"};
            
            Arrays.sort(colors, String::compareToIgnoreCase);
            Arrays.asList(colors).forEach( System.out::println );                         //method-reference
            //Arrays.asList(colors).forEach( (String color) -> System.out.println(color) ); //expresion-lambda
        
        System.out.println("=================================================");
        System.out.println("->REFERENCIA A UN CONSTRUCTOR: ");
        B_IName id1 = (String nombreCompleto) ->  new B_PersonaFullName(nombreCompleto);      //expresion-lambda
        B_IName id2 = B_PersonaFullName::new;                                                 //method-reference
        id2.showName("BryanCFz");
        

        //instancia.referenciarMetodoConstructor();
        
        System.out.println("=================================================");
        
        System.out.println("=================================================");
    }

    ///////////////////////////////////////////
    public void displayMESSAGE(String tipoMetodoRef) {
        System.out.println("" + tipoMetodoRef);
    }
    
    public static void displayStaticMESSAGE(String tipoMetodoRef) {
        System.out.println("" + tipoMetodoRef);
    }
    ///////////////////////////////////////////

/////////
    private String referenciarMetodoInstancia() {
        return "\t-> Método referido de instancia \n";
    }
    
    
    private static String referenciarMetodoStatic() {
        return "\t-> Método referido static \n";
    }

    private static String referenciarMetodoInstanciaObjetoArbitrario_DeTipoParticular() {
        return "\t-> Método referido de instancia de un objeto arbitrario; De un tipo particular: \n";
    }

    private static String referenciarMetodoConstructor() {
        return "BryanCFz";
    }
}
