/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.maven_jdk8.b2_DefaultMethod;

/**
 * Leer sobre el: 
 * 
 * PARADIGMA DE PROGRAMACIÓN-->  <ORIENTADO A INTERFACES,    INYECCIÓN DE DEPENDENCIAS>
 * 
 * @author BryanCFz
 */
public interface IPersonaAmerica {
    //->Metodo tradicional
    public void Caminar();
    
    /**
     * *METODOS POR DEFECTO:
     *      - Se debe codificar su logica desde la interface, y no seran modificados.
     *      - Puede tener <N-metodosDefault> ilimitados
     *      - No se requiere implementar los metodos() en la <CLASE> que tenga un <public class Test implements IAccionPersona>
     */
    default public void HablarEspañol() {
        System.out.println("<COLOMBIA>:  ".concat("Hola \"Parce\", ¿Como estás?"));
    }
    
    default public void HablarIngles() {
        System.out.println("<EE.UU>:  ".concat("Hi \"Bro\", ¿How are you?"));
    }
}
