/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc3.SLD3_LiskovSubstitutionPrinciple;

/**
 *
 * @author brycorfe
 */
public class Dolphin extends Mammal {
    
    //METHODS
    @Override
    public void walk() {
        throw new CanNotWalkExeption("I am a dolphin, i can not Walk");
    }
}
