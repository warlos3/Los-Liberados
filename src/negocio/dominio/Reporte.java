package negocio.dominio;

/**
 * Objeto reporte
 * @author Brianda Garcia
 *
 */
public class Reporte {

	private String servicio;
	private String fecha;
	private int total;
	
	/**
	 * Guarda la fecha
	 * @param fecha fecha a guardar
	 */
	public void setFecha(String fecha) {
		this.fecha=fecha;
	}
	
	/**
	 * Guarda el servicio
	 * @param servicio servicio a guardar
	 */
	public void setServicio(String servicio) {
		this.servicio=servicio;
	}

	/**
	 * Guarda el total
	 * @param total cantidad a guardar
	 */
	public void setTotal(int total) {
		this.total=total;
	}
	
	/**
	 * Regresa la fecha
	 * @return fecha
	 */
	public String getFecha() {
		return fecha;
	}
	
	/**
	 * Regresa el servicio
	 * @return servicio
	 */
	public String getServicio() {
		return servicio;
	}
	
	/**
	 * Regresa el costo
	 * @return total
	 */
	public int getTotal() {
		return total;
	}
}