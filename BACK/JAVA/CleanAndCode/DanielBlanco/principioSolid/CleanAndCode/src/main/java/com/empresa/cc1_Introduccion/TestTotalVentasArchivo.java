/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc1_Introduccion;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author brycorfe
 */
public class TestTotalVentasArchivo {
    
    //Ruta del archivo:  "Ventas_del_mes"
    final static String MONTHLY_SALES_FILE_PATH = "src\\main\\java\\recursos\\ventasMes.txt.txt";

    public static void main(String args []) throws IOException {      
        System.out.println("la sumatoria de ventas del mes: " + getMonthlySales());
    }
    
    //ObtenerLasVentasDelMes
    static Integer getMonthlySales() throws IOException {
        List<String> listaVentasMes = readNumbersFromFile(MONTHLY_SALES_FILE_PATH);
        return getCalculateSummatory(listaVentasMes);
    }
    //leerNumerosDelArchivo
    static List<String> readNumbersFromFile( String pathFile) throws IOException {
        return Files.readAllLines( Paths.get(pathFile) , StandardCharsets.UTF_8);
    }
    //obtenerCalculoSumatoria
    static Integer getCalculateSummatory( List<String> listaVentasMes) {
        int sumatoria = 0;
        for (String filaNumero : listaVentasMes) {
            sumatoria += Integer.valueOf(filaNumero);
        }
        return sumatoria;
    }

}
