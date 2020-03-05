/******************************************************************/ 
/* INFORMACION */



/* Programa: Cruz Roja */ 


/* Autor:  Todo el equipo de desarrollo */ 

/* Descripción: Este servicio es el encargado de todo lo relacionado con los reportes de la empresa, 
 * 				un reporte mensual acerca de las consultas que se han hecho a lo largo de cierto periodo.
 */ 

/******************************************************************/

/* Contenido del Listado:
 * 		- public ArrayList<Reporte> consultaServicio(String periodo);
 */

/******************************************************************/

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