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
	
	/***************************************************************
	 * Esta funcion recibe el id del usuario y la nueva contraseña que 
	 * eligio el usuario que se encuentra registrado en la base de datos
	 * Si la contraseña se cambio con exito regresa True, si no se pudo
	 * realizar los cambios regresa False
	 **************************************************************/
	public boolean cambiarContra(String idUsuario, String contra) {
		return dao.updateContraseña(idUsuario, contra);
	}
	
}
