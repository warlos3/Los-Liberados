package presentacion;

import datos.ManejadorBaseDatos;

import negocio1.ServicioUsuarioimp;

public class ControlPrincipal {
	//Ventana Principal
	private VentanaPrincipal ventana;
	private VentanaDoctor ventanaDoc;
	private VentanaRecepcionista ventanaRec;
	
	private  ControlNuevoPpaciente control_nuevo_paciente;
	private ControlEliminaEmpleado control_elimina_emp;
	private Controlagregaempleado control_agrega_empleado;
	private ControlBusquedaPaciente controlBusquedaPaciente;
	private ControlReporteFinanciero controlReporteFinanciero;
	private ControlUsuario control_Usuario;
	private ControlGeneraEspecialidad controlGeneraEspecialidad;
	private ControlVerificacionPago controlVerificaPago;
	private ControlFichaMedica controlFichaMedica;
	private ControlExamenMedico controlExamenMedico;
	private ControlEliminaPaciente controlEliminaPaciente;
	private ControlCitas controlCitas;
	private ControlBuquedaHorarios controlBusquedaHorarios;
	private ControlMuestraServicios controlMuestraServicios;
	
	public ControlPrincipal(ControlNuevoPpaciente control_nuevo_paciente,Controlagregaempleado control_agrega_empleado,
			ControlEliminaEmpleado control_elimina_emp,ControlBusquedaPaciente controlBusquedaPaciente,
			ControlReporteFinanciero controlReporteFinanciero, ControlUsuario control_Usuario, ControlGeneraEspecialidad controlGeneraEspecialidad,
			ControlVerificacionPago controlVerificaPago, ControlFichaMedica controlFichaMedica, ControlExamenMedico controlExamenMedico,
			ControlEliminaPaciente controlEliminaPaciente, ControlCitas controlCitas, ControlBuquedaHorarios controlBusquedaHorarios,
			ControlMuestraServicios controlMuestraServicios) {
		
		this.control_nuevo_paciente=control_nuevo_paciente;
		this.control_elimina_emp=control_elimina_emp;
		this.control_agrega_empleado=control_agrega_empleado;
		this.controlBusquedaPaciente=controlBusquedaPaciente;
		this.controlGeneraEspecialidad=controlGeneraEspecialidad;
		this.controlReporteFinanciero=controlReporteFinanciero;
		this.control_Usuario=control_Usuario;
		this.controlVerificaPago=controlVerificaPago;
		this.controlFichaMedica=controlFichaMedica;
		this.controlExamenMedico=controlExamenMedico;
		this.controlEliminaPaciente=controlEliminaPaciente;
		this.controlCitas=controlCitas;
		this.controlBusquedaHorarios = controlBusquedaHorarios;
		this.controlMuestraServicios = controlMuestraServicios;
	}
	
	/*
	 * Inicia el control principal
	 */
	public void inicia() {
		ventana=new VentanaPrincipal(this);
		ventana.abre();
	}
	
	public void cerrarsecion() {
		ventana.abre();
	}
	
	/*
	 * Inicia la historia de usuario de nuevo paciente
	 */
	public void ventanaDoc() {
		ventanaDoc=new VentanaDoctor(this);
		ventanaDoc.abre();
	}
	
	public void ventanaRec() {
		ventanaRec=new VentanaRecepcionista(this);
		ventanaRec.abre();
	}
	
	public String login(String nombre, String contra) {
		return control_Usuario.verificaUsuario(nombre, contra);
	}
	
	public  void nuevo_paciente() {
		control_nuevo_paciente.inicia();
	}
	public void agrega_emplado() {
		control_agrega_empleado.inicia();
	}
	public void eliminaEmpleado() {
		control_elimina_emp.inicia();
	}
    
	public void BusquedaHorario() {
		controlBusquedaHorarios.inicia();
	}

	/**
	 * Inicia la historia de usuario de busqueda de paciente
	 */
	public void busquedaPaciente() {
		controlBusquedaPaciente.inicia();
	}
	
	/**
	 * Inicia la historia de usuario de reporte financiero
	 */
	public void reporteFinanciero() {
		controlReporteFinanciero.inicia();
	}
	
	public void termina() {
		ManejadorBaseDatos.shutdown();
		
	}

	public void generaPase() {
		controlGeneraEspecialidad.inicia();
		
	}
	
	public void verificaPago() {
		controlVerificaPago.inicia();;
	}
	
	public void generaExamenMedico() {
		controlExamenMedico.inicia();
	}
	public void eliminaPaciente() {
		controlEliminaPaciente.inicia();
	}
	
	public void muestraCitas() {
		controlCitas.inicia();
	}
	public void buscaHorario() {
		controlBusquedaHorarios.inicia();
	}
	
	public void muestraServicios() {
		controlMuestraServicios.inicia();
	}
}
