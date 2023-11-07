package com.company.principios.InyeccionDependencia;

/**
<!--.....................................................................................................................................................................................
		2 Inyección de Dependencias
		   USO:  inyección de dependencias a traves de polimorfismo
		   https://www.youtube.com/watch?v=MWtrUxvdJlw&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&index=2
..................................................................................................................................................................................... -->
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("*********************************************");
        System.out.println("com.mycompany.principios.InyeccionDependencia".toUpperCase());
        System.out.println("*********************************************".concat("\n"));

        // 
        Test ts= new Test();
        ts.EquipoMessi();
    }
    public void EquipoMessi() {
        System.out.println("\n1. ->EquipoMessi()");
        Messi messiB = new Messi(new EquipoBarcelona());  //polimorfismo : claseConcreta  =  MAPAS-PRACTICAS-CODIGO
        messiB.mostrarMiEquipo();
        
        IEquipo interMiami = new EquipoJuventus();               //polimorfismo : claseGeneral  ==  **RECOMENDADO**{BUENAS-PRACTICAS-DESARROLLO}
        Messi messiI = new Messi(interMiami);
        messiI.mostrarMiEquipo();
    }

}
