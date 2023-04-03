/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc1_Introduccion;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author brycorfe
 */
public class Logger {

    /*FIELDS*/
    

    /*CONSTRUCTORS*/
    public Logger() {}
    
    /*METHODS*/
    public void logNumberOfEmployes(Integer _value) throws IOException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime( new Date() );
        
        Integer dayOfWeek  = calendar.get( Calendar.DAY_OF_WEEK );
        Integer dayOfMonth = calendar.get( Calendar.DAY_OF_MONTH );
        String employeLogPathFile = "";
        /*raiz: C:\Users\brycorfe\OneDrive - Carvajal S.A\Documentos\NetBeansProjects\CleanAndCode*/
            employeLogPathFile = "archivoEnRaizProyecto.txt";
        /*rutaNew: C:\Users\brycorfe\OneDrive - Carvajal S.A\Documentos\NetBeansProjects\CleanAndCode\src\main\java\recursos\log.txt*/
            employeLogPathFile = "src\\main\\java\\recursos\\log.txt";
        //System.out.println( dayOfMonth ); //dia actual
        
        //Primer dia de cada mes
        if ( dayOfMonth == 1 || dayOfMonth == 15 ) {
            if ( Files.exists(Paths.get( employeLogPathFile )) ) {
                System.out.println( "archivo encontrado" );
                List<String> data = 
                        Files.readAllLines(Paths.get( employeLogPathFile ), StandardCharsets.UTF_8);
                
                //Leer y obtener el numero maximo por documento
                Integer maxNumero = 0;
                for (String valorFila : data) {
                    Integer numero =  Integer.valueOf(valorFila);
                    if (numero > maxNumero) {
                        maxNumero = numero;
                    }
                }
                System.out.println("valor maximo: " + maxNumero);
                
                /*Crear archivo si no existe; E insertar el numero en otro archivo*/
                String lastMonthLogPathFile = "src\\main\\java\\recursos\\lastMonthMax.txt";
                if ( !Files.exists( Paths.get(lastMonthLogPathFile) ) ) {
                    Files.createFile( Paths.get(lastMonthLogPathFile) );
                }
                
                Files.write( Paths.get(lastMonthLogPathFile),  maxNumero.toString().getBytes(),  StandardOpenOption.WRITE );
                
                /*Eliminar archivo de logs*/
                //Files.deleteIfExists( Paths.get(employeLogPathFile) );
                
            } else {
                System.out.println( "ruta invalida" );
            }
        }
        
        if( dayOfWeek != Calendar.SATURDAY  &&  dayOfWeek != Calendar.SUNDAY ) {
            if ( !Files.exists(Paths.get(employeLogPathFile)) ) {
                Files.createFile( Paths.get(employeLogPathFile) );
            }
            
            String newNumberLog = _value.toString() + "\n";
            Files.write( Paths.get(employeLogPathFile) , newNumberLog.getBytes(), StandardOpenOption.APPEND);
        }
        
    }

    /*GETTERS && SETTERS*/
    

}
