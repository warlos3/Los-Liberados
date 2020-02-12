package presentacion;

import negocio1.ServicioPaciente;
import negocio.dominio.Paciente;
import negocio.dominio.Pago;

public class ControlFichaMedica {

	private ServicioPaciente servicioPaciente;
	//Ventana
	private VentanaFichaMedica ventana;
	
	public ControlFichaMedica(ServicioPaciente servicioPaciente) {
		this.servicioPaciente=servicioPaciente;
	}
	
	public void inicia(Pago pago, Paciente paciente) { 
		ventana=new VentanaFichaMedica(this, pago, paciente);
		ventana.setVisible(true);
	}
	
}
