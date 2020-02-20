package apli;

import datos.DAOCCruzRoja;


import negocio1.ServicioEmpleadoimp;
import negocio1.ServicioPaciente;
import negocio1.ServicioUsuarioimp;
import presentacion.ControlEliminaEmpleado;
import presentacion.ControlNuevoPpaciente;
import presentacion.ControlPrincipal;
import presentacion.ControlUsuario;
import presentacion.Controlagregaempleado;
import presentacion.ControlFichaMedica;
import presentacion.ControlVerificacionPago;
import presentacion.ControlExamenMedico;
import negocio1.ServicioPacienteimp;
import negocio1.ServicioReporte;
import negocio1.ServicioReporteImp;
import negocio1.ServicioUsuario;
import negocio1.ServicioConsulta;
import negocio1.ServicioConsultaimp;
import negocio1.ServicioEmpleado;
import presentacion.*;

/**
 * Aplicacion
 * @author 
 *
 */
public class Aplicacion {
	
	//Modulos de la aplicación
	private static ControlPrincipal controlPrincipal;
	private static ControlNuevoPpaciente control_nuevo_paciente;
	private static Controlagregaempleado control_agrega_empleado;
	private static ControlEliminaEmpleado control_elima_emp;
	private static ControlEliminaPaciente control_elima_pac;
	private static ControlBusquedaPaciente controlBusquedaPaciente;
	private static ControlReporteFinanciero controlReporteFinanciero;
	private static ControlUsuario controlUsuario;
	private static ControlGeneraEspecialidad controlGeneraEspecialidad;
	private static ControlVerificacionPago controlVerificaPago;
	private static ControlFichaMedica controlFichaMedica;
	private static ControlExamenMedico controlExamenMedico;
	private static ControlEliminaPaciente controlEliminaPaciente;
	private static ControlCitas controlCitas;
	private static ControlBusquedaHorarios controlbusquedahorarios;
	
	private static ServicioEmpleado servicio_empleadoagrega;
	private static ServicioPaciente servicioPaciente;
	private static ServicioEmpleado servicio_empleado;
	private static ServicioReporte servicioReporte;
	private static ServicioConsulta servicioConsulta;
	private static ServicioUsuario servicioUsuario;

	private static DAOCCruzRoja dao;

	/**
	 * Inicia la aplicacion
	 * @param args
	 */
	public static void main(String[] args) {
		
		crea_y_conecta_modulos();
		controlPrincipal.inicia();
	}
	
	/**
	 *Conecta los modulos de la aplicación
	 */
	public static void crea_y_conecta_modulos() {
		dao=new DAOCCruzRoja();

		servicioUsuario = new ServicioUsuarioimp(dao);
		servicioPaciente=new ServicioPacienteimp(dao);
		servicio_empleado=new ServicioEmpleadoimp(dao);
		servicioReporte = new ServicioReporteImp(dao);
		servicioConsulta = new ServicioConsultaimp(dao);
		
		
		controlCitas=new ControlCitas(servicioConsulta);
		controlEliminaPaciente=new ControlEliminaPaciente(servicioPaciente);
		controlUsuario=new ControlUsuario(servicioUsuario);
		control_nuevo_paciente=new ControlNuevoPpaciente(servicioPaciente);
		control_elima_emp=new ControlEliminaEmpleado(servicio_empleado);
		control_agrega_empleado = new Controlagregaempleado(servicio_empleado);
		controlFichaMedica=new ControlFichaMedica(servicioPaciente);
		controlVerificaPago=new ControlVerificacionPago(servicioPaciente);
		controlExamenMedico=new ControlExamenMedico(servicioPaciente);
		controlBusquedaPaciente = new ControlBusquedaPaciente(servicioPaciente);
		controlGeneraEspecialidad = new ControlGeneraEspecialidad(servicioPaciente, servicioConsulta);
		controlReporteFinanciero = new ControlReporteFinanciero(servicioReporte);
		controlbusquedahorarios=new ControlBusquedaHorarios(servicio_empleado);
		controlPrincipal=new ControlPrincipal(control_nuevo_paciente,control_agrega_empleado,
												control_elima_emp,controlBusquedaPaciente,controlReporteFinanciero,controlUsuario,controlGeneraEspecialidad,
												controlVerificaPago, controlFichaMedica, controlExamenMedico, controlEliminaPaciente, controlCitas,controlbusquedahorarios);		
		
	}
}