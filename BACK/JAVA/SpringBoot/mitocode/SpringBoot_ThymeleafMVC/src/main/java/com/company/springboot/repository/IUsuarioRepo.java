package com.company.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.springboot.entityModel.Usuario;


/**											 	JpaRepository<T, ID>
 * 												JpaRepository<Usuario, Usuario[id]>  
 */
public interface IUsuarioRepo extends JpaRepository<Usuario, Integer> {
	/*
	 *Usuario findByNombre(String nombre)     :Es como si yo hiciera una sentencia SQL
	 *                                                                   SELECT * FROM Usuario WHERE nombre=<"ALGO"> 
	 */
	Usuario findByNombre(String nombre);
}
	