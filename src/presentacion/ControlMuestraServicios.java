package presentacion;
import java.util.ArrayList;

import negocio.dominio.Consulta;
import negocio1.ServicioConsulta;

public class ControlMuestraServicios {

	private ServicioConsulta servicioConsulta;
	private VentanaMuestraServicios ventana;
	
	/* Constructor de Control Busqueda  Horarios */
	public ControlMuestraServicios( ServicioConsulta servicioConsulta) {
		this.servicioConsulta=servicioConsulta;
		
	}
	/* Inicia el evento de la HU */
	public void inicia() { 
		ventana=new VentanaMuestraServicios(this);
		ventana.abre();
	}
	
	/*
	 * Recupera un ArrayList de Recepcionistas que esten registrados en la base de datos
	 */
	public ArrayList<Consulta> recuperaAllServicios() {
		return servicioConsulta.recuperaAllServicios();
	}
	
}
