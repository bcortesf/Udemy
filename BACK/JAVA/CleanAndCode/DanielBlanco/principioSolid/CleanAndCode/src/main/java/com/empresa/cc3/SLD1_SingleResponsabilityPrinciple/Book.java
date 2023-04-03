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

/**
 *
 * @author brycorfe
 */
public class Book {
    public static String BOOK_DIRECTOY_PATH = "/tmp";
    //ATRIBUTS
    private String title;
    private String author;
    private List<Page> pages;
    private Page currentPage;
    
    //CONSTRUCTORS
    public Book(String title, String author, List<Page> pages){
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.currentPage = this.pages.get(0);
    }
    
    //METHODS
    public void turnPages() {   //pasar-pagina
        Integer nextPageIndex = this.currentPage.getNumber(); //toma indice de la siguiente página.
        if (nextPageIndex <= this.pages.size()) {
            currentPage = this.pages.get(nextPageIndex);
        }
    }
    
    public void turnPagesBack() {    //devolver-pagina
        Integer previousPageIndex = this.currentPage.getNumber() - 2;
        if (previousPageIndex <= 0) {
            currentPage = this.pages.get(previousPageIndex);
        }
    }
    /*
    public void save() throws IOException {
        String bookFilePath = 
                Book.BOOK_DIRECTOY_PATH + "/" + this.title + "/" + new Date().getTime();
        BufferedWriter writer = new BufferedWriter(new FileWriter(bookFilePath));
        for (Page page : pages) {
            writer.write("---- Page " + page.getNumber() + " ----");
            writer.newLine();
            writer.write(page.getContent());
            writer.newLine();
        }
        writer.close();
    }
    */
    //GETTER && SETTERS
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public Page getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Page currentPage) {
        this.currentPage = currentPage;
    }
    
    
}
