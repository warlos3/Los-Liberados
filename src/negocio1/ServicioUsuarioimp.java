/******************************************************************/ 
/* INFORMACION */

/* Programa: Cruz Roja */ 


/* Autor:  Todo el equipo de desarrollo */ 

/* Descripci�n: Este servicio es el encargado de lo relacionado con el usuario, es decir, con la persona
 * 				que tiene acceso al sistema (Doctor o recepcionista). 
 * 				Este servicio se comunica con e DAOCruzRoja mediante los diferentes m�todos que se manejan, 
 * 				se puede verificar usuario (para iniciar sesi�n y tener acceso al sistema), 
 * 				as� como recuperar contrasena o cambiarla si as� se desea por parte del usuario.
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
	/* Se comunica con el DAO para recuperar un usuario de la aplicaci�n y saber a que tipo de empleado corresponde
	 * @param nombre
	 * @param contra
	 * @return Doctor o Recepcionista
	 */
	public String verificaUsuario(String nombre, String contra) {
		// TODO Auto-generated method stub
		return dao.verificaUsuario(nombre,contra);
	}//fin de m�todo verificaUsuario

	/******************************************************************/ 
	/**/
	public void recuperaContra(String nombre) {
		// TODO Auto-generated method stub
	}
	
	/***************************************************************
	 * Esta funcion recibe el id del usuario y la nueva contrase�a que 
	 * eligio el usuario que se encuentra registrado en la base de datos
	 * Si la contrase�a se cambio con exito regresa True, si no se pudo
	 * realizar los cambios regresa False
	 **************************************************************/
	public boolean cambiarContra(String idUsuario, String contra) {
		return dao.updateContra(idUsuario, contra);
	}

}//fin de la clase ServicioUsuarioimp
