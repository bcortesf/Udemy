/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk11.b3_Archivos_LecturaEscritura;

/**
 * https://www.youtube.com/watch?v=VwasVwl5Dco&list=PLvimn1Ins-41uwtb28Jj0Aw4gKV6FGsyH&index=6
 * @author BryanCFz
 */
public class Test {
    
    private final Archivo archivo = new Archivo();

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk11.b3_Archivos_LecturaEscritura".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        // 
        Test ts = new Test();
//        ts.leerArchivo();
        ts.escribirArchivo();
    }
    public void leerArchivo() {
        System.out.println("\n1. ->leerArchivo()");
        archivo.leer();
    }
    public void escribirArchivo() {
        System.out.println("\n2. ->escribirArchivo()");
        archivo.escribir();
    }
}
