/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk7.b1_GenericosIII_Wildcards;

import com.mycompany.entitysRecords.Alumno;
import com.mycompany.entitysRecords.Profesor;
import com.mycompany.entitys.extendss.Animal;
import com.mycompany.entitys.extendss.AnimalDomestico;
import com.mycompany.entitys.extendss.Gato;
import com.mycompany.entitys.extendss.Perro;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=m1jSDDpCABc&list=PLvimn1Ins-43qPXR3gBcxwe7tydxZtsON&index=8
 * @author BryanCFz
 */
public class Test {

    private static List<Gato> getPerrosEXEPTION() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void listar(List<Alumno> lista) {
        for (Alumno alumno : lista) {
            System.out.println(alumno.nombre());
        }
    }
    
    /**
     * ?    : es de tipo UNKNOW ó DESCONOCIDO   ===  Object
     * @param lista 
     */
    public void listar_wildcardComidin(List<?> lista) {
        System.out.println("USO DE WILDCARD");
        for (Object objAlumno : lista) {
            //->ERROR: Al mandar una lista<Profesor>
//            System.out.println( ((Alumno)objAlumno).nombre() );
           
            //->OK
            if (objAlumno instanceof Alumno alumno) {
                System.out.println(alumno.nombre() );
            } else {
                System.err.println("ERROR: Pertenezco a la clase <" + objAlumno.getClass().getName() + ">");
            }
        }
    }
    
    /**
     * UNBOUNDED
     * - Significa que HEREDA de una clase papa SUPERIOR
     * - "extends" hace referencia a:
     *      + herencia
     *      + implementaciones
     * 
     * (List<?> lista)    <--ES-IGUAL-A-->    (List<? extends Object> lista)
     * @param lista 
     */
    public void listar_wildcardComidin_UNBOUNDED(List<? extends Object> lista) {
        //En nuestro caso  --------------->    <Alumno> HEREDA DE <Object>
        System.out.println("USO DE WILDCARD");
        for (Object objAlumno : lista) {
            if (objAlumno instanceof Alumno alumno) {
                System.out.println(alumno.nombre() );
            } else {
                System.err.println("ERROR: Pertenezco a la clase <" + objAlumno.getClass().getName() + ">");
            }
        }
    }

    public void listar_wildcardComidin_TIPADO_UNBOUNDED(List<? extends Animal> lista) {
        //En nuestro caso  --------------->    <Gato> HEREDA DE <Animal>
        System.out.println("USO DE WILDCARD");
        for (Animal animal : lista) {
            System.out.println(animal.getTipo() );
        }
    }
    
    //==========================================================================
    //==========================================================================
    /**
     * https://www.youtube.com/watch?v=m1jSDDpCABc&list=PLvimn1Ins-43qPXR3gBcxwe7tydxZtsON&t=524s
     * LOWERBOUNDED  mod ytodo la doc
     * - Significa reconoce aquellas clases que sea INFERIORES
     * - Despues del operador "SUPER" tendremos una <CLASE-BASE>:
     *      + solo reconoce aquellas clases que sean (MAYORES o SUPERCLASES) a la <CLASE-BASE> que indiquemos despues del SUPER
     *        (List<? super <CLASE-BASE>> lista)
     * 
     * (List<? super Perro> lista)
     * * (List<Animal super Perro> lista)             :<Animal>          es una SUPERCLASE de <Perro>
     * * (List<AnimalDomestico super Perro> lista)    :<AnimalDomestico> es una SUPERCLASE de <Perro>
     * 
     * <CLASE-BASE> :Animal
     * ?            : Reconoce todas las SUPERCLASES que tengan <Perro> como HIJO
     * @param lista 
     */
    public void listar_wildcardComidin_TIPADO_LOWERBOUNDED(List<? super Perro> lista) {
        System.out.println("USO DE WILDCARD");
        for (Object object : lista) {
            //Animal animal = (Animal) object;
            Perro animal = (Perro) object;
            System.out.println(animal.getTipo() );
        }
    }
    //==========================================================================
    //==========================================================================

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk7.GenericosIII_Wildcards".toUpperCase());
        System.out.println("*****************************************".concat("\n"));
        
        //SIN HERENCIA
        List<Alumno>   listaAlum = getAlumnos();
        List<Profesor> listaProf = getProfesores();
        //CON HERENCIA
        List<Gato>     listaCats = getGatos();
        List<Animal>   listaAnimals = getAnimales();
        List<Perro>     listaDogs = getPerros();

        Test t = new Test();
//        t.listar(listaA);

        System.out.println("------------------+\n");
        System.out.println("\t\t\t***UNBOUNDED  Ó  UPPERBOUNDED***");
        System.out.println("\t->SON METODOS IGUALES, PORQUE HERENDAN Y SON JUNTOS UNBOUNDED, LEER DOC DE LOS METODOS MIOS");
        t.listar_wildcardComidin(listaAlum);
        t.listar_wildcardComidin_UNBOUNDED(listaAlum);
        System.out.println("------------------+\n");
//        t.listar_wildcardComidin(listaProf); //ERROR
//        System.out.println("------------------+\n");
        System.out.println("\t\t\t***ARRIBA  Ó  UNBOUNDED  Ó  UPPERBOUNDED***");
        t.listar_wildcardComidin_TIPADO_UNBOUNDED(listaCats);
        t.listar_wildcardComidin_TIPADO_UNBOUNDED(listaAnimals);


        System.out.println("------------------+\n");System.out.println("------------------+\n");
        System.out.println("\t\t\t***ABAJO  Ó  LOWERBOUNDED***");
        t.listar_wildcardComidin_TIPADO_LOWERBOUNDED(listaDogs);
        
        t.listar_wildcardComidin_TIPADO_LOWERBOUNDED(listaAnimals); //->Todos deben ser <Perro>, si es otra clase lanza error
        
    }
    
    public static List<Alumno> getAlumnos() {
        //OK
        Alumno alumno1 = new Alumno("Motas");
        Alumno alumno2 = new Alumno("Shushi");
        Alumno alumno3 = new Alumno("Minnie");
        List<Alumno> listaA = Arrays.asList(alumno1,alumno2,alumno3);
        return listaA;
    }
    public static List<Profesor> getProfesores() {
        //ERROR
        Profesor profe1 = new Profesor("Mamita");
        Profesor profe2 = new Profesor("Nanita");
        List<Profesor> listaP = Arrays.asList(profe1, profe2);
        return listaP;
    }
    
    public static List<Gato> getGatos() {
        Gato gato1 = new Gato("Shushi", "felino");
        List<Gato> listaG = Arrays.asList(gato1);
        return listaG;
    }
    public static List<Animal> getAnimales() {
        //->ERROR :por intento de casteo de <Gato> a CLASE-BASE<Perro>
        /*Perro perro1 = new Perro("Motas", "canino");
        Gato  gato1  = new Gato("Shushi", "felino");*/
        
        //OK
        Animal perro1 = new Perro("Motas", "canino");
        Animal perro2 = new Perro("Minnie", "canino-2");
        List<Animal> listaA = Arrays.asList(perro1,perro2);
        return listaA;
    }
    public static List<Perro> getPerros() {
        Perro perro1 = new Perro("Motas", "canino-1");
        Perro perro2 = new Perro("Minnie", "canino-2");
        List<Perro> listaP = Arrays.asList(perro1,perro2);
        return listaP;
    }
}
