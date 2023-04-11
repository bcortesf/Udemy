package com.empresabcf.sb.consola;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.empresabcf.sb.consola.models.Qualifier.Gasto;
import com.empresabcf.sb.consola.services.Qualifier.ServicioImpuestoColombia;
import com.empresabcf.sb.consola.services.Qualifier.ServicioImpuestoFrancia;

@SpringBootApplication
public class EjemplosAnotacionesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EjemplosAnotacionesApplication.class, args);
	}	
	@Override
	public void run(String... arg0) throws Exception {
		anotacion_Qualifier();
    }
	//======================================================================


	@Autowired private ServicioImpuestoFrancia servicioFr;
	@Autowired private ServicioImpuestoColombia servicioCo;
	public void anotacion_Qualifier() {
		// https://www.arquitecturajava.com/spring-qualifier-utilizando-autowired/
		List<Gasto> lstGastos = new ArrayList<Gasto>();
		lstGastos.add(new Gasto(1000));
		lstGastos.add(new Gasto(2000));
		System.out.println(servicioFr.totalGastoConIva(lstGastos));
		System.out.println(servicioCo.totalGastoConIva(lstGastos));
	}

}
