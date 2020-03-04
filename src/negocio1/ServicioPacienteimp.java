/******************************************************************/ 
/* INFORMACION */



/* Programa: Cruz Roja */ 


/* Autor: Todo el equipo de desarrollo */ 

/* Descripci�n: Este servicio es el encargado de todo lo relacionado con el paciente. 
 * 				Se encarga de comunicarse con el DAOCruzRoja para obtener la informaci�n de un paciente 
 * 				a tr�ves de la Base de datos. Datos del paciente se refiere a su nombre, su ID de paciente, 
 * 				tel�fono, etc.
 * 				Por medio de los m�todos ocupados en este servicio se puede agregar n nuevo empleado, 
 * 				modificar alg�n dato del paciente, eliminarlo, incluso recuperar alguna informacion
 * 				espec�fica del paciente, as� como ver su historial m�dico, sus citas o la aceptaci�n de
 * 				alg�n pago que el paciente haya realizado.
 */ 

/******************************************************************/

/* Contenido del Listado:
 * 		- public boolean EliminaPaciente(String ID);
 * 		- public Pago verificaPago(int idPago)
 *		- public ArrayList<HistorialMedico> consultaHistorialMedico(String IDPaciente)
 *		- public Paciente obtenPaciente(int idPago)
 *		- boolean nuevo_paciente(String nombre,String apellido, String telefono, String direccion, String email, int edad,
			String fecha_nacimiento, String sexo, String curp, String idpaciente);
 * 		- public String generaidpac(String nombre, int edad, String sexo, String telefono);
 * 		- public String recuperaNombre(String idPaciente);
 * 		- public String recuperaCURP(String idPaciente);
 * 		- public boolean verificaID(String idPaciente);
 * 		- public ArrayList<Paciente> recuperaAllPaciente();
 * 		- public boolean anadeHistorialMedico(String idPaciente, String fecha, String observaciones);
 */

/******************************************************************/

package negocio1;

import java.util.ArrayList;

import negocio.dominio.Pago;
import datos.DAOCruzRoja;
import negocio.dominio.HistorialMedico;
import negocio.dominio.Paciente;

/**
 * Servicio que se conecta con Dao para recuperar informacion
 * @author 
 *
 */
public class ServicioPacienteimp implements ServicioPaciente {

	private DAOCruzRoja dao;
	
	/**
	 * Constructor
	 * @param dao
	 */
	public ServicioPacienteimp(DAOCruzRoja dao) {
		this.dao=dao;
	}

	/******************************************************************/ 
	/*EliminaPaciente: Se comunica con el DAO para eliminar el paciente respecto al ID pasado como par�metro*/
	@Override
	public boolean EliminaPaciente(String ID) {
		return dao.elimina_paciente(ID);
	}//fin de m�todo EliminaPaciente
	
	/******************************************************************/ 
	/*verificaPago: Se comunica con el DAO mediante el idPago para recuperar el pago (si este existe)*/
	@Override
	public Pago verificaPago(int idPago) {
	
		//System.out.println("Llegue al servicio " + idPago);
		Pago pago = new Pago();
		//Se conecta con el DAO para poder recuperar el objeto pago y le manda el idPago
		pago = dao.recuperaPago(idPago);
		
		return pago;
	}//fin m�todo verificaPago

	/******************************************************************/ 
	/* Se comunica con el DAO para recuperar el historial medico
	 * @param IDPaciente Recibe como parametro el Id del paciente del cual se quiere consultar el historial medico
	 * @return Devuelve un ArrayList de tipo Historial medico con toda la informaci�n medica del paciente
	 */
	public ArrayList<HistorialMedico> consultaHistorialMedico (String IDPaciente) {
		
		ArrayList<HistorialMedico> historial = new ArrayList<HistorialMedico>();
		//Recibe la lista
		historial=dao.recuperaHistorialMedico(IDPaciente);
		return historial;
	}//fin de m�todo consultaHistorialMedico
	
	/******************************************************************/ 
	/*anadeHistorialMedico: Se encarga de comunicarse con el DAO para a�adir datos al historial
	 * m�dico del paciente, se ocupa el idPaciente para identificarlo en la Base de Datos y a�adir los
	 * datos pasados como par�metro (fecha y observaciones)*/
	public boolean anadeHistorialMedico(String idPaciente,String fecha, String observaciones) {
		
		if(dao.anadeHistorialMedico(idPaciente,fecha,observaciones) == true) {
			return true; //regresa true si se a�adio correctamente los datos al historal m�dico del paciente
		}
		else
			return false; //regrea false si NO se a�adi� correctamente los datos al historial m�dico del paciente
	}//fin de m�todo anadeHistorialMedico

