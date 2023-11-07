/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk8.a1_Supplier;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BryanCFz
 */
public class Test {
    
    private List<String> lista;
    
    private void llenarLista(){
        lista = new ArrayList<>();
        lista.add("MitoCode");
        lista.add("Mito");
        lista.add("Code");
    }

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk8.a1_Supplier".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        // https://www.arquitecturajava.com/java-8-functional-interfaces-y-sus-tipos/
        Test tst = new Test();
        tst.llenarLista();
    }

}
