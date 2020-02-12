package presentacion;

import negocio1.ServicioPaciente;
import negocio.dominio.Paciente;
import negocio.dominio.Pago;

public class ControlVerificacionPago {
	//servicio de la capa de negocio
		private ServicioPaciente servicioPaciente;
		//Ventana
		private VentanaVerificaPago ventana;
		
		//Conexion
		public ControlVerificacionPago(ServicioPaciente servicioPaciente) {
			this.servicioPaciente=servicioPaciente;
		}
		
		//Inicia la ventana de verificacion
		public void inicia() { 
			ventana=new VentanaVerificaPago(this);
			ventana.setVisible(true);
		}
		
		public void verificaPago(int idPago) {
			Pago pago = new Pago();
			Paciente paciente = new Paciente();
			//A traves del servicio le manda el idPago para recuperar un paciente y lo almacena en la variable paciente
			pago = servicioPaciente.verificaPago(idPago);
			//A traves del servicio le manda el idPago para recuperar un paciente y lo almacena en la variable paciente
			paciente = servicioPaciente.obtenPaciente(idPago);
			//Cuando el retorno es distinto de nulo quiere decir que fue realizado el pago, de lo contrario el pago no se efectuo
			if(pago != null) {
				ventana.setVisible(false);
				ventana.ventanaExito(this, pago, paciente);
			}
			else {
				ventana.ventanaError(this);
			}
		}
}
