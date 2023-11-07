package com.company.principios.InyeccionDependencia;

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
        this.equipo.mostrarNombre();
    }
}
