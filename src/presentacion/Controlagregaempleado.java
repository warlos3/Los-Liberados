package presentacion;

import negocio1.ServicioEmpleado;

public class Controlagregaempleado {
	//servicio de la capa de negocio
	private ServicioEmpleado servicio_empleado;
	//Ventana
	private Ventana_agrega_empleado ventana;

	
	
	public Controlagregaempleado(ServicioEmpleado servicio_empleado) {
		this.servicio_empleado=servicio_empleado;
	}
	
	/*inicia ventana*/
	public void inicia() { 
		
		ventana=new Ventana_agrega_empleado(this);
		ventana.setVisible(true);
		
	}
	
	public void agrega_empleadoDoc(String nombre,String apellido, String telefono,String direccion,String email,int edad,String fecha_ingreso,String sexo,String horario, String cedulaProfesional, String especialidad) {

		/*Revisa que losdatos ingresados por el usuario no esten vacios*/
		if(nombre.equals("")||apellido.equals("")||telefono.equals("")||direccion.equals("")||email.equals("")||edad==0||fecha_ingreso.equals("")||sexo.equals("")||horario.equals("")||cedulaProfesional.equals("")||especialidad.equals("")) {
	    	ventana.muestraMensaje("Favor de llenar campos vacios"); //muestra ventana de llenar todos los campos.
			
		}
		else {
			System.out.println("Llegue a control de nuevo");
			 System.out.println("nombre: "+nombre+" apellido: "+apellido+" tel: "+telefono+" Direccion: "+direccion+" correo: "+email+" edad: "+edad+" Fecha_Ingres: "+fecha_ingreso+" Horario: "+horario+" cedula: "+cedulaProfesional+" especialidad: "+especialidad);
				
			 /*Llama a servicio para agregar un nuevo empleado*/
		    if(servicio_empleado.agrega_empleadoDoc(nombre, apellido, telefono, direccion, email, edad, fecha_ingreso, sexo, horario,servicio_empleado.generaidEmp(nombre, edad, sexo, telefono),cedulaProfesional, especialidad)) {
		    	ventana.muestraMensaje("Empleado registrado Correctamente\nID Emp: "+servicio_empleado.generaidEmp(nombre, edad, sexo, telefono));
		    	
		    }
		    else //si hay problema en registrar al empleado, muestra mensaje de error
		    	ventana.muestraMensaje("ERROR AL REGISTRAR AL EMPLEADO");
		
		}
		
		ventana.setVisible(false);
		
	}
	
	public void agrega_empleadoRecep(String nombre,String apellido, String telefono,String direccion,String email,int edad,String fecha_ingreso,String sexo,String horario, String escolaridad) {

		/*Revisa que losdatos ingresados por el usuario no esten vacios*/
		if(nombre.equals("")||apellido.equals("")||telefono.equals("")||direccion.equals("")||email.equals("")||edad==0||fecha_ingreso.equals("")||sexo.equals("")||horario.equals("")||escolaridad.equals("")) {
	    	ventana.muestraMensaje("Favor de llenar campos vacios");
			
		}
		else {
			System.out.println("Llegue a control de nuevo");
			 System.out.println("nombre: "+nombre+" apellido: "+apellido+" tel: "+telefono+" Direccion: "+direccion+" correo: "+email+" edad: "+edad+" Fecha_Ingres: "+fecha_ingreso+" Horario: "+horario);
				
			 /*Llama a servicio para agregar un recepcionista*/
		    if(servicio_empleado.agrega_empleadoRecep(nombre, apellido, telefono, direccion, email, edad, fecha_ingreso, sexo, horario,servicio_empleado.generaidEmp(nombre, edad, sexo, telefono),escolaridad)) {
		    	ventana.muestraMensaje("Empleado registrado Correctamente\nID Emp: "+servicio_empleado.generaidEmp(nombre, edad, sexo, telefono));
		    	
		    }
		    else //si hay problema en registrar al empleado, muestra mensaje de error
		    	ventana.muestraMensaje("ERROR AL REGISTRAR AL EMPLEADO");
		
		}
		
		ventana.setVisible(false);
		
	}

}
