package presentacion;

import java.util.*;
import negocio.dominio.Paciente;
import negocio1.ServicioPaciente;

public class ControlModificaPaciente {

	private ServicioPaciente servicioPaciente;
	
	private VentanaModificaPaciente ventana;
	
	public ControlModificaPaciente(ServicioPaciente s) {
		this.servicioPaciente=s;
	}
	
	public ArrayList<Paciente> recuperaAllPaciente() {
		return servicioPaciente.recuperaAllPaciente();
	}
	
	public void inicia() {
		ventana=new VentanaModificaPaciente(this);
		ventana.abre();
	}
	
	public boolean pacienteEncontrado(String id) {
		boolean encontrado = false;
		Paciente aux = new Paciente();
		if(aux!=null)
			encontrado=true;
		return encontrado;
	}
	
	public Paciente buscarPaciente(String id) {
		Paciente aux = servicioPaciente.obtenPaciente(id);
		return aux;
	}
	
	public Paciente pacienteModificado() {
		Paciente p=new Paciente();
		return p;
	}
	
	public void modificar(String Id, Paciente p) {
		
		if(servicioPaciente.EliminaPaciente(Id)) {
			servicioPaciente.nuevoPaciente2(p);
		}
		else {
			
		}
	}
}
