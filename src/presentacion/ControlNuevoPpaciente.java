package presentacion;



import javax.swing.JOptionPane;

import negocio1.ServicioPaciente;



public class ControlNuevoPpaciente {
	
	//servicio del paciente de la capa de negocio
	private ServicioPaciente servicio_paciente;
	//Ventana para nuevo paciente
	private Ventana_nuevo_paciente ventana;
	
	/*
	 * Constructor de ControlNuevoPpaciente
	 * @param servicio_paciente
	 */

	public ControlNuevoPpaciente(ServicioPaciente servicio_paciente) {
		this.servicio_paciente=servicio_paciente;
	}
	
	/*
	 * Incia el evento de la HU
	 */
	
	public void inicia() { 
		
		ventana=new Ventana_nuevo_paciente(this);
		ventana.abre();
		
	}
	
	/*
	 * Se comunica con el servcio paciente para registrar al nuevo paciente
	 * @param nombre
	 * @param apellido
	 * @param telefono
	 * @param direccion
	 * @param email
	 * @param edad
	 * @param fecha_nacimiento
	 * @param sexo
	 * @param curp
	 */
	public void nuevo_paciente(String nombre,String apellido,String telefono,String direccion,String email,int edad,String fecha_nacimiento,String sexo,String curp) {

		//Valida que no alla campos vacios
		if(nombre.equals("")||telefono.equals("")||direccion.equals("")||email.equals("")||edad==0||fecha_nacimiento.equals("")||sexo.equals("")||curp.equals("")) {
			ventana.muestraMensaje("Hay campos vacios");
			
		}
		else {
		    if(servicio_paciente.nuevo_paciente(nombre,apellido, telefono, direccion, email, edad, fecha_nacimiento, sexo, curp,servicio_paciente.generaidpac(nombre, edad, sexo, telefono))) {
		        //si se registro correctamente mandara un mensaje de exito
		    	if(ventana.muestraMensaje2("Desea imprimir el archivo del paciente con id: "+servicio_paciente.generaidpac(nombre, edad, sexo, telefono))==1);
	    			System.out.println("Imprimiendo");
		    }
		    else
		    	//si no se registro correctamente mandara un mensaje de error
		    	ventana.muestraMensaje("ERROR AL REGISTRAR AL PACIENTE");
		    
		}
		
		ventana.cierra();
		
	}

	
}
