package negocio1;

import java.util.ArrayList;

import negocio.dominio.HistorialMedico;
import negocio.dominio.Paciente;
import negocio.dominio.Pago;

/**
 * La interfaz de servicio paciente
 * @author 
 *
 */
public interface ServicioPaciente {
	
	public boolean EliminaPaciente(String ID);

	/*Revisa en la base de datos si el paciente a efectuado el pago del servicio
	 *@param IDPacinete
	 *@return devuelve tru si ya a echo el pago y false si no	
	 */
	public Pago verificaPago(int idPago);
	
	/**
	 *Consulta el historial medico de un paciente  
	 * @param IDPaciente Id del paciente del cual se requiere consultar su historial medico
	 * @return Devuelve un ArrayList de tipo historial medico con la informacion del paciente
	 */
	public ArrayList<HistorialMedico> consultaHistorialMedico(String IDPaciente);
	
	/*
	 * Obtine toda la informacion de un paciente 
	 * @param IDPaciente
	 * @return devuelve Paciente o null
	 */
	
	public Paciente obtenPaciente(int idPago);
	
	/*
	 * Registra a un nuevo paciente
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
	 * @return devuelve true si a sido registrado exitosamente y false si no
	 */
	
	public Paciente obtenPaciente(String idPaciente);
	
	/*
	 * Registra a un nuevo paciente
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
	 * @return devuelve true si a sido registrado exitosamente y false si no
	 */

	boolean nuevo_paciente(String nombre,String apellido, String telefono, String direccion, String email, int edad,
			String fecha_nacimiento, String sexo, String curp, String idpaciente);

	/*
	 * Genera un identificador para un nuevo paciente
	 * @param nombre
	 * @param edad
	 * @param sexo
	 * @param telefono
	 * @return una cadena con el identificador
	 */
	public String generaidpac(String nombre, int edad, String sexo, String telefono);

	public String recuperaNombre(String idPaciente);

	public String recuperaCURP(String idPaciente);

	public boolean verificaID(String idPaciente);

	public ArrayList<Paciente> recuperaAllPaciente();
	
}