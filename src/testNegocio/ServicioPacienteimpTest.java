package testNegocio;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import datos.DAOCCruzRoja;
import datos.DAOCruzRoja;
import datos.ManejadorBaseDatos;
import negocio.dominio.Doctor;
import negocio.dominio.Empleado;
import negocio.dominio.Paciente;
import negocio1.ServicioEmpleado;
import negocio1.ServicioEmpleadoimp;
import negocio1.ServicioPaciente;
import negocio1.ServicioPacienteimp;
import test.DAOCRUZROJAMock;

class ServicioPacienteimpTest {


	static ServicioPaciente servicio;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		DAOCruzRoja dao=new DAOCRUZROJAMock();
		servicio=new ServicioPacienteimp(dao);
	
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/*@Test
	public void nuevo_paciente() {
		boolean resultado=servicio.nuevo_paciente("Luis", "dsad", "asda",  "adasd",  "asdad", 23,  "asdad",  "asdasd", "asdas","mmm");
		assertEquals("Regreso false al registrar un paciente que no esta registrado en la base de datos",resultado);
	}*/
	
	@Test
	public void testobtenPaciente() {
		
		Paciente paciente = servicio.obtenPaciente("a24F1");
		String resultado = "a24F1";
		String idPaciente = paciente.getId_paciente();
		assertEquals(resultado, idPaciente);
		
	}

}
