package negocio1;

import java.util.ArrayList;

import datos.DAOCruzRoja;
import negocio.dominio.Doctor;
import negocio.dominio.Empleado;
import negocio.dominio.Recepcionista;

public class ServicioEmpleadoimp implements ServicioEmpleado {

	
	private DAOCruzRoja dao;
	public ServicioEmpleadoimp(DAOCruzRoja dao) {
		this.dao=dao;
	}
	
	
	public ServicioEmpleadoimp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean EliminaEmpleado(String ID) {
		return dao.elimina_empleado(ID);
	}
	
	@Override
	public String generaidEmp(String nombre,int edad,String sexo,String telefono) {
		
		return ""+nombre.charAt(3)+""+edad+""+sexo.charAt(0)+""+telefono.charAt(4); //genera id de empleado
	}
	
	@Override /* Agrega un empleado nuevo (Doctor) */
	public boolean agrega_empleadoDoc(String nombre, String apellido, String telefono, String direccion, String email, int edad,String fecha_ingreso, String sexo, String horario, String id_empleado, String cedulaProfesional, String especialidad) {
		System.out.println("Llegue a servicio Empleado");
	    System.out.println("nombre: "+nombre+" apellido: "+apellido+" tel: "+telefono+" Direccion: "+direccion+" correo: "+email+" edad: "+edad+" Fecha_Ingreso: "+fecha_ingreso+" Horario: "+horario+" id Emp: "+id_empleado+" cedula: "+cedulaProfesional+" especialidad: "+especialidad);

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
	    	return true; //regresa true si el empleado fue creado correctamete
	    else
	    	return false; //regresa false si el empleado no se creo correctamente
	}
	
	@Override /* Agrega un empleado nuevo (Recepcionista ) */
	public boolean agrega_empleadoRecep(String nombre, String apellido, String telefono, String direccion, String email, int edad,String fecha_ingreso, String sexo, String horario, String id_empleado, String escolaridad) {
		System.out.println("Llegue a servicio Empleado");
	    System.out.println("nombre: "+nombre+" apellido: "+apellido+" tel: "+telefono+" Direccion: "+direccion+" correo: "+email+" edad: "+edad+" Fecha_Ingreso: "+fecha_ingreso+" Horario: "+horario+" id Emp: "+id_empleado+" escolaridad: "+escolaridad);

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

	/*
	 * Se comunica con el DAO para recuperar un ArrayListd de doctores
	 * @return ArrayList<Doctor>
	 */
	public ArrayList<Doctor> recuperaAllempleadosDoc() {
		// TODO Auto-generated method stub
		return dao.recuperaAllempleadosDoc();
	}
	
	/*
	 * Se comunica con el DAO para recuperar un ArrayListd de Recepcionista
	 * @return ArrayList<Recepcionista>
	 */
	public ArrayList<Recepcionista> recuperaAllempleadosRec() {
		// TODO Auto-generated method stub
		return dao.recuperaAllempleadosRec();
	}

}
