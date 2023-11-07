/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.example3.JDK8_optional;

import com.mycompany.example.common.CFactura;
import com.mycompany.example.common.exeption.CFacturaExeption;
import java.util.Optional;

/**
 *
 * @author BryanCFz
 */
public class Test_Optional {

    public static void main(String[] args) {
//        pruebaDiaSemana();

        System.out.println("JAVA 8: <OPTIONAL>".concat("\n"));
        ProvedorFacturaOPCIONAL provedorOPCIONAL = new ProvedorFacturaOPCIONAL();
        
        try {
            //->Generar factura entre semana (LUNES, ...VIERNES); En caso contrario lanzar exepcion fines de semana (SABADO, DOMINGO)
//            Optional<CFactura> opcionalFAC = provedorOPCIONAL.getFactura(DiaSemana.LUNES);
            Optional<CFactura> opcionalFAC = provedorOPCIONAL.getFactura(DiaSemana.DOMINGO);

            // https://www.youtube.com/watch?v=tHsPyC23oww&list=RDCMUCQufRmIMRTLdRxTsXCh4-5w&t=396s
            if ( opcionalFAC.isEmpty() ) {
                System.out.println("DENTRO DE LA CAJA NO HAY NADA");
                System.out.println("EMPTY: Cuando dentro del OPCIONAL; no hay nada; Si el valor no esta presente o esta vacio o null");
                CFactura factura = opcionalFAC
                        .orElse( new CFactura("0000", "Sin Nombre", Double.NaN) );
                System.out.println("factura   :" +  factura.toString() );
            }
            if (opcionalFAC.isPresent()) {
                System.out.println("DENTRO DE LA CAJA HAY COSAS");
                System.out.println("PRESENT: Cuando tenga un OPCIONAL; con algo adentro; si el valor esta lleno".concat("\n"));
                
                System.out.println("Factura   :" + opcionalFAC.get() );
                System.out.println("Factura   :" + opcionalFAC.orElseThrow() );
                opcionalFAC.ifPresent((CFactura factura) -> {
                    System.out.println("factura   :" +  factura.toString() );
                });
                
                System.out.println("A pagar   :" + Utilitys.ConvertirDoubleToPesosColombianos( opcionalFAC.get().precioTotal() ));
            }
        } catch (CFacturaExeption e) {
            System.out.println("Error<CFacturaExeption>    :" + e.getMensajee());
            System.out.println("Error<Throwable>           :" + e.getMessage());
        }
        System.out.println("..");
    }

}
