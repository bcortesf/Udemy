/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maven_jdk7.b2_OrdenarColecciones;

import com.mycompany.entitysClass.Persona;
import java.util.Comparator;

/**
 *                            ***COMPARATOR***
 *                      POSITIVO     :si(obj1.x > obj2.x)
 *                      0            :si(obj1.x = obj2.x)
 *                      NEGATIVO     :si(obj1.x < obj2.x)
 * @author BryanCFz
 */
public class Object_CustomComparator implements Comparator<Object> {
    
    private final String tipoCampo;

    public Object_CustomComparator(String tipoCampo) {
        this.tipoCampo = tipoCampo;
    }

    // Ordenamiento Ascendente
    @Override
    public int compare(Object obj1, Object obj2) {
        Persona persona1 = (Persona)obj1;
        Persona persona2 = (Persona)obj2;
        if (this.tipoCampo.equals("Persona.nombre")) {
            return persona1.getNombre().compareTo(persona2.getNombre());
        }
        if (this.tipoCampo.equals("Persona.pais")) {
            return persona1.getPais().compareTo(persona2.getPais());
        }
        if (this.tipoCampo.equals("Persona.id")) {
            return persona1.getId() - persona2.getId();
        }
        if (this.tipoCampo.equals("Persona.edad")) {
            return persona1.getEdad() - persona2.getEdad();
        }
        return 0;
    }
    
}
