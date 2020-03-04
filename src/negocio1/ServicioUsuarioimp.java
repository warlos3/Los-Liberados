package negocio1;

import datos.DAOCruzRoja;

public class ServicioUsuarioimp implements ServicioUsuario {
	
	private DAOCruzRoja dao;

	/*
	 * Constructor del ServicioUsuarioimp
	 */
	public ServicioUsuarioimp(DAOCruzRoja dao) {
		this.dao=dao;
	}

	/*
	 * Se comunica con el DAO para recuperar un usuario de la aplicación y saber a que tipo de empleado corresponde
	 * @param nombre
	 * @param contra
	 * @return Doctor o Recepcionista
	 */
	public String verificaUsuario(String nombre, String contra) {
		// TODO Auto-generated method stub
		return dao.verificaUsuario(nombre,contra);
	}

	
	public void recuperaContra(String nombre) {
		// TODO Auto-generated method stub
	}
	
	public boolean cambiarContra(String idUsuario, String contra) {
		return dao.updateContraseña(idUsuario, contra);
	}
	
	

}
