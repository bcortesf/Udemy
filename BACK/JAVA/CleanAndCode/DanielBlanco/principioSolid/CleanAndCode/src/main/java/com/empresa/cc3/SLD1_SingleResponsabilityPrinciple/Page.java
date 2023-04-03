/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc3.SLD1_SingleResponsabilityPrinciple;

/**
 *
 * @author brycorfe
 */
public class Page {
    
    //ATRIBUTES
    private int number;
    private String content;
    
    //CONSTRUCTOR
    public Page(int number, String content) {
        this.number = number;
        this.content = content;
    }
    
    //GETTERS && SETTERS
    public void setNumber(int number) {
        this.number = number;
    }
    
    public int getNumber(){
        return number;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getContent(){
        return content;
    }
        
}
