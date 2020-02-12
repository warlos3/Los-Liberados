package presentacion;

import java.util.ArrayList;

import negocio1.ServicioPaciente;
import negocio.dominio.HistorialMedico;

/**
 * Controla el funcionamiento de la consulta de historial medico
 * @author Brianda Garcia
 *
 */
public class ControlBusquedaPaciente {
	
	//Ventana
	private VentanaBusquedaPaciente ventana;
	//Servicio en la capa de negocio
	private ServicioPaciente servicioPaciente;
	HistorialMedico historial;
	
	/**
	 * Constructor
	 * @param servicio
	 */
	public ControlBusquedaPaciente(ServicioPaciente servicio) {
		this.servicioPaciente = servicio;
	}
	
	/**
	 * El control inicia la ventana para la HU
	 */
	public void inicia() {
		//El sistema muestra la ventana de busqueda de paciente
		ventana = new VentanaBusquedaPaciente(this);
		ventana.abre();
	}
	
	/**
	 * Hace la comunicacion con el servicio de paciente
	 * @param IDPaciente Id del paciente del cual se requiere consultar su historial medico
	 * @return Devuelve un ArrayList de tipo Historial medico con la información medica del paciente
	 */
	public ArrayList<HistorialMedico> consultaHistorialMedico(String IDPaciente) {
		//Usuario introduce los datos del paciente
		//Verifica primero que los datos no esten vacios
		if(IDPaciente.equals("")) {
			ventana.muestraMensaje("Ingrese un ID");
		}
		else {
			ArrayList<HistorialMedico> historial = new ArrayList<HistorialMedico>();
			//Se recibe el historial medico del paciente
			historial=servicioPaciente.consultaHistorialMedico(IDPaciente);
			//Valida que sea un paciente existente
			if(historial.size()==0) {
				ventana.muestraMensaje("No se ha podido encontrar un historial medico");
			}
			else {
				return historial;
			}
		}
		ventana.cierra();
		return null;
	}
}