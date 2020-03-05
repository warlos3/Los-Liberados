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

import datos.DAOCruzRoja;
import negocio.dominio.Reporte;


public class ServicioReporteImp implements ServicioReporte{
	
	private DAOCruzRoja dao;
	
	/**
	 * Constructor
	 * @param dao
	 */
	public ServicioReporteImp(DAOCruzRoja dao) {
		this.dao=dao;
	}

	/******************************************************************/ 
	/* Se comunica con el DAO de servicio para recuperar los servicios prestados en el periodo establecido
	 * @param periodo El periodo que se quiere consultar
	 * @return Devuelve una lista de tipo reporte
	 */
	public ArrayList<Reporte> consultaServicio(String periodo) {

		ArrayList<Reporte> reporte = new ArrayList<Reporte>();
		//Recibe la lista 
		reporte=dao.recuperaServicio(periodo);
		return reporte;
		
	}//fin de método consultaServicio
	
}//fin de la clase ServicioReporteimp