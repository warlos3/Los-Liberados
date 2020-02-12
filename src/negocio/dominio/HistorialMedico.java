package negocio.dominio;

/**
 *Entidad historial medico
 * @author Brianda Garcia
 *
 */
public class HistorialMedico {

	private String observaciones;
	private String fecha;
	private String tipoDeServicio;

	/**
	 * Guarda las observaciones
	 * @param observaciones observaciones a guardar
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	/**
	 * Guarda el servicio
	 * @param tipoDeServicio servicio a guardar
	 */
	public void setTipoDeServicio(String tipoDeServicio) {
		this.tipoDeServicio = tipoDeServicio;
	}
	
	/**
	 * Guarda la fecha
	 * @param fecha fecha a guardar
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * Regresa las observaciones guardadas 
	 * @return observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * Regresa el servicio guardado
	 * @return tipoDeServicio
	 */
	public String getTipoDeServicio() {
		return tipoDeServicio;
	}
	
	/**
	 * Regresa la fecha guardada
	 * @return fecha
	 */
	public String getFecha() {
		return fecha;
	}
}