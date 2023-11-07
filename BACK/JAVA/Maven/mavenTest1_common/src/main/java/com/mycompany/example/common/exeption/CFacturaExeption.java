/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.example.common.exeption;

import com.mycompany.example.common.CFactura;

/**
 *
 * @author BryanCFz
 */
public class CFacturaExeption  extends RuntimeException {
    private String mensajee;

    public CFacturaExeption() {
    }

    
    public CFacturaExeption(String message) {
        super(message);
        this.mensajee = message;
    }

    public String getMensajee() {
        return mensajee;
    }
    public void setMensajee(String mensaje) {
        this.mensajee = mensaje;
    }
    
    /////////////////////////////////////////////////
    /////////////////////////////////////////////////
    
    public CFacturaExeption NoSeCreaLaFactura()  throws CFacturaExeption {
        throw this;
    }
}
