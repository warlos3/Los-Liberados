/******************************************************************/ 
/* INFORMACION */

/* Programa: Cruz Roja */ 


/* Autor:  Todo el equipo de desarrollo */ 

/* Descripci�n: Este servicio es el encargado de todo lo relacionado con una consulta, 
 * 				como los servicios que se proporcionan en la empresa, como manejar las citas 
 * 				que agendan de los pacientes. 
 * 				El servicio se comunica con el DAO para recuperar informaci�n de los servicios, para
 *				verificar la existencia de tal servicio, recuperar informaci�n de las citas de alg�n paciente.
 */ 

/******************************************************************/

/* Contenido del Listado:
 * 		- verificaServicio(String especialidad);
 * 		- ArrayList<Consulta> recuperaAllCitas();
 * 		- Consulta recuperaCita(String idCita);
 * 		- Paciente recuperaPaciente(String idCita);
 * 		- ArrayList<Consulta> recuperaAllServicios();
 */

/******************************************************************/

package negocio1;

import java.util.ArrayList;
import negocio.dominio.Consulta;
import negocio.dominio.Paciente;

public interface ServicioConsulta {

	public boolean verificaServicio(String especialidad);
	
	public boolean actulizaDatos(String fecha,String observaciones);
	
	public ArrayList<Consulta> recuperaAllCitas();
	
	public Consulta recuperaCita(String idCita);
	
	public Paciente recuperaPaciente(String idCita);
		
	public ArrayList<Consulta> recuperaAllServicios();
	
}
