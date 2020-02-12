package negocio1;

import java.util.ArrayList;

import negocio.dominio.Doctor;
import negocio.dominio.Empleado;
import negocio.dominio.Recepcionista;

public interface ServicioEmpleado {
	
	public boolean EliminaEmpleado(String ID);
	
	public Empleado recupera_empleado(Empleado empleado);	
	
	public ArrayList<Doctor> recuperaAllempleadosDoc();
	
	public ArrayList<Recepcionista> recuperaAllempleadosRec();

	boolean agrega_empleadoDoc(String nombre, String apellido, String telefono, String direccion, String email, int edad,
			String fecha_ingreso, String sexo, String horario, String id_empleado, String cedulaProfesional, String especialidad);

	boolean agrega_empleadoRecep(String nombre, String apellido, String telefono, String direccion, String email, int edad,
			String fecha_ingreso, String sexo, String horario, String id_empleado, String escolaridad);

	public String generaidEmp(String nombre, int edad, String sexo, String telefono);

}
