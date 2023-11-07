/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk8.b9_Map;

import com.mycompany.entitysRecords.Nota;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author BryanCFz
 */
public class Test {
    private Map<Integer, Nota> map;
    
    private void poblarMapa() {
        map = new HashMap<>();
        map.put(1, new Nota("matematicas",3));
        map.put(2, new Nota("lengua",10));
        map.put(3, new Nota("ingles",5));
        map.put(4, new Nota("fisica",7));
    }
    private void showMap_java7() {
        System.out.println("->showMap_java7()");
        for (Map.Entry<Integer, Nota> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Nota value = entry.getValue();
            System.out.println("key[" + key + "] - value{" + value + "}" );
            
        }
    }

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk8.b9_Map".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        //
        Test tst = new Test();
        tst.poblarMapa();
        tst.showMap_java7();

        tst.showMap();
        tst.insertarSiAusente();
        tst.operarSiPresente();
        tst.obtenerOrPredeterminado();
        tst.recolectar();
    }
    
    private void showMap() {
        System.out.println("\n->showMap()");
        /*
        map.forEach((Integer key, Nota value) -> {
            System.out.println("key[" + key + "] - value{" + value + "}" );
        });
        */
        
        map.entrySet().stream().forEach(System.out::println);
    }
    private void insertarSiAusente() {
        //System.out.println("\n->insertar_o_sobreescribir() :si la lalve existe, sobreescribe todo el value o inserta uno nuevo");
        //map.put(5, new Nota("programacion",1));
        
        System.out.println("\n->insertarSiAusente() :si la llave no esta asociada con ningun valor");
        map.putIfAbsent(5, new Nota("programacion",1));
        
        showMap();
    }
    private void operarSiPresente() {
        // https://youtu.be/n2plQQwJes0?list=PLvimn1Ins-419yVe5iPfiXrg4mZJl5kLS&t=283
        System.out.println("\n->operarSiPresente()  :si la llave existe, realizar una operacion");

        map.computeIfPresent(5, (Integer key, Nota value) -> {
            value = new Nota("java 8",2);
            return value;
        });
        
        System.out.println(map.get(5));
    }
    private void obtenerOrPredeterminado() {
        System.out.println("\n->obtenerOrPredeterminado()");
        
        //si existe la key
        Nota notaKeyOK = map.getOrDefault(1, new Nota("materiaDefault",0.0));
        System.out.println(notaKeyOK); //matematicas
        
        //no existe la key
        Nota notaKeyNULA = map.getOrDefault(10, new Nota("materiaDefault",0.0));
        System.out.println(notaKeyNULA); //materia-default
    }
    
    private void recolectar() {
        // https://www.youtube.com/watch?v=n2plQQwJes0&list=PLvimn1Ins-419yVe5iPfiXrg4mZJl5kLS&t=385s
        System.out.println("\n->recolectar()    :filtrar los elementos del map, bajo un criterio");
        Map<Integer, Nota> mapaRecolectado = map.entrySet()
                .stream()
                .filter((Map.Entry<Integer, Nota> f) -> f.getValue().valor() <= 3.0)
                .collect(Collectors.toMap((Map.Entry<Integer, Nota> k) -> k.getKey(), (Map.Entry<Integer, Nota> v) -> v.getValue()));
                
        showMapFilter(mapaRecolectado);
    }
    private void showMapFilter(Map<Integer, Nota> mapaRecolectado) {
        System.out.println("\n->showMapFilter()");
        
        mapaRecolectado.forEach((Integer key, Nota value) -> {
            System.out.println("key[" + key + "] - value{" + value + "}" );
        });
    }
}
