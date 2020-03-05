package presentacion;
/******************************************************************/ 
/* Clase de controlUsuario  
/* Autor: Ramirez Ortega Omar Daniel  
/* Descripción: Sirve para poder dar instrucciones a la ventana y el poder recuperar 
   informacion necesaria que se necesite conectandose con el servicioUsuario 
/******************************************************************/ 

import negocio1.ServicioUsuario;

/******************************************************************/ 
/* Contenido del Listado:
/* public ControlUsuario(ServicioUsuario servicioUsuario)
/* public String verificaUsuario(String nombre, String contra)
/* public boolean cambiaContra(String idUsuario, String contra)
/******************************************************************/ 

public class ControlUsuario {

	private ServicioUsuario servicioUsuario;
	//servicioUsuario nos servira para crear la conexion con el servicio
	
	//Constructor de la clase ControlUsuario
	public ControlUsuario(ServicioUsuario servicioUsuario) {
		this.servicioUsuario=servicioUsuario;
	}

	/***************************************************************
	 * Esta funcion regresa una cadena para verificar si el usuario
	 * que esta ingresando es doctor o recepcionista
	 * Recibe como parametros dos cadenas el cual uno es el ID del usuario
	 * y el otro es la contraseña para poder ingresar.
	 * Si no se encuentra el usuario o los datos son incorrectos retorna "ninguno"
	 **************************************************************/
	public String verificaUsuario(String nombre, String contra) {
		return servicioUsuario.verificaUsuario(nombre, contra);
	}

	/***************************************************************
	 * Esta funcion regresa un booleano para indicar que la contraseña fue cambiada
	 * correctamente o regresa false si no se encontro el usuario
	 * Recibe como parametros dos cadenas el cual uno es el ID del usuario
	 * y el otro es la contraseña
	 **************************************************************/
	public boolean cambiaContra(String idUsuario, String contra) {
		System.out.println("Control2 " + idUsuario);
		return servicioUsuario.cambiarContra(idUsuario, contra);
	}
}
