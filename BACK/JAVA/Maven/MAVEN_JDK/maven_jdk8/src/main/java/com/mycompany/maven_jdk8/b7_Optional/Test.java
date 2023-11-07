/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk8.b7_Optional;

import com.mycompany.entitysRecords.Nota;
import com.mycompany.exceptions.MiExepcion;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * https://www.arquitecturajava.com/que-es-un-java-optional/
 * @author BryanCFz
 */
public class Test {
    private List<Nota> notas;
    
    private void llenarNotasUniversidad() {
        notas = new ArrayList<>();
        notas.add(new Nota("matematicas",3));
//        notas.add(new Nota("lengua",10));
        notas.add(new Nota("ingles",5));
        notas.add(new Nota("fisica",7));
    }
    private Optional<Nota> buscarNotaSobresaliente_mayor9() {
        Nota nota = null;
        for (Nota unaNota : notas) {
            if (unaNota.valor() >= 9) {
                return Optional.of(unaNota);
            }
        }
        return Optional.empty();
    }
    private void showNotaSobresaliente_mayor9(Nota nota) {
        System.out.println(nota.valor());
        System.out.println(nota.asignatura());
    }
    

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk8.b7_Optional".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        //
        Test tst = new Test();

        boolean esEjemploString = true;
        if (esEjemploString) {
            /** ->ejemplo con clase<String> */
            // tst.probar("mito");
            // tst.orElse("mito");
            // tst.orElseThrow("mito");
            // tst.isPresent("mito");

            tst.probar(null);
            tst.orElse(null);
            tst.orElseThrow(null);
            tst.isPresent(null);
        }
        if (!esEjemploString) {
            /** ->ejemplo con clase<Nota> */
            tst.llenarNotasUniversidad();

            Optional<Nota> optNota9 = tst.buscarNotaSobresaliente_mayor9();
            if (optNota9.isPresent()) {
                System.out.println("Hay nota sobresaliente mayor a 9");
                tst.showNotaSobresaliente_mayor9( optNota9.get() );
            }
            if (!optNota9.isPresent()) {
                System.err.println("No hay ninguna nota sobresaliente :S");
            }

        }

    }

public void probar(String valor) {
    System.out.println("\n->probar    :" + valor);
    try {
        Optional<Object> optional = Optional.empty();        
        optional.get(); //obtener valor
    } catch (Exception e) {
        System.err.println("No hay elemento - ".concat(e.getMessage()));
    }
}
public void orElse(String valor) {
    System.out.println("\n->orElse    :" + valor);
    
    Optional<String> optString = Optional.ofNullable(valor);
    String cadena = optString.orElse("valor predeterminado");
    System.out.println(cadena);
}
public void orElseThrow(String valor) {
    System.out.println("\n->orElseThrow    :" + valor);

    Optional<String> optString = Optional.ofNullable(valor);
    //String cadena = optString.orElseThrow();
    //String cadena = optString.orElseThrow(NumberFormatException::new);
    
    //MiExepcion error = new MiExepcion("El valor es nulin care culin");
    try {
        String  cadena = optString.orElseThrow(() -> new MiExepcion("El valor es nulin care culin"));
        System.out.println(cadena);
    } catch (MiExepcion ex) {
        ex.myLogError(ex, Test.class);
    }    
}
public void isPresent(String valor) {
    //si el valor fue inicializado o no
    System.out.println("\n->isPresent    :" + valor);
    Optional<String> optString = Optional.ofNullable(valor);
    System.out.println(optString.isPresent());
}




}
