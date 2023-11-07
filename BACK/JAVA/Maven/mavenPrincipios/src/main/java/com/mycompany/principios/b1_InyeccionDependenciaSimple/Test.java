/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.principios.b1_InyeccionDependenciaSimple;

import com.mycompany.principios.*;

/**
 *
 * @author BryanCFz
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.principios.b1_InyeccionDependenciaSimple".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        // 
        Test ts= new Test();
        ts.EquipoMessi();
    }
    public void EquipoMessi() {
        System.out.println("\n1. ->EquipoMessi()");
        Messi messiB = new Messi(new Barcelona());  //polimorfismo
        messiB.mostrarMiEquipo();
        
        IEquipo interMiami = new InterMiamiCF();    //polimorfismo
        Messi messiI = new Messi(interMiami);
        messiI.mostrarMiEquipo();
    }
}
