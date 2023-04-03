/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc3.SLD1_SingleResponsabilityPrinciple;

/**
 *
 * @author brycorfe
 */
public class BookPersistenceExeption extends RuntimeException{
    public BookPersistenceExeption(String msj) {
        super(msj);
    }
}
