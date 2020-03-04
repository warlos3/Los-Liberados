/*
 * Programa :Es el Control de Busqueda de horarios de los empledos "HU-05"
 * Autor : Ramirez Cordero Joselyn
 * Fecha: 02/03/ 2020
 * Descripción: Es la conexion entre el controlBusquedaHorarios y el servicioBusquedaHorarios, para moder manejar 
 *              los datos correspondientes.
 *              
 */

/* Contenido de listado
 * 
 * Metodos y clases 
 * Clase de Control Busqueda Horarios
 * Control Busqueda Horarios(ServicioEmpleado servicioempleado)
 * public void inicia() //  Inicia el la historia de usuario
 * public ArrayList<Doctor> recuperaAllEmpleadosDoc() // Este módulo recupera una lista de lo empleados
 * 														que estan en la base
 * public ArrayList<Recepcionista> recuperaAllEmpleadosRec() // Este modulo recupera una lista de 
 * 																todos recpcionista 
 * 
 */

package presentacion;

import java.util.ArrayList;

import negocio.dominio.Doctor;
import negocio.dominio.Recepcionista;
import negocio1.ServicioEmpleado;

public class ControlBuquedaHorarios {
	
	//servicio empleado de la capa de negocio
	private ServicioEmpleado servicioempleado;
	 
	 //Ventana de elimina empleado
	 private VentanaBusquedaHorarios ventana;
		
	 /*
	  * Constructor de Control Busqueda  Horarios
	  */
	
	 public ControlBuquedaHorarios( ServicioEmpleado servicioempleado) {
		 this.servicioempleado=servicioempleado;
			}
	
	/*
	  * Inicia el evento de la Busqueda de los horarios de los empleados
	  */
	 public void inicia() { 
		 	ventana=new VentanaBusquedaHorarios(this);
			ventana.abre();
		}
		
	 /*
	 * Recupera un ArrayList (lista) de los doctores que esten registrados en la base de datos
	 */
	 
	 public ArrayList<Doctor> recuperaAllEmpleadosDoc() {
		 	return servicioempleado.recuperaAllempleadosDoc();
		}
		
	 /*
	  * Recupera un ArrayList(lista) de Recepcionistas que esten registrados en la base de datos
	  */
		
	 public ArrayList<Recepcionista> recuperaAllEmpleadosRec() {
		 	return servicioempleado.recuperaAllempleadosRec();
		}
		
		

}
