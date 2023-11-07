/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk8.a1_Predicate;

import com.mycompany.entitysClass.Factura;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *
 * @author BryanCFz
 */
public class Test {
    
    private List<Factura> lista;
    
    private void llenarListaFactura(){
        // https://www.arquitecturajava.com/java-stream/
        lista = new ArrayList<>();
        lista.add(new Factura(1, "ordenador",1000));
        lista.add(new Factura(2, "movil",300));
        lista.add(new Factura(3, "impresora",200));
        lista.add(new Factura(4, "imac",1500));
    }
    private Factura filtrarImporteMayorA300() {
        return lista.stream()
                .filter((Factura f) -> f.getImporte() > 300)  //Factura1, Factura4
                .findFirst().get();                           //Factura1
    }


    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk8.a1_Predicate".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        Test tst = new Test();
        tst.llenarListaFactura();
        
        Factura factura300  = tst.filtrarImporteMayorA300();
        System.out.println("Factura con importe mayor a 300-A: " + factura300 );
        
        System.out.println("Factura con importe mayor a 300-B: " + tst.usoPredicado() );
    }
    
    private Factura usoPredicado() {
        //Crear predicado
/*
        Predicate<Factura> predicado = new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                System.out.println(" iteracion ");
                return t.getImporte() > 300;
            }
        };
*/
        Predicate<Factura> predicado = (Factura t) -> {
            System.out.println("\t\t iteracion => " + t.toString());
            return t.getImporte() > 300;
        };
        
        //usar predicado
        Factura fac = lista.stream()
                .filter(predicado)
                .findFirst().get();
        return fac;
    }

}
