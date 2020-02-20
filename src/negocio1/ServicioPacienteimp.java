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

	@Override
	public boolean EliminaPaciente(String ID) {
		return dao.elimina_paciente(ID);
	}
	
	@Override
	public Pago verificaPago(int idPago) {
		// TODO Auto-generated method stub
		//System.out.println("Llegue al servicio " + idPago);
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
		//Recibe la lista
		historial=dao.recuperaHistorialMedico(IDPaciente);
		return historial;
	}

	@Override
	public Paciente obtenPaciente(int idPago) {
		// TODO Auto-generated method stub
		Paciente paciente = new Paciente();
		paciente = dao.recuperaPaciente(idPago);
		return paciente;
	}
	
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
		//System.out.println("Llegue a servicio");
	    //System.out.println("nombre: "+nombre+" tel: "+telefono+" Direccion: "+direccion+" correo: "+email+" edad: "+edad+" Fecha_nac: "+fecha_nacimiento+" CURP: "+curp);
		
		//Se crea un on¿bjeto de tipo Paciente para pasarle ese parametro al DAO
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
		 return true;
		else
			return false;
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
		else {
			return false; //regresa false si no se encuentra el paciente
		}
	}

	@Override
	public ArrayList<Paciente> recuperaAllPaciente() {
		// TODO Auto-generated method stub
		return dao.recuperaAllPaciente();
	}
	
	public boolean nuevoPaciente2(Paciente p) {
		
		if(dao.crea_paciente(p))
			 return true;
			else
				return false;

	}
	
}