	/******************************************************************/ 
	/*obtenPaciente: se comunica con el DAO para recuperar un objeto de tipo paciente mediante su 
	 * idPago */
	@Override
	public Paciente obtenPaciente(int idPago) {
		
		Paciente paciente = new Paciente();
		paciente = dao.recuperaPaciente(idPago);
		return paciente;
	}//fin de m�todo obtenPaciente
	
	/******************************************************************/ 
	/*obtenPaciente: se comunica con el DAO para recuperar un objeto de tipo paciente mediante su ID
	 * para ocupar todos los datos que el paciente tiene  */
	public Paciente obtenPaciente(String idPaciente) {
		
		Paciente paciente = new Paciente();
		paciente = dao.recuperaPaciente(idPaciente);
		return paciente;
	}//fin de m�todo obtenPaciente
	
	/******************************************************************/ 
	/* Genera un identificador(ID) para un nuevo paciente
	 * @param nombre
	 * @param edad
	 * @param sexo
	 * @param telefono
	 * @return el identificador(ID)
	 El id se genera por la tercer letra del nombre, edad, sexo (M o F) y el cuarto d�gito de su tel�fono
	 */
	public String generaidpac(String nombre,int edad,String sexo,String telefono) {
		return ""+nombre.charAt(3)+""+edad+""+sexo.charAt(0)+""+telefono.charAt(4);
	}//fin de m�todo generaidpac
	
	/******************************************************************/ 
	/* Se comunica con el DAO para crear un nuevo paciente 
	 * @param nombre
	 * @param apellido
	 * @param telefono
	 * @param direccion
	 * @param email
	 * @param edad
	 * @param fecha_nacimiento
	 * @param sexo
	 * @param curp
	 * @param idpaciente
	 * @return true si se registro correctamente y false si no
	 */
	public boolean nuevo_paciente(String nombre,String apellido, String telefono, String direccion, String email, int edad,String fecha_nacimiento, String sexo, String curp,String idpaciente)
	{
		//System.out.println("Llegue a servicio");
	    //System.out.println("nombre: "+nombre+" tel: "+telefono+" Direccion: "+direccion+" correo: "+email+" edad: "+edad+" Fecha_nac: "+fecha_nacimiento+" CURP: "+curp);
		
		//Se crea un onbjeto de tipo Paciente para pasarlo al DAO y registrar al nuevo paciente con todos sus datos
		Paciente paciente=new Paciente();
		paciente.setNombre(nombre);
		paciente.setApellido(apellido);
		paciente.setCURP(curp);
		paciente.setDireccion(direccion);
		paciente.setEdad(edad);
		paciente.setEmail(email);
		paciente.setFecha_nacimiento(fecha_nacimiento);
		paciente.setTelefono(telefono);
		paciente.setSexo(sexo);
		paciente.setId_paciente(idpaciente);

	    if(dao.crea_paciente(paciente))
		 return true; //regresa true si se ha registrado correctamente el nuevo paciente
		else
			return false; //regresa false si no se registr� correctamente el nuevo paciente
	}//fin de m�todo nuevo_paciente
	
	/******************************************************************/
	/* recuperaNombre: Llama al DAO para recuperar el nombre del paciente por medio  de su ID */
	public String recuperaNombre(String idPaciente) {
		String nombre;
		nombre = dao.recuperaNombrePaciente(idPaciente);
		return nombre; //regresa el nombre
	}//fin de m�todo recuperaNombre
	
	/******************************************************************/ 
	/* recuperaCURP: Llama al DAO para recuperar el CURP del paciente */
	public String recuperaCURP(String idPaciente) {
		String curp;
		curp = dao.recuperaCURPPaciente(idPaciente);
		return curp; //regresa CURP
	}//fin de m�todo recuperaCURP
	
	/******************************************************************/ 
	/*verificaID: Se comunica con el DAO para verificar que el ID del paciente pasado como par�metro, exista.*/
	public boolean verificaID(String idPaciente) {
		if(dao.recuperaIDPaciente(idPaciente) == true) {
			return true; //regresa true si si se encuentra el paciente
		}
		else {
			return false; //regresa false si no se encuentra el paciente
		}
	}//fin de m�todo verificaID

	/******************************************************************/ 
	/*Se encarga de comunicarse con el DAO para recuperar un ArrayList de tipo Paciente para recuperar 
	 * todos los datos de todos los pacientes encontrados en la base de datos */
	@Override
	public ArrayList<Paciente> recuperaAllPaciente() {
		// TODO Auto-generated method stub
		return dao.recuperaAllPaciente();
	}//fin de m�todo recuperaAllPaciente
	
}