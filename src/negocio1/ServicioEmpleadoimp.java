/******************************************************************/ 
/* INFORMACION */



/* Programa: Cruz Roja */ 


/* Autor: Todo el equipo de desarrollo  */ 

/* Descripción: Este servicio es el encargado de todo lo relacionado con el empleado. Obtiene información
 * 				del empleado como, nombre, ID de empleado, telefono, correo, direccion, etc.
 * 				El servicioEmpleado se comunica con el DAOCruzRoja, para obtener datos de los empleados 
 * 				mediante los métodos utilizados aquí.
 */ 

/******************************************************************/

/* Contenido del Listado:
 * 		- public boolean EliminaEmpleado(String ID)
 * 		- public String generaidEmp(String nombre,int edad,String sexo,String telefono)
 * 		- public boolean agrega_empleadoDoc(String nombre, String apellido, String telefono, String direccion, String email, int edad,String fecha_ingreso, String sexo, String horario, String id_empleado, String cedulaProfesional, String especialidad)
 * 		- public boolean agrega_empleadoRecep(String nombre, String apellido, String telefono, String direccion, String email, int edad,String fecha_ingreso, String sexo, String horario, String id_empleado, String escolaridad)
 * 		- public ArrayList<Doctor> recuperaAllempleadosDoc()
 * 		- public ArrayList<Recepcionista> recuperaAllempleadosRec()
 */

/******************************************************************/

package negocio1;

import java.util.ArrayList;

import datos.DAOCruzRoja;
import negocio.dominio.Doctor;
import negocio.dominio.Empleado;
import negocio.dominio.Recepcionista;

public class ServicioEmpleadoimp implements ServicioEmpleado {

	/******************************************************************/ 
	/*Conexión a la Base de Datos*/
	private DAOCruzRoja dao;
	public ServicioEmpleadoimp(DAOCruzRoja dao) {
		this.dao=dao;
	}//fin de método 
	
	public ServicioEmpleadoimp() {
		// TODO Auto-generated constructor stub
	}
	
	/******************************************************************/ 
	/*Llama al DAO para eliminar todo un empleado tomando de referencia su ID*/
	@Override
	public boolean EliminaEmpleado(String ID) {
		return dao.elimina_empleado(ID);
	}//fin de método EliminaEmpleado.
	
	/******************************************************************/ 
	/*generaidEmp: como el nombre lo indica, genera un ID de empleado para ser registrado en la BD
	 * 		su ID se conforma por: tercer letra de su nombre, edad, sexo (M o F) y 
	 * 		por el cuarto número de su telefono (los cuales son los parámetros de este método).*/
	@Override
	public String generaidEmp(String nombre,int edad,String sexo,String telefono) {
		return ""+nombre.charAt(3)+""+edad+""+sexo.charAt(0)+""+telefono.charAt(4); //genera id de empleado
	}
	/******************************************************************/ 
	/* agrega_empleadoDoc: Se encarga de agregar un empleado nuevo (Doctor) */
	@Override 
	public boolean agrega_empleadoDoc(String nombre, String apellido, String telefono, String direccion, String email, int edad,String fecha_ingreso, String sexo, String horario, String id_empleado, String cedulaProfesional, String especialidad) {
		/*Prints de prueba*/
		System.out.println("Llegue a servicio Empleado");
	    System.out.println("nombre: "+nombre+" apellido: "+apellido+" tel: "+telefono+" Direccion: "+direccion+" correo: "+email+" edad: "+edad+" Fecha_Ingreso: "+fecha_ingreso+" Horario: "+horario+" id Emp: "+id_empleado+" cedula: "+cedulaProfesional+" especialidad: "+especialidad);

	    /*Se asignan los datos del empleado*/
	    Empleado empleado = new Empleado();
	    empleado.setNombre(nombre);
	    empleado.setApellido(apellido);
	    empleado.setTelefono(telefono);
	    empleado.setDireccion(direccion);
	    empleado.setEmail(email);
	    empleado.setEdad(edad);
	    empleado.setFecha_ingreso(fecha_ingreso);
	    empleado.setSexo(sexo);
	    empleado.setHorario(horario);
	    empleado.setId_empleado(id_empleado);
	    empleado.setCedulaProfesional(cedulaProfesional);
	    empleado.setEspecialidad(especialidad);
	    
	    if(dao.crea_empleadoDoc(empleado)) //llama al DAO para crear el empleado Doctor
	    	return true; //regresa true si el empleado fue creado correctamente
	    else
	    	return false; //regresa false si el empleado no se creo correctamente
	}
	
	/******************************************************************/ 
	/*agrega_empladoRecep: Se encarga de agregar un nuevo empleado (Recepcionista)*/
	@Override 
	public boolean agrega_empleadoRecep(String nombre, String apellido, String telefono, String direccion, String email, int edad,String fecha_ingreso, String sexo, String horario, String id_empleado, String escolaridad) {
		/*Prints de prueba*/
		System.out.println("Llegue a servicio Empleado");
	    System.out.println("nombre: "+nombre+" apellido: "+apellido+" tel: "+telefono+" Direccion: "+direccion+" correo: "+email+" edad: "+edad+" Fecha_Ingreso: "+fecha_ingreso+" Horario: "+horario+" id Emp: "+id_empleado+" escolaridad: "+escolaridad);

	    /*Se asignan los datos del empleado*/
	    Empleado empleado = new Empleado();
	    empleado.setNombre(nombre);
	    empleado.setApellido(apellido);
	    empleado.setTelefono(telefono);
	    empleado.setDireccion(direccion);
	    empleado.setEmail(email);
	    empleado.setEdad(edad);
	    empleado.setFecha_ingreso(fecha_ingreso);
	    empleado.setSexo(sexo);
	    empleado.setHorario(horario);
	    empleado.setId_empleado(id_empleado);
	    empleado.setEscolaridad(escolaridad);
	    
	    if(dao.crea_empleadoRecep(empleado)) //llama al DAO para crear el empleado recepcionista
	    	return true; //regresa true si el empleado fue creado correctamete
	    else
	    	return false; //regresa false si el empleado no se creo correctamente
	}

	@Override
	public Empleado recupera_empleado(Empleado empleado) {
		// TODO Auto-generated method stub
		return null;
	}

	/******************************************************************/ 
	/* Se comunica con el DAO para recuperar un ArrayList de tipo Doctor
	 * @return ArrayList<Doctor>
	*/
	public ArrayList<Doctor> recuperaAllempleadosDoc() {
		// TODO Auto-generated method stub
		return dao.recuperaAllempleadosDoc();
	}
	
	/******************************************************************/ 
	/* Se comunica con el DAO para recuperar un ArrayList de tipo Recepcionista
	 * @return ArrayList<Recepcionista>
	 */
	public ArrayList<Recepcionista> recuperaAllempleadosRec() {
		// TODO Auto-generated method stub
		return dao.recuperaAllempleadosRec();
	}

}
