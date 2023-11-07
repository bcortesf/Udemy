/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.example3.JDK8_optional;

import com.mycompany.example.common.CFactura;
import com.mycompany.example.common.enums.CFacturaEnum;
import com.mycompany.example.common.exeption.CFacturaExeption;
import com.mycompany.example.common.exeption.CFacturaValidador;
import java.util.Random;

/**
 *
 * @author BryanCFz
 */
public class ProvedorFactura {
    
    public  CFactura getFactura(DiaSemana dia) {
        if (dia == DiaSemana.SABADO || dia == DiaSemana.DOMINGO) {
            throw new CFacturaExeption(CFacturaEnum.FACTURA_NO_FIN_DE_SEMANA.getMensaje());
        }
        return generarFactura();
    }
    
    public CFactura generarFactura()  {
        String id          = "F-2023-" + Utilitys.RANDOM_INT();
        double precioTotal = Utilitys.RANDOM_DOUBLE();
        return validarFactura(id, precioTotal);
    }
    
    public CFactura validarFactura(String id, double precioTotal)  {
        //precioTotal = 0; //->Test: si es cero, antes de crear factura
        if (precioTotal == 0) {
            throw new CFacturaValidador().esFacturaCero();
        }
        
        //return new CFactura(id, "ALKOSTO", precioTotal);
        //
        CFactura facturas[] = {
            null, 
            new CFactura(id, "ALKOSTO", precioTotal)
        };
        
        //->Test: si es null, la primera factura [0]
        if (facturas[1] == null) {
            throw new CFacturaValidador().esFacturaNula();
        }
        return facturas[1];
    }


    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    /**
     * 
       CFactura factura = new CFactura(id, "ALKOSTO", precioTotal);  
        System.out.println("Factura   :" + factura);
        System.out.println("A pagar   :" + factura.precioTotal());
     * 
     * @return 
     */
    
    public CFactura generarFactura_test1() {
        Random rnd = new Random();
        String id          = "F-2023-" + rnd.nextInt();
        double precioTotal = rnd.nextDouble();
        return new CFactura(id, "ALKOSTO", precioTotal);
    }
    public  CFactura getFactura_test1(DiaSemana dia) {
        if (dia == DiaSemana.SABADO || dia == DiaSemana.DOMINGO) {
            return null;
        }
        return generarFactura();
    }
    //--------------------------------------------------------------------------
    public CFactura validarFactura_test1(String id, double precioTotal)  {
        precioTotal = 0; //->lo hago dañar de aposta
        if (precioTotal == 0) {
            //->1.FUNCIONA OK
//          throw this.validarGeneracionFacturaPordia(precioTotal);
            //->2.FUNCIONA OK
//            throw new CFacturaExeption(CFacturaEnum.FACTURA_CERO.getMensaje());

            //------------------------------------------------------------------
            //------------------------------------------------------------------
            //->¿NO ME FUNCIONA AAAAAAAAAAA?
//            CFacturaExeption exepcion = new CFacturaExeption(CFacturaEnum.FACTURA_CERO.getMensaje());
            ////exepcion.validarGeneracionFacturaPordia(precioTotal);   //->ERROR:  ¿entonces como?
//            throw  exepcion;
        }
        return new CFactura(id, "ALKOSTO", precioTotal);
    }
    public CFacturaExeption validarGeneracionFacturaPordia(double precioTotal)  throws CFacturaExeption {
        throw new CFacturaExeption(CFacturaEnum.FACTURA_CERO.getMensaje());
//        if (factura == null) {
//          throw new CFacturaExeption("Factura invalida :(");
//        }
    }

}
