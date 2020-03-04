/******************************************************************/ 

/* Programa: Cruz Roja */ 


/* Autor: Contreras Vazquez Carlos */ 
/* Descripción: Este control es el que se encarga de comunicarse con la ventanaMuestraServicios
 * 				y con el servicioConsulta. Es decir, se encarga de controlar los llamados de los
 * 				métodos que la ventana ocupa y comunicarse al servicio para realizarlos. 
 */ 

/******************************************************************/

/* Contenido del Listado:
 * 		- public ControlMuestraServicios( ServicioConsulta servicioConsulta)
 * 		- public void inicia()
 * 		- public ArrayList<Consulta> recuperaAllServicios
 */

/******************************************************************/

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
	 * Se comunica con el servicioConsulta para recuperar 
	 * un ArrayList de todos los servicios que esten registrados en la base de datos
	 */
	public ArrayList<Consulta> recuperaAllServicios() {
		return servicioConsulta.recuperaAllServicios();
	}
	
}
