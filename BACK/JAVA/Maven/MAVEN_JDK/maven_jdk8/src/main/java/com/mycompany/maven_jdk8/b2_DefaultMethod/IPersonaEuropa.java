/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.maven_jdk8.b2_DefaultMethod;

/**
 *
 * @author BryanCFz
 */
public interface IPersonaEuropa {
    
    /**
     * *METODOS POR DEFECTO:
     *      - Se debe codificar su logica desde la interface, y no seran modificados.
     *      - Puede tener <N-metodosDefault> ilimitados
     *      - No se requiere implementar los metodos() en la <CLASE> que tenga un <public class Test implements IAccionPersona>
     */
    default public void HablarEspañol() {
        System.out.println("<ESPAÑA>:  ".concat("Hola \"tio\", ¿Como vais?"));
    }
    
}


/*
    default public void HablarAsiatico() {
        System.out.println("<CHINO>:  ".concat("Oulaa \"Bryan\", ¿Kumooo zzztas?"));
    }
*/
