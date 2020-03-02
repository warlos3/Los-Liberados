package negocio1;

import java.util.ArrayList;
import datos.DAOCruzRoja;
import negocio.dominio.Consulta;
import negocio.dominio.Paciente;

public class ServicioConsultaimp implements ServicioConsulta{
	
	private DAOCruzRoja dao;

	public ServicioConsultaimp(DAOCruzRoja dao) {
		this.dao=dao;
	}

	@Override
	public boolean verificaServicio(String especialidad) {
		if(dao.recuperaEspecialidad(especialidad)) { //llama al DAO para verificar existencia del servicio
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean actulizaDatos(String fecha, String observaciones) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public ArrayList<Consulta> recuperaAllCitas() {
		return dao.recuperaAllCitas();
	}
	
	@Override
	public Consulta recuperaCita(String idPaciente) {
		return dao.recuperaCita(idPaciente);
	}
	
	@Override
	public Paciente recuperaPaciente(String idPaciente) {
		return dao.recuperaPaciente(idPaciente);
	}

	public ArrayList<Consulta> recuperaAllServicios(){
		return dao.recuperaAllServicios();
	}
}
