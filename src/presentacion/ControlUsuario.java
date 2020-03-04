package presentacion;

import negocio1.ServicioUsuario;

public class ControlUsuario {

	private ServicioUsuario servicioUsuario;
	
	public ControlUsuario(ServicioUsuario servicioUsuario) {
		this.servicioUsuario=servicioUsuario;
	}

	public String verificaUsuario(String nombre, String contra) {
		return servicioUsuario.verificaUsuario(nombre, contra);
	}
	
	public boolean cambiaContra(String idUsuario, String contra) {
		return servicioUsuario.cambiarContra(idUsuario, contra);
	}
}