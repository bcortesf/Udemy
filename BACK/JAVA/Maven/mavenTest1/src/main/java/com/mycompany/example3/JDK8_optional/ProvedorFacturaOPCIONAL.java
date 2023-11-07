/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.example3.JDK8_optional;

import com.mycompany.example.common.CFactura;
import java.util.Optional;

/**
 * // https://www.youtube.com/watch?v=tHsPyC23oww&list=RDCMUCQufRmIMRTLdRxTsXCh4-5w&t=198s
 * @author BryanCFz
 */
public class ProvedorFacturaOPCIONAL {
    
    private ProvedorFactura delegator = new ProvedorFactura();
   
    /**
     * 
       Optional.empty();             //Fabricar un objeto en una caja, opcional que ESTA VACIO
       Optional.of(T value);         //Envolver un objeto en una caja, con sus valores ya fabricados
       Optional.ofNullable(T value); //Verifica y devuelve de tipo null u objeto:
       *                                -null  : como un -> Optional.empty(); 
       *                                -objeto: como un -> Optional.of(T value);
     * @param dia
     * @return 
     */
    public  Optional<CFactura> getFactura(DiaSemana dia) {
        if (dia == DiaSemana.SABADO || dia == DiaSemana.DOMINGO) {
            //return null;
            return Optional.empty(); //retorna CFactura, sin nada adentro
        }
        return Optional.of( delegator.generarFactura() );
    }
}
