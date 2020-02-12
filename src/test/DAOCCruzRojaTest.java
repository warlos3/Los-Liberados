package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import datos.DAOCCruzRoja;
import datos.ManejadorBaseDatos;
import negocio.dominio.Doctor;
import negocio.dominio.Paciente;

class DAOCCruzRojaTest {

	static DAOCCruzRoja dao;
	static int id_empleado;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		dao=new DAOCCruzRoja();
		Statement statement = ManejadorBaseDatos.getConnection().createStatement();
		
		try {
			statement.execute("INSERT INTO doctor values ('aaa','fernando','feranndo','2019-05-30',23,'hola','qw','er','M','dsd','asdasd','marutio')");
			statement.execute("INSERT INTO Recepcionista values ('bbb','raul','feranndo','2019-05-30',23,'hola','qw','er','M','dsd','asdasd')");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	

		ManejadorBaseDatos.shutdown();
	}

	@Test
	public void testnuevo_empleado() {
		
		//caso de prueba 1 agregamos un paciente
		Paciente paciente=new Paciente();
		paciente.setNombre("Luis");
		paciente.setApellido("Fernando");
		paciente.setEdad(23);
		paciente.setEmail("hola@gmail.com");
		paciente.setFecha_nacimiento("1996/30/09");
		paciente.setSexo("M");
		paciente.setTelefono("55-55-55-55-55");
		paciente.setCURP("DAHSDJKHAKSJDHKA");
		paciente.setDireccion("dalshdjashda");
		paciente.setId_paciente("ooooooo");
		
		boolean resultado =dao.crea_paciente(paciente);
		assertEquals("Regreso false en vez de true al crear al paciente que no existe en BD", resultado,true);
		
		
		//caso de prueba 2 agregamos un paciente ya existente 
		resultado=dao.crea_paciente(paciente);
		assertEquals("Regreso true cuando debia de regresar false al haber un paciente",resultado,false);
		
		try {
			// Crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
				
			statement.execute("DELETE FROM Paciente WHERE idPaciente ='"+paciente.getId_paciente()+"' ");
		} catch(SQLException e ) {
			e.printStackTrace();
		}
		
		
	}
	
	public void testeliminaempleado() {
		
		
		//caso de prueba 1
		//eliminamos un doctor
		boolean resultado=dao.elimina_empleado("aaa");
		assertEquals("Regreso false en vez de true al eliminar un empleado existente",resultado,true);
		//eliminanos una recepcionista
		resultado=dao.elimina_empleado("bbb");
		assertEquals("Regreso false en vez de true al eliminar un empleado existente",resultado,true);
		
		
		//caso 2 eliminamos un empleado que no existe
		resultado=dao.elimina_empleado("aaa");
		assertEquals("Regreso true en vez de false al eliminar un empleado que no existente",resultado,false);
	}
	
	
	



}
