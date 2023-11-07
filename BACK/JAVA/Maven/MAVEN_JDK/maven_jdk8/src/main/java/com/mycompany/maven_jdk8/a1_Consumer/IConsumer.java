/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.maven_jdk8.a1_Consumer;

/**
 *
 * @author BryanCFz
 * @param <T>
 */
@FunctionalInterface
public interface IConsumer<T> {
    void accept(T t);
}
