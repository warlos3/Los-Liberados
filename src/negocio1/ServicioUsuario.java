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

public interface ServicioUsuario {
	
	public String verificaUsuario(String nombre, String contrasena);
	
	public void recuperaContra(String nombre);
	
	public boolean cambiarContra(String idUsuario, String contra);
	
}
