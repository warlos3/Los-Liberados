package presentacion;

import java.util.ArrayList;

import negocio.dominio.Doctor;
import negocio.dominio.Recepcionista;
import negocio1.ServicioEmpleado;



public class ControlEliminaEmpleado {
	
	
	//servicio empleado de la capa de negocio
	private ServicioEmpleado servicioempleado;
	//Ventana de elimina empleado
	private VentanaEliminaEmpleado ventana;
	
	/*
	 * Constructor de ControlEliminaEmpleado
	 */
	public ControlEliminaEmpleado( ServicioEmpleado servicioempleado) {
		this.servicioempleado=servicioempleado;
		
	}
	/*
	 * Inicia el evento de la HU
	 */
	public void inicia() { 

		ventana=new VentanaEliminaEmpleado(this);
		ventana.abre();
	}
	
	/*
	 * Recupera un ArrayList de doctores que esten registrados en la base de datos
	 */
	public ArrayList<Doctor> recuperaAllEmpleadosDoc() {
		return servicioempleado.recuperaAllempleadosDoc();
	}
	
	/*
	 * Recupera un ArrayList de Recepcionistas que esten registrados en la base de datos
	 */
	public ArrayList<Recepcionista> recuperaAllEmpleadosRec() {
		return servicioempleado.recuperaAllempleadosRec();
	}
	
	/*
	 * Elimina al empleado seleccionado
	 * @param ID del empleado
	 */
	public void eliminaEmpleado( String ID) {
		
		//Si se elimino correctamente al empleado se manda mensaje de exito en otro caso mensaje de error
		
		if(servicioempleado.EliminaEmpleado(ID))
		  		ventana.muestraMensaje("Se a eliminado al empleado");
		else	
		  		ventana.muestraMensaje("Error al eliminar al empleado");
		
		
		ventana.cierra();
		
	}
	
	

}
