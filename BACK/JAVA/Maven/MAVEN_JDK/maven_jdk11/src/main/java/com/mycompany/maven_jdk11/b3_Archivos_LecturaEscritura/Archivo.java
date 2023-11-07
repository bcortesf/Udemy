/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maven_jdk11.b3_Archivos_LecturaEscritura;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * https://www.youtube.com/watch?v=VwasVwl5Dco&list=PLvimn1Ins-41uwtb28Jj0Aw4gKV6FGsyH&index=6
 * @author BryanCFz
 */
public class Archivo {
    private final String URL_LOCAL = "C:/RE/MAVEN_JDK/maven_jdk11/src/main/java/com/mycompany/maven_jdk11/b3_Archivos_LecturaEscritura/prueba.txt";
    private final String URL_LOCAL2 = "C:/RE/MAVEN_JDK/maven_jdk11/src/main/java/com/mycompany/maven_jdk11/b3_Archivos_LecturaEscritura/prueba2.txt";
    
    public void leer() {
        try {
            String contenido = Files.readString(Path.of(URL_LOCAL));
            System.out.println(contenido);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribir() {
        try {
            //a partir del archivo "prueba.txt", creamos una copia y lo sobreescibimos como nuevo archivo
            Path path = Files.writeString(
                    Path.of(URL_LOCAL2),
                    "Desde JDK 11!",
                    StandardOpenOption.CREATE_NEW                         //seleccionar la opcion con le tipo de archivo
            );
            System.out.println("path:" + path);
            
            //leemos el conenido del nuevop archivo y lo mostramos
            String contenido = Files.readString(path);
            System.out.println(contenido);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
