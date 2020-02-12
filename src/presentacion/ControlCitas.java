package presentacion;
import java.util.ArrayList;

import negocio.dominio.Consulta;
import negocio.dominio.Paciente;
import negocio1.ServicioConsulta;

public class ControlCitas {
	
	/*ServicioConsulta de la capa de negocio*/
	private ServicioConsulta servicioconsulta;
	/*Interfaz para las citas*/
	private VentanaCitas ventana;
	
	/*Constructor*/
	public ControlCitas(ServicioConsulta servicioconsulta) {
		this.servicioconsulta = servicioconsulta;
	}

	/*Inicia el evento de la HU*/
	public void inicia() { 
		ventana=new VentanaCitas(this);
		ventana.abre();
	}

	/*Recupera un ArrayList de todas las citas que sean encontradas en la base de datos*/
	public ArrayList<Consulta> recuperaAllCitas() {
		return servicioconsulta.recuperaAllCitas();
	}
	
	/*Recupera la informacion de las citas y la informacion del paciente*/
	public void verificaCita(String idPaciente) {
		Consulta consulta = new Consulta();
		Paciente paciente = new Paciente();
		System.out.println("Control" + idPaciente);
		consulta = null;
		//A traves del servicio le manda el id de la cita para recuperar un los datos
		//de la consulta y lo almacena en la variable consulta
	    consulta = servicioconsulta.recuperaCita(idPaciente);
		//A traves del servicio le manda el id de la cita para recuperar un paciente y lo almacena en la variable paciente
		paciente = servicioconsulta.recuperaPaciente(idPaciente);
		//Cuando el retorno es distinto de nulo quiere decir que fue encontrada la cita, de lo contrario no existe la cita
		if(consulta != null) {
			ventana.ventanaExito(this, consulta, paciente);
		}
		else {
			ventana.ventanaError(this);
		}
	}
	
}
