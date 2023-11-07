/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maven_jdk7.b1_GenericosI;


/**
 * 
 * @author BryanCFz
 * @param <T>   :Recibir cualquier clase, pero sera (convertida) de tipo "Object"
 */
public class ClaseGenerica <T> {

    private T objeto;

    public ClaseGenerica(T objeto) {
        this.objeto = objeto;
    }
    
    public void MostrarTipoDeObjetoImplementado() {
        System.out.println( "El objeto 'T' es de tipo \t:" + this.objeto.getClass().getName() );
    }

}
