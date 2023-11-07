/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk8.b11_DateApi;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * https://www.youtube.com/watch?v=ExDzrB13r-M&list=PLvimn1Ins-419yVe5iPfiXrg4mZJl5kLS&index=15
 * @author BryanCFz
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk8.b11_DateApi".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        //
        Test tst = new Test();
        tst.fechas();
        tst.horas();
        tst.fechaHora();
    }
    private void fechas() {
        System.out.println("\n->fechas();");
        LocalDate fecha1 = LocalDate.now(); //->fecha-actual    :despues dse modifica
        LocalDate fecha2 = LocalDate.now(); //->fecha-actual
        
        fecha1 = LocalDate.parse("1991-01-21");
        fecha1 = LocalDate.of(1991, 01, 21);
        
        //
        System.out.println(fecha1 + "   ~~   " + fecha2);
        System.out.println(fecha1 + " >MAYOR> " + fecha2 + ":\t" + fecha1.isAfter(fecha2) );  //->año1991 esMayor añoActual  :false
        System.out.println(fecha1 + " <MENOR< " + fecha2 + ":\t" + fecha1.isBefore(fecha2) ); //->año1991 esMenor añoActual  :true

        /** *************
         * <Period.class> 
         * *************
         */
        LocalDate fechaNacimiento = LocalDate.of(2013, 01, 04);
        System.out.println(fechaNacimiento + " .DIF.YEARS. " + fecha2 + "\t:" + Period.between(fechaNacimiento, fecha2).getYears() );
        System.out.println(fechaNacimiento + " .DIF.MONTHS. " + fecha2 + "\t:" + Period.between(fechaNacimiento, fecha2).toTotalMonths() );
        
        Period period = Period.between(fechaNacimiento, fecha2);
        System.out.println("Han transcurrido " + period.getYears() + " años y " + period.getMonths() + " meses y " + period.getDays() + " dias, desde " 
                + fechaNacimiento + " hasta " + fecha2);
        
        //////////////////
        /**
         * FORMATEADOR DE FECHAS
         */
        System.out.println("\n\t - FORMATEADOR DE FECHAS");

        String fechaFront = "21/01/1991";
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        LocalDate fechaLocal = LocalDate.parse(fechaFront, formateador);
        System.out.println("SQL-generico    : " + fechaLocal);
        System.out.println("formato-personal-1: " + formateador.format(fechaLocal));
        
        //sobreescribiendo a otro tipo de lectura
        formateador = DateTimeFormatter.ofPattern("ddMMyyyy");  //sobreescribiendo el formato
        System.out.println("formato-personal-2: " + formateador.format(fechaLocal));
        
    }
    private void horas() throws InterruptedException {
        System.out.println("\n->horas();");
        
        LocalTime hora1 = LocalTime.parse("22:30:50");
        LocalTime hora2 = LocalTime.now(); //->fecha-actual
        System.out.println(hora1 + "   ~~   " + hora2);
        System.out.println(hora1 + " >MAYOR> " + hora2 + ":\t" + hora1.isAfter(hora2) );  //->año1991 esMayor añoActual  :false
        System.out.println(hora1 + " <MENOR< " + hora2 + ":\t" + hora1.isBefore(hora2) ); //->año1991 esMenor añoActual  :true
        
        //
        LocalTime horaDif3 = LocalTime.of(07, 48, 50);
        LocalTime horaDif4 = LocalTime.of(23, 9, 50);
        System.out.println(horaDif3 + " .DIF.MINUTS. " + horaDif4 + "\t:" + Duration.between(horaDif3, horaDif4).toHours() );
        
        /** *************
         * <Duration.class> 
         * *************
         */
        Instant ini = Instant.now();
        Thread.sleep(1000); //->1segundo    :throws InterruptedException 
        Instant fin = Instant.now();
        System.out.println(ini + " .DIF.SECONDS. " + fin + "\t:" + Duration.between(ini, fin).toSeconds() );
    }
        private void fechaHora() {
        System.out.println("\n->fechaHora();");
        
        LocalDateTime fechaHora1 = LocalDateTime.parse("1991-01-21T22:30:50");
        fechaHora1 = LocalDateTime.of(1991, 01, 04, 22, 03, 33, 987654321);
        
        LocalDateTime fechaHora2 = LocalDateTime.now(); //->fecha-actual
        System.out.println(fechaHora1 + "   ~~   " + fechaHora2);
    }
}
