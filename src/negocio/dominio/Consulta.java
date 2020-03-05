package negocio.dominio;

public class Consulta {
	
	private String idServicio;
	private String idconsulta;
	private String tipoServicio;
	private String fecha;
	private String hora;
	private String costo;
	private String cantidad;
	

	public String getIDServicio() {
		return idServicio;
	}
	public void setIDServicio(String idServicio) {
		this.idServicio = idServicio;
	}
	public String getIDConsulta() {
		return idconsulta;
	}
	public void setIDConsulta(String idconsulta) {
		this.idconsulta = idconsulta;
	}
	public String getTipoServicio() {
		return tipoServicio;
	}
	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora=hora;
	}
	public String getCosto() {
		return costo;
	}
	public void setCosto(String costo) {
		this.costo=costo;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad=cantidad;
	}
	

	

}
