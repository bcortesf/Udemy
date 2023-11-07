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
public class NombreComparator implements Comparator<Object> {

    // Ordenamiento Ascendente
    @Override
    public int compare(Object obj1, Object obj2) {
        Persona persona1 = (Persona)obj1;
        Persona persona2 = (Persona)obj2;
        return persona1.getNombre()
            .compareTo(persona2.getNombre());
    }
    
}
