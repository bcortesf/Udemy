/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.principios.b1_InyeccionDependenciaSimple;

/**
 *
 * @author BryanCFz
 */
public class Messi {

    private IEquipo equipo;

    //inyectamos con polimorfismo
    public Messi(IEquipo equipo) {
        this.equipo = equipo;
    }
    //inyectamos con polimorfismo
    public void setEquipo(IEquipo equipo) {
        this.equipo = equipo;
    }

    //
    public void mostrarMiEquipo() {
        this.equipo.Mostrar();
    }
}