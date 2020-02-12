package negocio.dominio;

public class Consulta {
	
	private String idconsulta;
	private String tipo_de_servicio;
	private String fecha;
	private String hora;
	
	public String getIDConsulta() {
		return idconsulta;
	}
	public void setIDConsulta(String idconsulta) {
		this.idconsulta = idconsulta;
	}
	public String getTipo_de_servicio() {
		return tipo_de_servicio;
	}
	public void setTipo_de_servicio(String tipo_de_servicio) {
		this.tipo_de_servicio = tipo_de_servicio;
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
	

	

}
