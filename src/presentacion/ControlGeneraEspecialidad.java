/* Programa:  Cruz Roja - ControlGeneraEspacialidad */ 
/* Autor: Jiménez Linares Suemy Ximena */ 
/* Descripción: En esta clase, el control se comunica con la VentanaGeneraEspacialidad y con el ServicioPaciente, 
 * el control tiene metodos que se verifican los datos ingresados por el usuario y recuperar datos de un paciente
 * cuando el usuario ingresa el id del paciente deseado para poder realizar otra accion 
 */ 

/****************************************************************************************************************/

/*Contenido del Listado: 
 * inicia()
 * verificaImprime(String idPaciente, String nombre, String curp, String especialidad, String nombreDoc)
 * dameNombrePaciente(String idPaciente)
 * dameCURPPaciente(String idPaciente)
 * verificaID(String idPaciente)
 */

/******************************************************************************************************************/


package presentacion;
import negocio1.ServicioPaciente;
import negocio1.ServicioConsulta;

public class ControlGeneraEspecialidad {

	
	private VentanaGeneraEspecialidad ventana;//Ventana
	private ServicioPaciente servicioPaciente; //servicio de la capa de negocio
	private ServicioConsulta servicioConsulta;
	
	public ControlGeneraEspecialidad(ServicioPaciente servicio, ServicioConsulta servicioConsulta) {
		this.servicioPaciente=servicio;
		this.servicioConsulta=servicioConsulta;
	}
	
	/*método que inicia la ventana VentanaGeneraEspecialidad*/
public void inicia() { 	
		ventana=new VentanaGeneraEspecialidad(this);
		ventana.abre();
	}

	/*método que revisa que los datos ingresados por el usuario no esten vacios*/
	public void verificaImprime(String idPaciente, String nombre, String curp, String especialidad, String nombreDoc) {
		
		if(idPaciente.equals("")||nombre.equals("")||curp.equals("")||especialidad.equals("")||nombreDoc.equals("")) {
			ventana.muestraMensaje("Favor de llenar campos vacios"); //muestra ventana de llenar campos vacios
		}
		else { 
			if(servicioConsulta.verificaServicio(especialidad)) { //si la especialidad existe entonces se imprime
				ventana.muestraMensaje("Imprimiendo..."); //simula la impresion 
				ventana.cierra();
			}
			else //si no se encuentra la especialida muestra mensaje de que no ha sido encontrada
				ventana.muestraMensaje("¡Especialidad no encontrada!");
		}	
	}
	
	/*metodo que recupera el nombre del paciente mediante el id*/
	public String dameNombrePaciente(String idPaciente) {
		String nombre=null;
		nombre = servicioPaciente.recuperaNombre(idPaciente); //llama al servicio paciente para recuperar el nombre del paciente
		return nombre; //si el id del paciente fue encontrado regresa el nombre de dicho paciente
	}
	
	/*metodo que recupera el curp del paciente mediante el id*/
	public String dameCURPPaciente(String idPaciente) { 
		String curp=null;
		curp = servicioPaciente.recuperaCURP(idPaciente); //llama a servicio para recuperar el CURP del paciente
		return curp; //si el id del paciente fue encontrado regresa CURP
	}
	
	/*metodo que verifica que el ID del paicente no este vacio, si el campo esta vacio se muestra un mensaje pidiendo que se ingrese 
	 * el id del paciente, si no esta vacio se verifica que el id del paciente exista*/
	public boolean verificaID(String idPaciente) {
		if(idPaciente.equals("")) { //verifica que el campo id paciente no este vacio
			ventana.muestraMensaje("Ingrese ID de Paciente");
			return false;
		}
		else {
			if(servicioPaciente.verificaID(idPaciente) == true) { //verifica que el ID del paciente exista
				return true;
			}
			else { // si no se encuentra el ID del paciente muestra error de ID
				ventana.muestraMensaje("ID Paciente no existe");
				return false;
			}//fin else
			
		}//fin else
	}//fin del metodo

}//fin de la clase
