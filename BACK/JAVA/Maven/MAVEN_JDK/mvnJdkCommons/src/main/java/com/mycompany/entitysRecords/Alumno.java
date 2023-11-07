/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entitysRecords;

/**
 * https://www.makigas.es/series/java/records-de-java-que-son-y-como-usarlos
 * https://www.makigas.es/series/java/como-le-pongo-un-setter-a-un-record-de-java
 * @author BryanCFz
 */
public record Alumno(String nombre) {

    public String nombre() {
        return this.nombre;
    }
}
