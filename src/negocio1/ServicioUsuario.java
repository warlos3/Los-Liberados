package negocio1;

public interface ServicioUsuario {
	
	public String verificaUsuario(String nombre, String contrasena);
	public void recuperaContra(String nombre);
	public boolean cambiarContra(String idUsuario, String contra);

}
