package com.bcf.generic_a;

// Clase genérica que puede contener cualquier tipo de dato
public class Caja<T> {
    private T contenido;

    public Caja(T contenido) {
        this.contenido = contenido;
    }

    public T obtenerContenido() {
        return contenido;
    }
}
