/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.example.common.exeption;

import com.mycompany.example.common.enums.CFacturaEnum;

/**
 *
 * @author BryanCFz
 */
public class CFacturaValidador {
    private String mensaje;
    
    public CFacturaValidador() {
    }
    public CFacturaValidador(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {             //los tengo para manejo opcional
        return mensaje;
    }
    public void setMensaje(String mensaje) { //los tengo para manejo opcional
        this.mensaje = mensaje;
    }
    
    
    public CFacturaExeption esFacturaCero()  throws CFacturaExeption {
        this.setMensaje(CFacturaEnum.FACTURA_CERO.getMensaje());
        throw new CFacturaExeption(getMensaje());
    }
    
    public CFacturaExeption esFacturaNula()  throws CFacturaExeption {
//        throw new CFacturaExeption(CFacturaEnum.FACTURA_NULL.getMensaje());
        //
//        CFacturaExeption exepcion = new CFacturaExeption(CFacturaEnum.FACTURA_NULL.getMensaje());
//        throw  exepcion;
        //
        
        CFacturaExeption exepcion = new CFacturaExeption();
        exepcion.setMensajee(CFacturaEnum.FACTURA_NULL.getMensaje());
        throw exepcion.NoSeCreaLaFactura();
    }

}
