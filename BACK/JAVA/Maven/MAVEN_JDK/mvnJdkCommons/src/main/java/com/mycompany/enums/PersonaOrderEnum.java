/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.enums;

/**
 *
 * @author BryanCFz
 */
public enum PersonaOrderEnum {
    ID("ID"),
    NOMBRE("NOMBRE"),
    EDAD("EDAD"),
    PAIS("PAIS");
    
    private final String nombreCampo;

    private PersonaOrderEnum(String tipoOrdenamiento) {
        this.nombreCampo = tipoOrdenamiento;
    }

    public String getNombreCampo() {
        return nombreCampo;
    }

}
