package datos;

import java.util.ArrayList;

import negocio.dominio.Consulta;
import negocio.dominio.Doctor;
import negocio.dominio.Empleado;
import negocio.dominio.HistorialMedico;
import negocio.dominio.Paciente;
import negocio.dominio.Pago;
import negocio.dominio.Recepcionista;
import negocio.dominio.Reporte;

/**
 * Interface del dao
 * @author 
 *
 */
public interface DAOCruzRoja {
	
	public Empleado recupera_empleado(Empleado empleado);
	
	public ArrayList<Doctor> recuperaAllempleadosDoc();
	
	public ArrayList<Recepcionista> recuperaAllempleadosRec();
	
	public boolean crea_empleadoDoc(Empleado empleado);
	
	public boolean crea_empleadoRecep(Empleado empleado);
	
	public boolean elimina_empleado(String ID);
	
	/**
	 * Recupera historial medico de un paciente
	 * @param IDPaciente id del paciente del cual se quiere recuperar el historial medico
	 * @return Devuelve el historial medico
	 */
    public ArrayList<HistorialMedico> recuperaHistorialMedico(String IDPaciente);
	
	public Paciente recuperaPaciente(int idPago);
	
	public Paciente recuperaPaciente(String idPaciente);
	
	public Pago recuperaPago(int Pago);
	
	public boolean elimina_paciente(String ID);

	/**
	 * Recupera los servicios prestados en un periodo deterinado
	 * @param periodo el periodo del cual se recuperan los pagos y servicios
	 * @return Devuelve un reporte financiero
	 */
	public ArrayList<Reporte> recuperaServicio(String periodo);

	boolean crea_paciente(Paciente paciente);
	
	public String verificaUsuario(String nombre, String contra);

	public String recuperaNombrePaciente(String idPaciente);

	public String recuperaCURPPaciente(String idPaciente);

	boolean recuperaIDPaciente(String idPaciente);

	boolean recuperaEspecialidad(String especialidad);

	Paciente recupera_paciente(Paciente paciente);

	Pago recupera_pago(Paciente paciente);

	public ArrayList<Paciente> recuperaAllPaciente();
	
	public ArrayList<Consulta> recuperaAllCitas();
	
	public Consulta recuperaCita(String idPaciente);
	
	public boolean anadeHistorialMedico(String idPaciente, String fecha, String observaciones);

}