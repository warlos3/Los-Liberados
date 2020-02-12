package presentacion;
import negocio1.ServicioPaciente;
import negocio1.ServicioConsulta;

public class ControlGeneraEspecialidad {

	//Ventana
	private VentanaGeneraEspecialidad ventana;
	//servicio de la capa de negocio
	private ServicioPaciente servicioPaciente;
	private ServicioConsulta servicioConsulta;
	
	public ControlGeneraEspecialidad(ServicioPaciente servicio, ServicioConsulta servicioConsulta) {
		this.servicioPaciente=servicio;
		this.servicioConsulta=servicioConsulta;
	}
	
	/*inicia ventana*/
public void inicia() { 	
		ventana=new VentanaGeneraEspecialidad(this);
		ventana.abre();
	}

	public void verificaImprime(String idPaciente, String nombre, String curp, String especialidad, String nombreDoc) {
		/*Revisa que losdatos ingresados por el usuario no esten vacios*/
		if(idPaciente.equals("")||nombre.equals("")||curp.equals("")||especialidad.equals("")||nombreDoc.equals("")) {
			ventana.muestraMensaje("Favor de llenar campos vacios"); //muestra ventana de llenar campos vacios
		}
		else { 
			if(servicioConsulta.verificaServicio(especialidad)) { //si la especialidad existe entonces se imprime
				ventana.muestraMensaje("Imprimiendo..."); //simula la impresion 
				ventana.cierra();
			}
			else //si no encuentra la especialida muestra mensaje de que no ha sido encontrada
				ventana.muestraMensaje("¡Especialidad no encontrada!");
		}	
	}
	

	public String dameNombrePaciente(String idPaciente) {
		String nombre=null;
		nombre = servicioPaciente.recuperaNombre(idPaciente); //llama a servicio para recuperar el nombre del paciente
		return nombre; //regresa el nombre
	}
	
	public String dameCURPPaciente(String idPaciente) { //llama a servicio para recuperar el CURP del paciente
		String curp=null;
		curp = servicioPaciente.recuperaCURP(idPaciente);
		return curp; //regresa CURP
	}
	
	public boolean verificaID(String idPaciente) {
		if(idPaciente.equals("")) { //verifica que el ID del paciente no este vacio
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
