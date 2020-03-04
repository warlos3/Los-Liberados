
package negocio1;

import java.util.ArrayList;
import negocio.dominio.Consulta;
import negocio.dominio.Paciente;

public interface ServicioConsulta {

	public boolean verificaServicio(String especialidad);
	
	public boolean actulizaDatos(String fecha,String observaciones);
	
	public ArrayList<Consulta> recuperaAllCitas();
	
	public Consulta recuperaCita(String idCita);
	
	public Paciente recuperaPaciente(String idCita);
		
}
