/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.empresa.cc3.SLD1_SingleResponsabilityPrinciple;

import java.io.IOException;

/**
 *
 * @author brycorfe
 */
public interface IBookPersistence {
    public void SaveFile(Book book); //throws BookPersistenceExeption;  /*-->RuntimeExeption*/
    public void SaveWeb(Book book);  //throws BookPersistenceExeption;  /*-->RuntimeExeption*/
}
