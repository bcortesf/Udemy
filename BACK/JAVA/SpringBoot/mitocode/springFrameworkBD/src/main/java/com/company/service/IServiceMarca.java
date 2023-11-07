package com.company.service;

import com.company.entityBeans.Marca;

public interface IServiceMarca {
	/**
	 * El mismo metodo quie se creo en el DAO
	 * /springFrameworkBD/src/main/java/com/company/repositoryDao/DAOMarca.java
	 */
	public void registrar(Marca marca) throws Exception;  
}
