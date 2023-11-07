/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk8.b8_StreamParalell;

import com.mycompany.entitysRecords.Nota;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * https://dzone.com/articles/whats-wrong-java-8-part-iii
 * @author BryanCFz
 */
public class Test {
    private List<Nota> notas;
    
    private void llenarNotasUniversidad() {
        notas = new ArrayList<>();
        notas.add(new Nota("matematicas",3));
        notas.add(new Nota("lengua",10));
        notas.add(new Nota("ingles",5));
        notas.add(new Nota("fisica",7));
    }
    private void showList() {
        for (Nota nota : notas) {
            System.out.println(nota);
        }
    }

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk8.b8_StreamParalell".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        //
        Test tst = new Test();
        tst.llenarNotasUniversidad();
        tst.showList();
        
        tst.probarStream();
        tst.probarStreamParalelo();
    }

    private Consumer<Nota> consumidorNotas(){
        Consumer<Nota> consumerNota = (Nota n) -> { System.out.println(n); };
        return consumerNota;
    }
    private void probarStream() {
        System.out.println("\n->probarStream();");
        notas.stream().forEach(consumidorNotas());
    }

    /**
     * parallelStream: trabaja con hilos y no se sabe su comportamiento
     */
    private void probarStreamParalelo() {
        System.out.println("\n->probarStreamParalelo();");
        Consumer<Nota> obConsumerNota = (Nota n) -> System.out.println(n);
        notas.parallelStream().forEach(obConsumerNota);
    }
}
