/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk8.b2_DefaultMethod;

/**
 * https://www.youtube.com/watch?v=Ixn8Ypri90w&t=185s
 * throw new UnsupportedOperationException("Not supported yet.");
 * @author BryanCFz
 */
public class Test implements IPersonaAmerica, IPersonaEuropa {
    
    @Override
    public void Caminar() {
        System.out.println("caminar en 2");
    }

    /**
     * Como tenemos el mismo METODO<HablarEspañol()> en la dos INTERFACES:  { <IPersonaAmerica>, <IPersonaEuropa> }
     * Debemos sobreescribir el METODO<HablarEspañol()>, porque  "JAVA NO SABRIA":
     *      - ¿A cual METODO<HablarEspañol()> hacer referencia; de las dos interfaces { <IPersonaAmerica>, <IPersonaEuropa> } ?
     */
    @Override
    public void HablarEspañol() {
        //ESCOGER DOS IDIOMAS POR DEFECTO       :funciona, pero es errado, porque viola el principio de -> <1 solo metodo>
        //IPersonaAmerica.super.HablarEspañol();
        //IPersonaEuropa.super.HablarEspañol();

        final boolean ES_COLOMBIA = true;
        if (!ES_COLOMBIA) {
            //escoger un idioma<COLOMMBIA> por defecto         :method-Default
            IPersonaAmerica.super.HablarEspañol();
        } else {
            //escoger un idioma<ESPAÑA> por defecto            :method-Default
            IPersonaEuropa.super.HablarEspañol();
        }
    }

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk8.b2_DefaultMethod".toUpperCase());
        System.out.println("*****************************************".concat("\n"));


        Test tst = new Test();
        tst.Caminar();

        //DEFAULT-METHOD-INTERFACE-1
        tst.HablarEspañol();        /** <COLOMBIA> ó <ESPAÑA> */
        tst.HablarIngles();
        
    }
}
