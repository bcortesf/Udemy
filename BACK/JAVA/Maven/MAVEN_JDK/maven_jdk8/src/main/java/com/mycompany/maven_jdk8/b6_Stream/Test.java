/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk8.b6_Stream;

import com.mycompany.entitysClass.Factura;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.youtube.com/watch?v=hz6hlaU5o58&list=PLvimn1Ins-419yVe5iPfiXrg4mZJl5kLS&index=9
 * @author BryanCFz
 */
public class Test {
    private List<Factura> lista;
    
    private void llenarLista(){
        // https://www.arquitecturajava.com/java-stream/
        lista = new ArrayList<>();
        lista.add(new Factura(1, "ordenador",1000));
        lista.add(new Factura(2, "movil",300));
        lista.add(new Factura(3, "impresora",200));
        lista.add(new Factura(4, "imac",1500));
        lista.add(new Factura(5, "board",29));
    }
    private void showList(List<Factura> listFactura){
        for (Factura factura : listFactura) {
            System.out.println(factura);
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk8.b6_Stream".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        //
        Test tst = new Test();
        tst.llenarLista();
        System.out.println("->LISTA ORIGINAL:");
        tst.showList(tst.lista);
        
        tst.filtrar();
        tst.ordenar();
        tst.transformar();
        tst.limitar();
        tst.contar();
    }
    
    private void filtrar() {
        //System.out.println("->LISTA FILTRADA".concat("\t:Elementos que contienen la letra 'i'"));
        //List<Factura> lst = lista.stream().filter((Factura f) -> f.getConcepto().contains("i")).toList();

        System.out.println("->LISTA FILTRADA".concat("\t:Elementos que comienzan por la letra 'i'"));
        List<Factura> lst = lista.stream()
                .filter( (Factura f) -> f.getConcepto().startsWith("i") )
                .toList();
        showList(lst);
    }
    private void ordenar() {
        /**
         * https://stackoverflow.com/questions/33487063/java-8-sort-list-of-objects-by-attribute-without-custom-comparator
                lista.sort(Comparator.comparing( (Factura f) -> f.getConcepto() ));
                lista.sort(Comparator.comparing(Factura::getImporte));
         * 
         * https://stackoverflow.com/questions/71548399/what-is-the-use-of-comparator-comparing-in-respect-to-comparator
         * https://stackabuse.com/java-8-how-to-sort-list-with-stream-sorted/
         * https://www.baeldung.com/java-8-comparator-comparing
         */
        System.out.println("->LISTA ORDENADA");      
        List<Factura> nombreASCSortedList = lista.stream()
                .sorted(Comparator.comparing(Factura::getConcepto))
                .collect(Collectors.toList());
        
        List<Factura> nombreDESCSortedList = lista.stream()
                .sorted( (Factura f1, Factura f2) -> f2.getConcepto().compareTo(f1.getConcepto()) )
                .collect(Collectors.toList());


        List<Factura> importeASCSortedList = lista.stream()
                .sorted(Comparator.comparingDouble(Factura::getImporte))
                .collect(Collectors.toList());
        
        List<Factura> importeDESCSortedList = lista.stream()
                .sorted(Comparator.comparingDouble(Factura::getImporte).reversed())
                .collect(Collectors.toList());
        
        showList(importeDESCSortedList);
    }
    private void transformar() {
        System.out.println("->LISTA TRANSFORMADA");
        
        System.out.println("\n  ++ Transformar a lista de Strings");
        List<String> lstString = lista.stream()
                .map((Factura f) -> 
                    f.getConcepto().toUpperCase()
                ).toList();
        lstString.forEach(System.out::println);

        System.out.println("\n  ++ Transformar a lista de Integer numero doble");
        List<Integer> lstInteger = lista.stream()
                .map((Factura f) -> 
                    f.getId() * 2
                ).toList();
        lstInteger.forEach(System.out::println);


        List<Factura> lstFactura = lista.stream()
                .map((Factura f) -> {
                    f.setConcepto( f.getConcepto().toUpperCase() );
                    return f;
                } ).toList();
        showList(lstFactura);
    }
    private void limitar() {
        System.out.println("->LISTA LIMITADA, POR NUMERO REGISTROS");
        List<Factura> lstLimitadaFactura = lista.stream()
                .limit(2).collect(Collectors.toList());
        
        showList(lstLimitadaFactura);
    }
    private void contar() {
        System.out.println("->LISTA CONTADA, POR REGISTROS");
        long cantidadRegistros = lista.stream()
                .count();
        System.out.println("total   :" + cantidadRegistros);
    }
    
    
}
