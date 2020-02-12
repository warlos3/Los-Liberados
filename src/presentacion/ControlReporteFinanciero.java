package presentacion;

import java.util.ArrayList;

import negocio1.ServicioReporte;
import negocio.dominio.Reporte;

/**
 * Clase que controla el funcionamiento de la generacion de reportes financieros
 * @author Brianda Garcia
 *
 */
public class ControlReporteFinanciero {
	
	//Ventana de seleccion del periodo para el reporte financiero;
	private VentanaReporteFinanciero ventana;				
	//Ventana que muestra el reporte financiero;
	private VentanaMuestraReporte ventana2;
	//Servicio en la capa de negocio
	private ServicioReporte servicioReporte;
	
	ArrayList<Reporte> reporte;
	
	/**
	 * Constructor
	 * @param servicio
	 */
	public ControlReporteFinanciero(ServicioReporte servicio) {
		this.servicioReporte = servicio;
	}
	
	/**
	 * El control inicia la ventana para la HU
	 */
	public void inicia() {		
		
		//El sistema muestra la ventana de reporte financiero
		ventana = new VentanaReporteFinanciero(this);
		ventana.abre();
	}
	
	/**
	 * Hace la comunicacion con el servicio de reporte
	 * @param periodo periodo del cual se requiere generar el reporte financiero 
	 */
	public void consultaServicio(String periodo) {

		//Recibe la lista con el reporte financiero
		reporte = servicioReporte.consultaServicio(periodo);
		ventana2=new VentanaMuestraReporte(this, reporte, periodo);
		//Valida que sea un periodo valido
		if(reporte.size()==0) {
			ventana.muestraMensaje("Selecciona un periodo valido");
		}
		else {
			//El sistema muestra la ventana que despliega el reporte financiero
			ventana2.abre();
		}
		//El sistema cierra la ventana de eleccion de periodo para generar un reporte financiero
		ventana.cierra();
	}
}