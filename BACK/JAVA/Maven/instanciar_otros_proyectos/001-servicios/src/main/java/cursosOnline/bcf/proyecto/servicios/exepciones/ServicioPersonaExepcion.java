package cursosOnline.bcf.proyecto.servicios.exepciones;

public class ServicioPersonaExepcion extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String mensaje;
	
	public ServicioPersonaExepcion(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

}
