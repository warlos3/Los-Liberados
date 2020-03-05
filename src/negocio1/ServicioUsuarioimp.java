/******************************************************************/ 
/* INFORMACION */

/* Programa: Cruz Roja */ 


/* Autor:  Todo el equipo de desarrollo */ 

/* Descripción: Este servicio es el encargado de lo relacionado con el usuario, es decir, con la persona
 * 				que tiene acceso al sistema (Doctor o recepcionista). 
 * 				Este servicio se comunica con e DAOCruzRoja mediante los diferentes métodos que se manejan, 
 * 				se puede verificar usuario (para iniciar sesión y tener acceso al sistema), 
 * 				así como recuperar contrasena o cambiarla si así se desea por parte del usuario.
 */ 

/******************************************************************/

/* Contenido del Listado:
 * 		- public String verificaUsuario(String nombre, String contrasena);
 * 		- public void recuperaContra(String nombre);
 */

/******************************************************************/

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

	/******************************************************************/ 
	/* Se comunica con el DAO para recuperar un usuario de la aplicación y saber a que tipo de empleado corresponde
	 * @param nombre
	 * @param contra
	 * @return Doctor o Recepcionista
	 */
	public String verificaUsuario(String nombre, String contra) {
		// TODO Auto-generated method stub
		return dao.verificaUsuario(nombre,contra);
	}//fin de método verificaUsuario

	/******************************************************************/ 
	/**/
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
		return dao.updateContra(idUsuario, contra);
	}

}//fin de la clase ServicioUsuarioimp
