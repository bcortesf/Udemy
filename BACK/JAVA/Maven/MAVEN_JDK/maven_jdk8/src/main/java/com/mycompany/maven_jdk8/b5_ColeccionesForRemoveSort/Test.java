/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk8.b5_ColeccionesForRemoveSort;

import java.util.ArrayList;
import java.util.Collections;
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
        
        lista.add("MitoCode2");
        lista.add("Mito2");
    }

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk8.b5_COLECCIONES-ForEach-RemoveIf-Sort".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        //
        Test tst = new Test();
        tst.llenarLista();
        
        tst.usarForeach();
        tst.usarRemoveIf();
        tst.usarSort();
    }
    
    /**
     * https://www.youtube.com/watch?v=1zC4Sqipzng&list=PLvimn1Ins-419yVe5iPfiXrg4mZJl5kLS&t=107s
     * Consumer
     */
    private void usarForeach() {
        //lista.forEach((String t) -> System.out.println(t));
        lista.forEach(System.out::println);
    }
    private void usarRemoveIf() {
        // https://www.youtube.com/watch?v=1zC4Sqipzng&list=PLvimn1Ins-419yVe5iPfiXrg4mZJl5kLS&t=250s
        System.out.println("\n->REMOVER SI: cumple una condicion");
        lista.removeIf((String t) -> t.equals("MitoCode2")); //PREDICATE: una condicion boleana
        lista.removeIf("Mito2"::equalsIgnoreCase);
        usarForeach();
    }
    private void usarSort() {
        System.out.println("\n->ORDENAR ALFABETICAMENTE:");
        //lista.sort((String str1, String str2) -> str1.compareTo(str2));
        lista.sort(String::compareTo);

        //Collections.sort(lista, (String str1, String str2) -> str1.compareTo(str2));
        //Collections.sort(lista, String::compareTo);
        usarForeach();
    }
    
    
}
