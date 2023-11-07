/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk8.b12_FuncionesAltoOrden;

import com.mycompany.Repository.Repository;
import com.mycompany.entitysRecords.Nota;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * https://www.youtube.com/watch?v=hYEizawDADU&list=PLvimn1Ins-419yVe5iPfiXrg4mZJl5kLS&index=15
 * https://www.youtube.com/watch?v=hYEizawDADU&list=PLvimn1Ins-419yVe5iPfiXrg4mZJl5kLS&t=370s
 * @author BryanCFz
 */
public class Test {
    
    /**
     * Se crean las funciones que van a pasarse entre metodos
     * Function<parametroENTRADA, valorSALIDA>
     * Function<String          , String>
     */
    private final Function<String, String> funcConvertirMayusculas = (String s) -> s.toUpperCase().concat(" :MAYUSCULAS");
    private final Function<String, String> funcCconvertirMinusculas = (String s) -> s.toLowerCase().concat(" :minusculas");
    
    private void show(Function<String, String> miFuncion, String valorParaTransformar) {
                                              /**<parametroENTRADA> */
        System.out.println( miFuncion.apply(valorParaTransformar) );
    }

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk8.b12_FuncionesAltoOrden".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        //
        Test tst = new Test();
        System.out.println("->funcFormatearTexto();");
        String texto = "TeXtO fOrMaTeAdO En";
        tst.show(tst.funcConvertirMayusculas, texto);
        tst.show(tst.funcCconvertirMinusculas, texto);
        
        //
        System.out.println("\n" + "->funcMostrarMensaje()");
        Function<String, String> funcion = tst.funcMostrarMensaje("mensaje-de-");
        String salidaFunc1 = funcion.apply("->ENTRADA-1"); /**<parametroENTRADA> */
        System.out.println(salidaFunc1);
                                                                            /**<parametroENTRADA> */
        String salidaFunc2 = tst.funcMostrarMensaje("mensaje-de-").apply("->ENTRADA-2");
        System.out.println(salidaFunc2);
        
        //
        Repository repo = new Repository();
        

        System.out.println("\n" + "->filtrar(), por longitud-tamaño");
        tst.filtrar(
                repo.getNotas(), System.out::println, 8
        );
        
        System.out.println("\n" + "->filtrar(), por cadena-contenida");
        tst.filtrar(
                repo.getNotas(), (Nota n) -> System.out.println(n), "ing"
        );
        
    }
    
    ////////////////////////////////////////////////////////////////////////////
    private Function<String, String> funcMostrarMensaje(String mensaje) {
        /**           <parametroENTRADA  -> (       <valorSALIDA>      )*/
        return (String parametroENTRADA) -> (mensaje + parametroENTRADA);
    }
    ////////////////////////////////////////////////////////////////////////////
    private void filtrar(List<Nota> notas, Consumer<Nota> consumidor, int longitud) {
        notas.stream()
                .filter( this.establecerLogicaFiltro(longitud) )
                .forEach(consumidor);
    }
    private void filtrar(List<Nota> notas, Consumer<Nota> consumidor, String cadenaContenida) {
        notas.stream()
                .filter( this.establecerLogicaFiltro(cadenaContenida) )
                .forEach(consumidor);
    }
    
    private Predicate<Nota> establecerLogicaFiltro(int longitud) {
        return (Nota nota) -> nota.asignatura().length() < longitud;
    }
    private Predicate<Nota> establecerLogicaFiltro(String cadenaContenida) {
        return (Nota nota) -> nota.asignatura().contains(cadenaContenida);
    }
}
