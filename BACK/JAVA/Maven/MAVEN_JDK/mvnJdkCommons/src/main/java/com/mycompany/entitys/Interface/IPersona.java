/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entitys.Interface;

import com.mycompany.entitysRecords.Persona;

/**
 *
 * @author BryanCFz
 */
@FunctionalInterface
public interface IPersona {
    /**
     * De la clase<Persona>, se usan los mismos parametros: <Persona(int id, String nombre, String direccion)>,
     * para esta interfaz con el metodo                   :   <Crear(int id, String nombre, String direccion)>
     * @param id
     * @param nombre
     * @param direccion
     * @return 
     */
    public Persona Crear(int id, String nombre, String direccion);
}
