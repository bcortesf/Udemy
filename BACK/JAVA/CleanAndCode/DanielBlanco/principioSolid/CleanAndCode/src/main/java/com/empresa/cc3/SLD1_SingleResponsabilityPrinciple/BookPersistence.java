/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc3.SLD1_SingleResponsabilityPrinciple;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brycorfe
 */
public class BookPersistence implements  IBookPersistence{
    
    @Override
    public void SaveFile(Book book) {
        String bookFilePath = 
                Book.BOOK_DIRECTOY_PATH + "/" + book.getTitle() + "/" + new Date().getTime();
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(bookFilePath));
            List<Page> pages = book.getPages();
            for (Page page : pages) {
                writer.write("---- Page " + page.getNumber() + " ----");
                writer.newLine();
                writer.write(page.getContent());
                writer.newLine();
            }
            writer.close();
        } catch (IOException ex) {
            throw new BookPersistenceExeption(ex.getMessage());
        }
    }

    @Override
    public void SaveWeb(Book book) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
