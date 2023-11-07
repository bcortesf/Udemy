/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk8.a1_Consumer;

import com.mycompany.entitysClass.Factura;
import java.util.function.Consumer;

/**
 *
 * @author BryanCFz
 */
public class Test {
    
    private Consumer<Factura> consumerFac;
    
    private void AsignarfuncionalidadConsumidorFactura() {
        consumerFac = (Factura f) -> System.out.println(f);
    }
    private void llenarConsumidorFactura(){
        consumerFac.accept(new Factura(1, "ordenador",1000)); //llama la expresion lambda del metodo<AsignarfuncionalidadConsumidor()>
        consumerFac.accept(new Factura(2, "movil",300));
        consumerFac.accept(new Factura(3, "impresora",200));
        consumerFac.accept(new Factura(4, "imac",1500));
    }
    private void ConsumidorFactura(Test tst) {
        // https://www.arquitecturajava.com/java-stream/
        tst.AsignarfuncionalidadConsumidorFactura();
        tst.llenarConsumidorFactura();
    }

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk8.a1_Consumer".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        Test tst = new Test();
//        tst.ConsumidorString(tst);
        tst.ConsumidorFactura(tst);
    }
    
    private Consumer<String> consumerStr;
    
    private void ConsumidorString(Test tst) {
        // https://mkyong.com/java8/java-8-consumer-examples/
        tst.AsignarfuncionalidadConsumidorString();
        tst.llenarConsumidorString();
    }
    
    private void AsignarfuncionalidadConsumidorString() {
        consumerStr = (String t) -> System.out.println(t);
    }
    private void llenarConsumidorString(){
        consumerStr.accept("MitoCode");    //llama la expresion lambda del metodo<AsignarfuncionalidadConsumidor()>
        consumerStr.accept("Mito");
        consumerStr.accept("Code");
    }
    

}

