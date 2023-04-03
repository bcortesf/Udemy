/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc1_Introduccion;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author brycorfe
 */
public class LoggerRefactorizado {

    /*FIELDS*/
    /*rutaNew: C:\Users\brycorfe\OneDrive - Carvajal S.A\Documentos\NetBeansProjects\CleanAndCode\src\main\java\recursos\log.txt*/
    private static final String EMPLOYE_LOG_PATH_FILE    = "src\\main\\java\\recursos\\log.txt";
    private static final String LAST_MONTH_LOG_PATH_FILE = "src\\main\\java\\recursos\\lastMonthMax.txt";
    

    /*CONSTRUCTORS*/
    public LoggerRefactorizado() {}
    
    
    /*METHODS*/
    public void logNumberOfEmployees(int numOfEmployees) throws IOException {
        checkMonthLog();    //SI ES PRIMER DIA DE CADA MES; log mensual: insertar "lastMonthMax.txt" el numero maximo de empleados; Luego borrar "log.txt"
        updateDailyLog(numOfEmployees);   //actualizacion diaria en "log.txt"
    }
    
    private void checkMonthLog() throws IOException {
        if( isFirstDayOfMonth() ) {
           logMonthMaximumNumberOfEmployees();
        }
    }
    private void logMonthMaximumNumberOfEmployees() throws IOException {
        //Existe algun dato en el archivo "log.txt", del anterior mes
        if ( isAnyLastMonthDataAvailable() ) {
            Integer maxNumberOfEmployees = getLastMonth_maximumNumberOfEmployees();
            createFileIfNotExist( Paths.get(LAST_MONTH_LOG_PATH_FILE) );  //"lastMonthMax.txt"
            Files.write( Paths.get(LAST_MONTH_LOG_PATH_FILE), maxNumberOfEmployees.toString().getBytes(), StandardOpenOption.WRITE );
            
            /*Elimina el archivo de "log.txt"*/ 
            Files.deleteIfExists( Paths.get(EMPLOYE_LOG_PATH_FILE) );
        }
    }
    private boolean isFirstDayOfMonth() {
        //¿Es primer dia del mes actual?
        return LocalDate.now().getDayOfMonth() == 1             || LocalDate.now().getDayOfMonth() == 16;
    }
    private boolean isAnyLastMonthDataAvailable() {
        //hay algun dato disponible del ultimo mes; en el archivo "log.txt"
        File logFile = new File(EMPLOYE_LOG_PATH_FILE);
        return logFile.exists()  &&  logFile.length() > 0;
    }
    
    
    //Calcular el maximo numero de empleados del anterior mes
    private Integer getLastMonth_maximumNumberOfEmployees() throws IOException {
        List<String> data = 
                Files.readAllLines( Paths.get(EMPLOYE_LOG_PATH_FILE), StandardCharsets.UTF_8 );
        
        Integer maxNumber = 0;
        for (String valorFila : data) {
            Integer numero = Integer.valueOf(valorFila);
            if (numero > maxNumber) {
                maxNumber = numero;
            }
        }
        return maxNumber;
    }
    
    private void createFileIfNotExist(Path path) throws IOException {
        if ( !Files.exists(path) ) {
            Files.createFile(path);
        }
    }
    
    //////////////////////////////////////////////////////////////////
    private void updateDailyLog(Integer numOfEmployes) throws IOException {
        if ( isWorkingDay() ) {
            createFileIfNotExist( Paths.get(EMPLOYE_LOG_PATH_FILE) );
            
            String newNumberLog = numOfEmployes.toString() + "\n";
            Files.write( Paths.get(EMPLOYE_LOG_PATH_FILE), newNumberLog.getBytes(), StandardOpenOption.APPEND);
        }
    }
    
    private boolean isWorkingDay() {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        return  dayOfWeek != DayOfWeek.SATURDAY  && dayOfWeek != DayOfWeek.SUNDAY;
    }
    
    

    /*GETTERS && SETTERS*/
}
