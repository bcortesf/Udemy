/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk8.b1_LambdaScope;

/**
 *
 * @author BryanCFz
 */
public class Test3_alcance {
    
    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk8.b1_LambdaScope.3-SCOPE".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        /**
         * ALCANCE CON VARIABLES -> LOCALES
         * ALCANCE CON VARIABLES -> GLOBALES STATICAS
         * ALCANCE CON VARIABLES -> GLOBALES  Y  NO_STATICAS
         * 
         * En resumen las lambdas tienen el mismo "variable scope" que las innersclass, que son: 
         *      - SOLO LECTURA: para variables locales
         *      - ESCRITURA/LECTURA: para variables globales o atributos de clases ya sean estáticos o no.
         * 
         * En Java 11: 
         *      - SOLO LECTURA: para variables locales y globales
         *      - ESCRITURA/LECTURA: para variables globales estáticas.
         */
        Test3_alcance tst = new Test3_alcance();

        System.out.println("=================================================");
        System.out.println("->ALCANCE CON VARIABLES -> LOCALES ");

        System.out.println( "Calcular numeroLocal JDK7: " +
                tst.scopeLocal_variable_JDK7()
        );// B
        System.out.println( "Calcular numeroLocal JDK8: " +
                tst.scopeLocal_variable_JDK8()
        );// B
        
        System.out.println("=================================================");
        System.out.println("->ALCANCE CON VARIABLES -> GLOBALES STATICAS ");

        System.out.println( "Calcular numeroGlobalStatic JDK8: " +
                tst.scopeAtributoGlobalStatic_variables()
        );// B
        
        System.out.println("=================================================");
        System.out.println("->ALCANCE CON VARIABLES -> GLOBALES  Y  NO_STATICAS ");

        System.out.println( "Calcular numeroGlobal JDK8: " +
                tst.scopeAtributoGlobal_variables()
        );// B
        
//        System.out.println("=================================================");
//        System.out.println("->ALCANCE CON VARIABLES -> NO_STATICAS ");
//
//        System.out.println( "El promedio de {" + 2 + "+" + 3 + "} /2 = " +
//                tst.scopeB_variable()
//        );// B
        
        System.out.println("=================================================");
    }

    public double Calcular() {
        IOperacion operacion = (double numero1, double numero2) -> (numero1 + numero2) /2;
        return     operacion.calcularPromedio(2, 3);// (2+3)=5 -> 5/2=2.5
    }
    
    //EXPLICACION con JDK7
    public double scopeLocal_variable_JDK7() {
        final double numeroLocal = 6; //Al tener un INNER-CLASS, la VARIABLE-LOCAL, se convierte en:  (inmutable)->final

        IOperacion operacion = new IOperacion() {
            @Override
            public double calcularPromedio(double numero1, double numero2) {
                //numeroLocal = numero1 + numero2;  //->ERROR: No se puede cambiar valores de {VARIABLES_LOCALES} desde:  "(innerClass o claseAnonima)"
                return numeroLocal + numero1 + numero2;
            }
        };

        return operacion.calcularPromedio(2, 3);
    }
    //EXPLICACION con JDK8
    public double scopeLocal_variable_JDK8() {
        final double numeroLocal = 6; //Al tener un INNER-CLASS, la VARIABLE-LOCAL, se convierte en:  (inmutable)->final

        IOperacion operacion      = (double numero1, double numero2) -> numeroLocal + numero1 + numero2;
        IOperacion operacionERROR = (double numero1, double numero2) -> {
            //numeroLocal = 1;  //->ERROR: No se puede cambiar valores de {VARIABLES_LOCALES} desde:  "(innerClass o claseAnonima)"
            return numeroLocal + numero1 + numero2;
        };

        return operacion.calcularPromedio(1, 1);
    }

    private static double numeroGlobalStatic;
    public double scopeAtributoGlobalStatic_variables() {
        IOperacion operacion = (double numero1, double numero2) -> {
            numeroGlobalStatic = numero1 + numero2;
            return numeroGlobalStatic;
        };
        
        return operacion.calcularPromedio(1, 2);
    }
    
    private double numeroGlobal;
    public double scopeAtributoGlobal_variables() {
        IOperacion operacion = (double numero1, double numero2) -> {
            numeroGlobal = numeroGlobalStatic;
            return numeroGlobal;
        };
        
        return operacion.calcularPromedio(1, 1);
    }
    
    public double scopeB_variable() {
        throw new UnsupportedOperationException("definirB");
    }
}
