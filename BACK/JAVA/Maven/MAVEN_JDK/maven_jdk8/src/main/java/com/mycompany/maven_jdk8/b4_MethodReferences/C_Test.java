/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk8.b4_MethodReferences;

import java.util.Arrays;
import java.util.List;


/**
 * //throw new UnsupportedOperationException("Not supported yet.");
 * @author BryanCFz
 */
public class C_Test {

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk8.b4_MethodReferences.C_Test".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        /**
         *
         */
        C_Test ins = new C_Test();
        List<C_Usuario> usuarios = Arrays.asList(
                new C_Usuario("Coder 1"),
                new C_Usuario("Coder 2"));

        //->mostrarUsuarios         :lambda
        usuarios.forEach((C_Usuario usuario) -> System.out.println(usuario.getNombre()) );

        System.out.println("---------------------------------------------------------");
        System.out.println("    **metodo-por-referencia tradicional");
        usuarios.forEach(System.out::println);

        System.out.println("---------------------------------------------------------");
        System.out.println("    **metodo-por-referencia static");
        usuarios.forEach(C_Test::displayNameSTATIC); //CLASE::metodoSTATIC

        System.out.println("---------------------------------------------------------");
        System.out.println("    **Referencia a un Método de clase; de un objeto");
        C_RepositorioUsuario repositorioUsuario = new C_RepositorioUsuario();
        usuarios.forEach((C_Usuario u) -> repositorioUsuario.displayName(u)); //lambda
        usuarios.forEach(repositorioUsuario::displayName);                    //metodo-referencia

        System.out.println("---------------------------------------------------------");
        System.out.println("    **Referencia a un Método instancia; de un objeto arbitrario");
        usuarios.forEach((C_Usuario u) -> u.showNombre());
        usuarios.forEach(C_Usuario::showNombre);

        System.out.println("---------------------------------------------------------");
        System.out.println("    **Referencia a un Método constructor");
        C_ICrudUsuarioBD interfaz1 = (String nombre) -> new C_Usuario(nombre);
        System.out.println( interfaz1.CrearUsuario("Bryan") );
        System.out.println();

        C_ICrudUsuarioBD interfaz2 = C_Usuario::new;
        System.out.println( interfaz2.CrearUsuario("Nanita") );

        C_ICrudUsuarioBD interfaz3 = C_Usuario::new;
        C_Usuario user1 = interfaz3.CrearUsuario("Usuario #1");
        C_Usuario user2 = interfaz3.CrearUsuario("Usuario #2");
        C_Usuario user3 = interfaz3.CrearUsuario("Usuario #3");
        System.out.println(user1.getNombre());


        System.out.println("+-+-+-+-+-+");
//         usuarios.forEach((C_Usuario u) -> u.showNombre());
//         usuarios.forEach(C_Usuario::showNombre);

    }

    ///////////////////////////////////////////
    public static void displayNameSTATIC(C_Usuario usuario) {
        System.out.println("- " + usuario.getNombre());
    }

}
