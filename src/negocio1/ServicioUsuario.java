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

public interface ServicioUsuario {
	
	public String verificaUsuario(String nombre, String contrasena);
	
	public void recuperaContra(String nombre);
	
	public boolean cambiarContra(String idUsuario, String contra);
	
}
