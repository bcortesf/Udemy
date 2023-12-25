package com.company.di.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.company.di.service.IServicio;
import com.company.di.service.Servicio_InyeccionDependencia;
import com.company.di.service.Servicio_NOInyectado;

/**
 * @Qualifier:  Se usa cuando se tiene mas de 2 clases, que implementen de una misma interfaz, entonces se le dice a cual clase Concreta apuntar
 */

@Controller
public class IndexController {
	Logger LOG = LoggerFactory.getLogger(getClass());
	@Value(value = "${controller.index.index.dominio}") private String DOMINIO;
	
	/***********
	 * ATRIBUTES
	 **********/
	private Servicio_NOInyectado serviceNOInyectado = new Servicio_NOInyectado();
	
	@Autowired //CLASE
	private Servicio_InyeccionDependencia serviceDI;

	@Autowired //INTERFAZ->por"atributo"
	@Qualifier(value = "servicioDI_A") private IServicio  servicioDI_tipoA; //Servicio_TipoInyeccionDependenciaA
	
	/*					TIPOS-DE-INSTANCIA-POR-INYECCION-DEPENDENCIA				*/
	//->INTERFAZ->por"atributo"
	@Autowired
	@Qualifier(value = "servicioDI_B") 
	private IServicio  servicioDI_atributo;          //Servicio_TipoInyeccionDependenciaB
	//->INTERFAZ->por"setter"
	private IServicio  servicioDI_setter;             //Servicio_TipoInyeccionDependenciaB
	//->INTERFAZ->por"constructor"
	private IServicio  servicioDI_constructor;    //Servicio_TipoInyeccionDependenciaB
	//->@Configuracion->por"atributo"
	@Autowired
	@Qualifier(value = "servicioDI_C")
	private IServicio  servicioDI_appConfig;     //Servicio_TipoInyeccionDependenciaB

	/*************
	 * CONSTRUCTOR
	 ************/
	public IndexController(@Qualifier(value = "servicioDI_B")IServicio  servicioDI_constructor) {
		this.servicioDI_constructor = servicioDI_constructor;
	}
	/**********
	 * SETTER'S
	 *********/
	@Autowired
	public void setServicioDI_setter(@Qualifier(value = "servicioDI_B") IServicio servicioDI_setter) {
		this.servicioDI_setter = servicioDI_setter;
	}
	

	/******
	 * APIS
	 *****/
	@GetMapping(path = {"", "/", "index"})
	public String index(Model model) {
		LOG.info("MY_PATH="+DOMINIO);
		/*		NO-INYECCION-DEPENDENCIA		*/
		//model.addAttribute("NO_InyeccionDependencia", serviceNOInyectado.Operacion());
		String[] lista = serviceNOInyectado.OperacionLista();
		model.addAttribute("NO_InyeccionDependencia", lista[0]);
		model.addAttribute("paqueteClase", lista[1]);
		
		/*				INYECCION-DEPENDENCIA-POR-CLASE			*/
		String[] listaA = serviceDI.OperacionLista();
		model.addAttribute("InyeccionDependencia", listaA[0]);
		model.addAttribute("paqueteClase", listaA[1]);
		model.addAttribute("informacionSobre_InyeccionDependencia", listaA[2]);
		
		/*				INYECCION-DEPENDENCIA-POR-INTERFAZ #A		*/
		model.addAttribute("InyeccionDependenciaA_por_ATRIBUTO", this.servicioDI_tipoA.getInyeccionDependencia_porAtributo());
		/*				INYECCION-DEPENDENCIA-POR-INTERFAZ #B		*/
		model.addAttribute("InyeccionDependenciaB_por_ATRIBUTO", this.servicioDI_atributo.getInyeccionDependencia_porAtributo());
		model.addAttribute("InyeccionDependenciaB_por_METODOSET", this.servicioDI_setter.getInyeccionDependencia_porSetter());
		model.addAttribute("InyeccionDependenciaB_por_CONSTRUCTOR", this.servicioDI_constructor.getInyeccionDependencia_porConstructor());
		/*				INYECCION-DEPENDENCIA-POR-@CONFIGURACION #C		*/
		model.addAttribute("InyeccionDependenciaC_por_CONFIGURACION", this.servicioDI_appConfig.getInyeccionDependencia_porAtributo());
		
		return "index";
	}
	
	@GetMapping(path = {"/paginaNueva"})
	public String nuevaPagina(Model model) {
		return "otraPagina";
	}


	//////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * https://www.udemy.com/course/spring-framework-5/learn/lecture/8277320?start=39#notes
	 * @ModelAttribute
	 */
	@ModelAttribute(name = "MY_PATH")
	public String Dominio_heredarEnTodosLosControllers() {
		return this.DOMINIO;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////

}
