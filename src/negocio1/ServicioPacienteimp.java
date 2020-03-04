/*
 * Programa : Servicio Paciente "HU-16"
 * Autor : Ramirez Cordero Joselyn
 * Fecha: 02/03/ 2020
 * Descripción: Servicio Paciente se conecta con la base de datos,
 *             se hace con diagrama de secuencia 
 *              
 */

/* Contenido de listado
 * 
 * Métodos 
 *
 *  1° Public ServicioPacienteimp(DAOCruzRoja dao)
 *  2° Public boolean EliminaPaciente(String ID)
 *  3° Public Pago verificaPago(int idPago)
 *  4° Public ArrayList<HistorialMedico> consultaHistorialMedico (String IDPaciente)
 *  5° Public boolean anadeHistorialMedico(String idPaciente,String fecha, String observaciones)
 *  6° Public Paciente obtenPaciente(int idPago)
 *  7° Public String generaidpac(String nombre,int edad,String sexo,String telefono)
 *  8° Public boolean nuevo_paciente(String nombre,String apellido, String telefono, String direccion, String email, int edad,String fecha_nacimiento, String sexo, String curp,String idpaciente)
 *  9° Public String recuperaNombre(String idPaciente)
 *  10°Public String recuperaCURP(String idPaciente)
 *  11°Public boolean verificaID(String idPaciente)
 *  12°Public ArrayList<Paciente> recuperaAllPaciente()
 *  
 */
package negocio1;

import java.util.ArrayList;

import negocio.dominio.Pago;
import datos.DAOCruzRoja;
import negocio.dominio.HistorialMedico;
import negocio.dominio.Paciente;

/**
 * Servicio que se conecta con Dao para recuperar informacion
 */
	public class ServicioPacienteimp implements ServicioPaciente {

		private DAOCruzRoja dao;
	
	/*
	 	* Constructor
	 * @param dao
	 */
		
		public ServicioPacienteimp(DAOCruzRoja dao) {
			this.dao=dao;
		}

		@Override
		public boolean EliminaPaciente(String ID) {
			return dao.elimina_paciente(ID);
		}
	
		@Override
		public Pago verificaPago(int idPago) {
			// TODO Auto-generated method stub
			Pago pago = new Pago();
			//Se conecta con el DAO para poder recuperar el objeto pago y le manda el idPago
			pago = dao.recuperaPago(idPago);
		
			return pago;
		}

		/**
		 * Se comunica con el DAO para recuperar el historial medico
		 * @param IDPaciente Recibe como parametro el Id del paciente del cual se quiere consultar el historial medico
		 * @return Devuelve un ArrayList de tipo Historial medico con toda la información medica del paciente
		 */
		
		public ArrayList<HistorialMedico> consultaHistorialMedico (String IDPaciente) {
		
			ArrayList<HistorialMedico> historial = new ArrayList<HistorialMedico>();
			//Recibe la lista de pacientes
			historial=dao.recuperaHistorialMedico(IDPaciente);
			return historial;
		}
	
		/*
		 * Generamos el historial Medico 
		 */
		
		public boolean anadeHistorialMedico(String idPaciente,String fecha, String observaciones) {
			if(dao.anadeHistorialMedico(idPaciente,fecha,observaciones) == true) {
				return true;
			}
			else
				return false;
		}

		@Override
	
		/*
		 * Se obtine al paciente con ide de pago
		 */
		
		public Paciente obtenPaciente(int idPago) {
			// TODO Auto-generated method stub
			Paciente paciente = new Paciente();
			paciente = dao.recuperaPaciente(idPago);
			return paciente;
		}
	
		/* 
		 * Recuperamos al paciente con su id 
		 */
		
		public Paciente obtenPaciente(String idPaciente) {
			Paciente paciente = new Paciente();
			paciente = dao.recuperaPaciente(idPaciente);
			return paciente;
		}
	
		/*
		 * Genera un identificador(ID) para un nuevo paciente
		 * @param nombre
		 * @param edad
		 * @param sexo
		 * @param telefono
		 * @return el identificador(ID)
		 */
		
		public String generaidpac(String nombre,int edad,String sexo,String telefono) {
		
			return ""+nombre.charAt(3)+""+edad+""+sexo.charAt(0)+""+telefono.charAt(4);
		}
	
		/*
		 * Se comunica con el DAO para crear un nuevo paciente 
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
			//Se crea un objeto de tipo Paciente para pasarle ese parametro al DAO
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

			if(dao.crea_paciente(paciente)) {
				return true;
			}
			else 
			{
				return false;
			}	
		}
	
		/* Llama al DAO para recuperar el nombre del paciente */
		public String recuperaNombre(String idPaciente) {
			String nombre;
			nombre = dao.recuperaNombrePaciente(idPaciente);
			return nombre; //regresa el nombre
		}
	
		/* Llama al DAO para recuperar el CURP del paciente */
		public String recuperaCURP(String idPaciente) {
			String curp;
			curp = dao.recuperaCURPPaciente(idPaciente);
			return curp; //regresa CURP
		}
	
	
		public boolean verificaID(String idPaciente) { //verifica que el ID del paciente exista
			if(dao.recuperaIDPaciente(idPaciente) == true) {
				return true; //regresa true si si se encuentra el paciente
			}
			else
			{
				return false; //regresa false si no se encuentra el paciente
			}
		}

		@Override
		public ArrayList<Paciente> recuperaAllPaciente() {
			// TODO Auto-generated method stub
			return dao.recuperaAllPaciente();
		}
	
	}