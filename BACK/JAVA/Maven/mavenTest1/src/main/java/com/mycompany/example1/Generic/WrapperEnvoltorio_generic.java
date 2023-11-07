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
public class WrapperEnvoltorio_generic<ENTITY_GENERIC> {
    
    private final ENTITY_GENERIC entity;

    public WrapperEnvoltorio_generic(ENTITY_GENERIC entity) {
        this.entity = entity;
    }

    /**
     * Retorna una entidad
     * EJEMPLO: Employee, Department
     * @return Entity
     */
    public ENTITY_GENERIC get() {
        return entity;
    }

    @Override
    public String toString() {
        return "Envolvemos [" + entity.toString() + ']';
    }
    
    

}
