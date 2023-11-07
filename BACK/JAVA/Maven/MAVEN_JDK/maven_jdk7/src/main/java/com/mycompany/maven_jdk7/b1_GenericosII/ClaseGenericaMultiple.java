/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maven_jdk7.b1_GenericosII;

import com.mycompany.entitysRecords.Persona;
import java.util.Arrays;
import java.util.List;


/**
 * 
 * @author BryanCFz
 * @param <T>   :Recibir cualquier clase, pero sera (convertida) de tipo "Object"
 */
public class ClaseGenericaMultiple <K,T,V,E> {

    private final K objetoK;
    private final T objetoT;
    private final V objetoV;
    private final E objetoE;

    public ClaseGenericaMultiple(K objetoK, T objetoT, V objetoV, E objetoE) {
        this.objetoK = objetoK; //Integer id
        this.objetoT = objetoT; //Double  valorPatrimonio
        this.objetoV = objetoV; //Persona persona1
        this.objetoE = objetoE; //Persona persona2
    }

    public K getObjetoK() {
        return objetoK;
    }

    public T getObjetoT() {
        return objetoT;
    }

    public V getObjetoV() {
        return objetoV;
    }

    public E getObjetoE() {
        return objetoE;
    }

    public void MostrarTipoDeObjetoImplementado() {
        System.out.println( "El objeto 'K' es de tipo \t:" + this.objetoK.getClass().getName() );
        System.out.println( "El objeto 'T' es de tipo \t:" + this.objetoT.getClass().getName() );
        System.out.println( "El objeto 'V' es de tipo \t:" + this.objetoV.getClass().getName() );
        System.out.println( "El objeto 'E' es de tipo \t:" + this.objetoE.getClass().getName() );
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    public boolean esObjetoPersona() {
        return this.objetoV instanceof Persona;
    }
    public List<Persona> getPersonas() {
        List<Persona> lista = Arrays.asList( (Persona)this.objetoV, (Persona)this.objetoE );
        return lista;
    }
}
