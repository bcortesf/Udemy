/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.example1.Generic;

import com.mycompany.example1.Generic.Entity.Employee;

/**
 *
 * @author BryanCFz
 */
public class WrapperEnvoltorio_objetos {
    
    private final Object entity;

    public WrapperEnvoltorio_objetos(Object entity) {
        this.entity = entity;
    }

    /**
     * Retorna una entidad
     * EJEMPLO: Employee, Department
     * @return Entity
     */
    public Object get() {
        return entity;
    }

    @Override
    public String toString() {
        return "Envolvemos {" + entity.toString() + '}';
    }
    
    

}
