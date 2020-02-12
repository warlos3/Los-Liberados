package negocio1;

import java.util.ArrayList;

import negocio.dominio.Reporte;

/**
 * Interface del servicio reporte
 * @author Brianda Garcia
 *
 */
public interface ServicioReporte {
	
	/**
	 * Consulta los servicios requeridos en un periodo determinado
	 * @param periodo el periodo en el que se requirieron los servicios
	 * @return regresa una lista de tipo Reporte con toda la informacion de los pagos realizados en el periodo solicitado
	 */
	public ArrayList<Reporte> consultaServicio(String periodo);
}