/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.example2.Generic;

import java.util.List;

/**
 *
 * @author BryanCFz
 */
public class Report {

    /**
     * ?: acepta cualquier clase
     * @param datos : la clase se convierte de tipo <Object>, que es la clase padre de todas las clases
     */
    public void imprimir(List<?> datos) {
        System.out.println("Imprimiendo datos");
        for (Object dato : datos) {
            System.out.println(dato); //toma por defecto el .toString()
        }
    }

}
