package presentacion;

import negocio.dominio.Paciente;
import negocio.dominio.Pago;
import negocio1.ServicioPaciente;

public class ControlExamenMedico {
	private ServicioPaciente servicioPaciente;
	//Ventana
	private VentanaExamenMedico ventana;
	
	public ControlExamenMedico( ServicioPaciente servicioPaciente) {
		this.servicioPaciente=servicioPaciente;
	}
	
	public void inicia() { 
		ventana=new VentanaExamenMedico(this);
		ventana.setVisible(true);
	}
	
	public void ObtenPaciente(String idPaciente) {
		Pago pago = new Pago();
		Paciente paciente = new Paciente();
		//A traves del servicio le manda el idPago para recuperar un paciente y lo almacena en la variable paciente
		paciente = servicioPaciente.obtenPaciente(idPaciente);
		//Cuando el retorno es distinto de nulo quiere decir que fue realizado el pago, de lo contrario el pago no se efectuo
		if(paciente != null) {
			ventana.setVisible(false);
			ventana.llenaCampos(paciente);
		}
		else {
			
		}
	}
}
