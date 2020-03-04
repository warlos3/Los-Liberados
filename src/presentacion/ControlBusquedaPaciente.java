/*
 * Programa :Es el Control de Busqueda de Pacientes	"HU-16"
 * Autor : Ramirez Cordero Joselyn
 * Fecha: 02/03/ 2020
 * Descripción: Es la conexion entre el controlBusquedaPaciente y el servicioBusquedaPaciente, para moder manejar 
 *              los datos correspondientes.
 *              
 */

/* Contenido de listado
 * 
 * Métodos 
 *
 *  1° Public VentanaBusquedaPaciente(ControlBusquedaPaciente control) throws HeadlessException 
 *  2° Public void actionPerformed(ActionEvent e)
 *  3° Public void abre() 
 *  4° Public void muestraMensaje(String mensaje)
 *  5° Public void cierra()
 *  
 */



package presentacion;

import java.util.ArrayList;

import negocio1.ServicioPaciente;
import negocio.dominio.HistorialMedico;

	public class ControlBusquedaPaciente {
	
		//Se crea un objeto de la Ventana Busqueda Paciente
		
		private VentanaBusquedaPaciente ventana;
		//Servicio en la capa de negocio
		private ServicioPaciente servicioPaciente;
		HistorialMedico historial;
	
	    /* 
	     * Un constructor de la clase 
	     */
		
		public ControlBusquedaPaciente(ServicioPaciente servicio) {
			this.servicioPaciente = servicio;
		}
	
		/**
		 * El control inicia la ventana para la HU-16
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