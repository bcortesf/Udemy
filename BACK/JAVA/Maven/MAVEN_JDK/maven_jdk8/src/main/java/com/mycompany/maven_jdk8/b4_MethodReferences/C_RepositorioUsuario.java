package com.mycompany.maven_jdk8.b4_MethodReferences;

class C_RepositorioUsuario {

    C_RepositorioUsuario(){}

    public void displayName(C_Usuario usuario) {
        System.out.println("+ " + usuario.getNombre());
    }
}