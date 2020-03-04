/******************************************************************/ 
/* INFORMACION */



/* Programa: Cruz Roja */ 


/* Autor:  Todo el equipo de desarrollo */ 

/* Descripción: Este servicio es el encargado de todo lo relacionado con una consulta, 
 * 				como los servicios que se proporcionan en la empresa, como manejar las citas 
 * 				que agendan de los pacientes. 
 * 				El servicio se comunica con el DAO para recuperar información de los servicios, para
 *				verificar la existencia de tal servicio, recuperar información de las citas de algún paciente.
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
import datos.DAOCruzRoja;
import negocio.dominio.Consulta;
import negocio.dominio.Paciente;

public class ServicioConsultaimp implements ServicioConsulta{
	
	private DAOCruzRoja dao;

	public ServicioConsultaimp(DAOCruzRoja dao) {
		this.dao=dao;
	}
	
	/******************************************************************/ 
	/* llama al DAO para verificar existencia de la especialidad */
	@Override
	public boolean verificaServicio(String especialidad) {
		
		if(dao.recuperaEspecialidad(especialidad)) { 
			return true;
		}
		else
			return false;
	}//fin del método verificaServicio

	/******************************************************************/ 
	
	@Override
	public boolean actulizaDatos(String fecha, String observaciones) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/******************************************************************/ 
	/* recuperaAllCitas: recupera un ArrayList con toda la información 
	 * 	de todas las citas existentes en la Base de datos */
	@Override
	public ArrayList<Consulta> recuperaAllCitas() {
		return dao.recuperaAllCitas();
	} //fin de método recuperaAllCitas
	
	/******************************************************************/ 
	/* recuperaCita: recupera una sola cita (si existe) de un paciente a tráves de su ID */
	@Override
	public Consulta recuperaCita(String idPaciente) {
		return dao.recuperaCita(idPaciente);
	}//fin de método recuperaCita
	
	/******************************************************************/ 
	/*recuperaPaciente: regresa un objeto de tipo Paciente respecto al idPaciente pasado como parámetro*/
	@Override
	public Paciente recuperaPaciente(String idPaciente) {
		return dao.recuperaPaciente(idPaciente);
	}//fin de método recuperaPaciente.

	/******************************************************************/
	/*Regresa un ArrayList de tipo consulta con todos los servicios disponibles en la Organización Cruz Roja
	 * Además de los servicios, se regresa la información de estos, como el costo, el id y el tipo de servicio*/
	public ArrayList<Consulta> recuperaAllServicios(){
		return dao.recuperaAllServicios();
	}//fin de método recuperaAllServicios

}//fin de la clase ServicioConsultaimp

