/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maven_jdk8.b4_MethodReferences;

/**
 *
 * @author BryanCFz
 */
public class C_Usuario {
    private final String nombre;

    public C_Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void showNombre() {
        System.out.println(nombre);
    }

    @Override
    public String toString() {
        return "C_Usuario [nombre=" + nombre + "]";
    }

}
