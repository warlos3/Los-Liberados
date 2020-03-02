package presentacion;

import java.util.ArrayList;



import negocio.dominio.Doctor;
import negocio.dominio.Recepcionista;
import negocio1.ServicioEmpleado;

public class ControlBuquedaHorarios {
	
	//servicio empleado de la capa de negocio
		private ServicioEmpleado servicioempleado;
		//Ventana de elimina empleado
		private VentanaBusquedaHorarios ventana;
		
		/*
		 * Constructor de Control Busqueda  Horarios
		 */
		public ControlBuquedaHorarios( ServicioEmpleado servicioempleado) {
			this.servicioempleado=servicioempleado;
			
		}
		/*
		 * Inicia el evento de la HU
		 */
		public void inicia() { 

			ventana=new VentanaBusquedaHorarios(this);
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
		
		

}
