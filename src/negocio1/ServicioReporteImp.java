package negocio1;

import java.util.ArrayList;

import datos.DAOCruzRoja;
import negocio.dominio.Reporte;

/**
 * Implementacion del servicio reporte
 * @author Brianda Garcia
 *
 */
public class ServicioReporteImp implements ServicioReporte{
	
	private DAOCruzRoja dao;
	
	/**
	 * Constructor
	 * @param dao
	 */
	public ServicioReporteImp(DAOCruzRoja dao) {
		this.dao=dao;
	}

	/**
	 * Se comunica con el DAO de servicio para recuperar los servicios prestados en el periodo establecido
	 * @param periodo El periodo que se quiere consultar
	 * @return Devuelve una lista de tipo reporte
	 */
	public ArrayList<Reporte> consultaServicio(String periodo) {

		ArrayList<Reporte> reporte = new ArrayList<Reporte>();
		//Recibe la lista 
		reporte=dao.recuperaServicio(periodo);
		return reporte;
	}
}