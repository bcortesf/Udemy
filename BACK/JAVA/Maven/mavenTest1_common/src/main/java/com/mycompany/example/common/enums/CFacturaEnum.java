/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.example.common.enums;

/**
 *
 * @author BryanCFz
 */
public enum CFacturaEnum {
    FACTURA_NULL("La factura es null ó nula"),
    FACTURA_CERO("Factura invalida, porque el precio es cero :("),
    FACTURA_NO_FIN_DE_SEMANA("No se emiten facturas, los fines de semana!");
    
    ////////////////////////////////////////////////////////////////////////////
    private final String mensaje;

    private CFacturaEnum(String mensaje) {
        this.mensaje = mensaje;
    } 

    public String getMensaje() {
        return mensaje;
    }
}
