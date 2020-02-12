package testNegocio;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import datos.DAOCruzRoja;
import datos.ManejadorBaseDatos;
import negocio.dominio.Empleado;
import negocio1.ServicioEmpleado;
import negocio1.ServicioEmpleadoimp;
import test.DAOCRUZROJAMock;

class ServicioEmpleadoimpTest {

	static ServicioEmpleado servicio;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		DAOCruzRoja dao=new DAOCRUZROJAMock();
		servicio=new ServicioEmpleadoimp(dao);
		Statement statement = ManejadorBaseDatos.getConnection().createStatement();
		
		Empleado doc=new Empleado();

		doc.setNombre("luis");
		doc.setApellido("sadasd");
		doc.setEdad(45);
		doc.setEmail("asdasd");
		doc.setDireccion("asdas");
		doc.setEscolaridad("asdas");
		doc.setCedulaProfesional("dasasd");
		doc.setEspecialidad("asdas");
		doc.setFecha_ingreso("asd");
		doc.setHorario("asd");
		doc.setSexo("M");
		doc.setTelefono("asdd");
		doc.setId_empleado("ppp");
		dao.crea_empleadoDoc(doc);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}


	@Test
	public void EliminaEmpleado() {
		boolean resultado=servicio.EliminaEmpleado("ppp");
		assertEquals("Regreso false en vez de true al eliminar un empleado que existe en BD", resultado,true);
	}

}
