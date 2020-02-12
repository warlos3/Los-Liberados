package presentacion;

import java.util.ArrayList;

import negocio.dominio.Paciente;
import negocio1.ServicioPaciente;

public class ControlEliminaPaciente {
		
		
		//servicio empleado de la capa de negocio
		private ServicioPaciente serviciopaciente;
		//Ventana de elimina paciente
		private VentanaEliminaPaciente ventana;
		
		/*
		 * Constructor de ControlEliminaPaciente
		 */
		public ControlEliminaPaciente( ServicioPaciente serviciopaciente) {
			this.serviciopaciente=serviciopaciente;
			
		}
		/*
		 * Inicia el evento de la HU
		 */
		public void inicia() { 

			ventana=new VentanaEliminaPaciente(this);
			ventana.abre();
		}
		
		/*
		 * Recupera un ArrayList de pacientes que esten registrados en la base de datos
		 */
		public ArrayList<Paciente> recuperaAllPaciente() {
			return serviciopaciente.recuperaAllPaciente();
		}
		
		/*
		 * Recupera un ArrayList de Recepcionistas que esten registrados en la base de datos
		 */
		/*public ArrayList<Recepcionista> recuperaAllEmpleadosRec() {
			return servicioempleado.recuperaAllempleadosRec();
		}*/
		
		/*
		 * Elimina al Paciente seleccionado
		 * @param ID del paciente
		 */
		public void eliminaPaciente( String ID) {
			
			//Si se elimino correctamente al paciente se manda mensaje de exito en otro caso mensaje de error
			
			if(serviciopaciente.EliminaPaciente(ID))
			  		ventana.muestraMensaje("Se a eliminado al paciente");
			else	
			  		ventana.muestraMensaje("Error al eliminar al paciente");
			
			
			ventana.cierra();
			
		}
		public ArrayList<Paciente> recuperaAllEmpleadosPac() {
			// TODO Auto-generated method stub
			return serviciopaciente.recuperaAllPaciente();
		}
		
		

	}



