/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk11.b1_MetodosStrings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.youtube.com/watch?v=9ex7i535V78&list=PLvimn1Ins-41uwtb28Jj0Aw4gKV6FGsyH&t=90s
 * @author BryanCFz
 */
public class Test {
    
    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk11.b1_MetodosStrings".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        // 
        Test ts = new Test();
        ts.estaVacio(" ");
        ts.repetir("Bryan", 0);
        ts.convertirLista("texto a lista");//1 dato
        ts.convertirLista("datoA\ndatoB\ndatoC");//3 datos: delimitador es "\n"
        ts.removerEspacios(" BRYAN CF ");
        
    }
    public void estaVacio(String texto) {
        System.out.println("\n1. ->estaVacio()");
        System.out.println("tam[" + texto.length() + "] :" + texto.isBlank());  //11
        //System.out.println("tam[" + texto.length() + "] :" + texto.isEmpty());  //1.6
    }
    public void repetir(String texto, int cantidad) {
        System.out.println("\n2. ->repetir()");
        var palabraRepetida = texto.repeat(3);
        
        System.out.println("* package + tipo de dato  :" + palabraRepetida.getClass().getName());
        System.out.println("* tipo de dato            :" + palabraRepetida.getClass().getSimpleName());
        System.out.println(palabraRepetida);
    }

    public void convertirLista(String texto) {
        //El metodo convertirLista() no funciona. En el texto en lugar de ',' se le debe pasar '\n' o '\r' para que los pueda dividir.
        System.out.println("\n3. ->convertirLista()");
        List<String> list = texto.lines()
                .collect(Collectors.toList());
        System.out.println(list);
        System.out.println("tamaño:" + list.size());
    }

    public void removerEspacios(String texto) {
        System.out.println("\n4. ->removerEspacios()");
        String texto_strip         = texto.strip();
        String texto_stripLeading  = texto.stripLeading();
        String texto_stripTrailing = texto.stripTrailing();
        String texto_trim          = texto.trim();
        
        System.out.println("**ORIGINAL-TEXTO**,tam[" + texto.length()               + "]" + texto);              //10
        System.out.println("strip             ,tam[" + texto_strip.length()         + "]" + texto_strip);        //8, remueve espacios (izquierda,derecha)
        System.out.println("stripLeading      ,tam[" + texto_stripLeading.length()  + "]" + texto_stripLeading); //9, remueve espacios (izquierda)
        System.out.println("stripTrailing     ,tam[" + texto_stripTrailing.length() + "]" + texto_stripTrailing);//9, remueve espacios (derecha)
        System.out.println("trim              ,tam[" + texto_trim.length()          + "]" + texto_trim);         //8, remueve espacios (izquierda,derecha)
    }
}
