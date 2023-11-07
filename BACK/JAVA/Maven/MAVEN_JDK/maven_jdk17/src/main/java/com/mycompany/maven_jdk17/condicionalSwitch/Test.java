/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk17.condicionalSwitch;

import com.mycompany.enums.DayEnum;
import static com.mycompany.enums.DayEnum.TUESDAY;
import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 *
 * @author BryanCFz
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk17.condicionalSwitch".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        // 
        Test ts= new Test();
        ts.StringOldSwitch("B");
        ts.StringNewSwitch_void("C");
        ts.StringNewSwitch_return("C");
        
        ts.DayEnumSwitch_customByMe_void();
        ts.DayEnumSwitch_enumJDK8_return();
    }
    public void StringOldSwitch(String option) {
        System.out.println("\n1. ->StringOldSwitch()");
        switch(option) {
            case null:  System.out.println("NO EXISTE");
                break;
            case "A":  System.out.println("MONDAY");
                break;
            case "B":  System.out.println("TUESDAY");
                break;
            default :  System.out.println("SUNDAY");
        }
    }

    public void StringNewSwitch_void(String option) {
        System.out.println("\n1. ->StringNewSwitch_void()");
        switch(option) {
            case null -> System.out.println("NO EXISTE");
            case "A" -> System.out.println("MONDAY");
            case "B" -> System.out.println("TUESDAY");
            case "C" -> System.out.println("WEDNESDAY");
            case "D" -> System.out.println("THURSDAY");
            case "E" -> System.out.println("FRIDAY");
            case "F" -> System.out.println("SATURDAY");
            default -> System.out.println("SUNDAY");
        }
    }
    public void StringNewSwitch_return(String option) {
        System.out.println("\n1. ->StringNewSwitch_return()");
        String dayOfWeek = switch(option) {
            case null-> "NO EXISTE";
            case "A" -> "MONDAY";
            case "B" -> "TUESDAY";
            case "C" -> "WEDNESDAY";
            case "D" -> "THURSDAY";
            case "E" -> "FRIDAY";
            case "F" -> "SATURDAY";
            default -> "SUNDAY";
        };
        System.out.println("=:" + dayOfWeek);
    }

    /**
     * Enum personalizado
     */
    public void DayEnumSwitch_customByMe_void() {
        System.out.println("\n1. ->DayEnumSwitch_customByMe_void()");
        DayEnum dayOfWeek = DayEnum.TUESDAY; //enum: creada por mi
        switch(dayOfWeek) {
            case TUESDAY -> System.out.println(DayEnum.FRIDAY);
            default -> System.out.println(DayEnum.SUNDAY);
        };
    }
    
    public void DayEnumSwitch_enumJDK8_return() {
        System.out.println("\n1. ->DayEnumSwitch_enumJDK8_return()");
        DayOfWeek dayOfWeek = DayOfWeek.MONDAY; //enum: propia de JDK8
        
        DayOfWeek dayOfWeekNew = switch(dayOfWeek) {
            case MONDAY -> DayOfWeek.SATURDAY;
            default -> DayOfWeek.SUNDAY;
        };
        System.out.println("=:" + dayOfWeekNew);
    }
}
