package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


import datos.DAOCruzRoja;
import negocio.dominio.Consulta;
import negocio.dominio.Doctor;
import negocio.dominio.Empleado;
import negocio.dominio.HistorialMedico;
import negocio.dominio.Paciente;
import negocio.dominio.Pago;
import negocio.dominio.Recepcionista;
import negocio.dominio.Reporte;

public class DAOCRUZROJAMock implements DAOCruzRoja {

	private static Map <String, Paciente> pac = new HashMap <String, Paciente>();
	private static Map <String, Doctor> doc = new HashMap <String, Doctor>();
	private static Map <String, Recepcionista> rec = new HashMap <String, Recepcionista>();
	private static Map <String, Empleado> emp = new HashMap <String, Empleado>();
	

	@Override
	public Empleado recupera_empleado(Empleado empleado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Doctor> recuperaAllempleadosDoc() {
		Collection <Doctor> coll = doc.values();
		return new ArrayList<Doctor>(coll);
	}

	@Override
	public ArrayList<Recepcionista> recuperaAllempleadosRec() {
		Collection <Recepcionista> coll = rec.values();
		return new ArrayList<Recepcionista>(coll);
	}
	
	@Override
	public boolean crea_paciente(Paciente paciente) {
		 System.out.println(paciente.getId_paciente());
		return (pac.put(paciente.getId_paciente(), paciente)!=null);
	}
	
	@Override
	public boolean crea_empleadoDoc(Empleado empleado) {
		// TODO Auto-generated method stub
		return (emp.put(empleado.getId_empleado(),empleado)!=null);
	}

	@Override
	public boolean crea_empleadoRecep(Empleado empleado) {
		// TODO Auto-generated method stub
		return (emp.put(empleado.getId_empleado(),empleado)!=null);
	}

	@Override
	public boolean elimina_empleado(String ID) {
		// TODO Auto-generated method stub
		return (emp.remove(ID)!=null);
	}

	@Override
	public ArrayList<HistorialMedico> recuperaHistorialMedico(String IDPaciente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paciente recupera_paciente(Paciente paciente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pago recupera_pago(Paciente paciente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Reporte> recuperaServicio(String periodo) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public String verificaUsuario(String nombre, String contra) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String recuperaNombrePaciente(String idPaciente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String recuperaCURPPaciente(String idPaciente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean recuperaIDPaciente(String idPaciente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean recuperaEspecialidad(String especialidad) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Paciente recuperaPaciente(int idPago) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paciente recuperaPaciente(String idPaciente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pago recuperaPago(int Pago) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean elimina_paciente(String ID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Paciente> recuperaAllPaciente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Consulta> recuperaAllCitas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Consulta recuperaCita(String idPaciente) {
		// TODO Auto-generated method stub
		return null;
	}

}
