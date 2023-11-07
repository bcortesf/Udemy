package com.mycompany.maven_jdk8.b4_MethodReferences;


@FunctionalInterface
interface C_ICrudUsuarioBD {
    //https://www.youtube.com/watch?v=mSd2qnWlIQQ&t=453s
    /**
     * Este metodo<CrearUsuario> va a recibir como {parametros};...
     *      - LOS MISMOS {PARAMETROS} QUE POSEA EL CONSTRUCTOR() DE LA CLASE LA CUAL QUERAMOS CREAR
     * @param nombre
     * @return
     */
    public C_Usuario CrearUsuario(String nombre);
    /**
            class C_Usuario {
                        C_Usuario(String nombre) {
                            this.nombre = nombre;
                        }
            }
     */
}